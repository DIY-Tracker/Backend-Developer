package com.lambdaschool.diytracker.repository;

import com.lambdaschool.diytracker.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
