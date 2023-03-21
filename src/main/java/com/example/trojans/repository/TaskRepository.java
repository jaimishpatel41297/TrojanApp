package com.example.trojans.repository;

import com.example.trojans.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByName(String name);
}
