package com.example.trojans.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projectId;
	private String title;
	@OneToMany
	private List<Task> tasks;

//    @JsonIgnore // To advoid from infinite recursion when creating json object because course
//    // has a collection of students
//    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }) // Many to many
//    @JoinTable(name = "projects_tasks", joinColumns = { // Owner entity
//            @JoinColumn(name = "projectId", referencedColumnName = "id") }, inverseJoinColumns = {
//            @JoinColumn(name = "taskId", referencedColumnName = "id") })
//
//    private Set<Tasks> tasks = new HashSet<>();
//
//    public Set<Tasks> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(Set<Tasks> tasks) {
//        this.tasks = tasks;
//    }


	public Project() {
	}

	public Project(String title) {
		this.title = title;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long id) {
		this.projectId = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Task> getTaskList() {
		return tasks;
	}

	public void setTaskList(List<Task> taskList) {
		this.tasks = taskList;
	}
}