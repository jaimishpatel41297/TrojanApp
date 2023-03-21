package com.example.trojans.repository;

import com.example.trojans.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByTitle(String title);

	Project findByProjectId(long projectId);


}
