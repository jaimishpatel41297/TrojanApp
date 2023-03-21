package com.example.trojans.controller;

import com.example.trojans.model.Project;
import com.example.trojans.model.Task;
import com.example.trojans.repository.ProjectRepository;
import com.example.trojans.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {
	private final TaskRepository taskRepository;
	private final ProjectRepository projectRepository;

	@Autowired
	public TaskController(TaskRepository taskRepository, ProjectRepository projectRepository) {
		this.taskRepository = taskRepository;
		this.projectRepository = projectRepository;
	}

	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getTasks(
			@RequestParam(required = false) String name) {
		try {
			List<Task> tasks = new ArrayList<>();
			if (name == null) {
				tasks.addAll(taskRepository.findAll());
			} else {
				tasks.addAll(taskRepository.findByName(name));
			}
			if (tasks.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") long id) {
		Optional<Task> task = taskRepository.findById(id);
		return task.map(task1 -> new ResponseEntity<>(task1, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/tasks")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		try {
			Task _task = taskRepository.save(task);
			return new ResponseEntity<>(_task, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") long taskId, @RequestBody Task task) {
		Optional<Task> optionalTask = taskRepository.findById(taskId);
		if (optionalTask.isPresent()) {
			Task _task = optionalTask.get();
			_task.setPriority(task.getPriority());
			_task.setCompleted(task.isCompleted());
			_task.setDate(task.getDate());
			_task.setName(task.getName());
			return new ResponseEntity<>(taskRepository.save(_task), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") long taskId) {
		try {
			taskRepository.deleteById(taskId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tasks")
	public ResponseEntity<HttpStatus> deleteAll() {
		try {
			taskRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	  @PutMapping(value = "/tasks/{id}/assignproject" , produces =
	  "application/json") public ResponseEntity<Project>
	  assignProject(@PathVariable("id") long taskId,
	  
	  @RequestParam("projectId") long projectId) { final Optional<Task> byId =
	  taskRepository.findById(taskId); final Project project =
	  projectRepository.findByProjectId(projectId); if(project != null){
	  if(byId.isPresent()){ final Task task = byId.get();
	  project.getTaskList().add(task); } projectRepository.save(project); return
	  new ResponseEntity<>(project, HttpStatus.OK); } return new
	  ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 
}
