package com.example.trojans.controller;

import com.example.trojans.model.Project;
import com.example.trojans.model.Task;
import com.example.trojans.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProjectController {
    final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects(
            @RequestParam(required = false) String title) {

        try {
            List<Project> projects = new ArrayList<Project>();
            if (title == null) {
                projects.addAll(projectRepository.findAll());
            } else {
                projects.addAll(projectRepository.findByTitle(title));
            }
            if(projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") long projectId) {
        Optional<Project> projectData = projectRepository.findById(projectId);
        return projectData.map(project -> new ResponseEntity<>(project, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        try {
            Project _project = projectRepository.save(new Project(project.getTitle()));
            return  new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/projects/{id}")
    public  ResponseEntity<Project> updateProject(@PathVariable("id") long projectId, @RequestBody Project project) {
    	Project _project = projectRepository.findByProjectId(projectId);
        if (_project != null) {
            _project.setTitle(project.getTitle());
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/projects/{id}/unassingee")
    public  ResponseEntity<Project> unAssingeeProject(@PathVariable("id") long projectId, @RequestBody List<Task> tasks) {
    	Project _project = projectRepository.findByProjectId(projectId);
        if (_project != null) {
            _project.setTaskList(tasks);
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long projectId) {
        try {
            projectRepository.deleteById(projectId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/projects")
    public ResponseEntity<HttpStatus> deleteAllProjects() {
        try {
            projectRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
