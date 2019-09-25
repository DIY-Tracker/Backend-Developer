package com.lambdaschool.diytracker.repository;

import com.lambdaschool.diytracker.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Long> {

    Project findById(String id);

    Project findProjectsByUser(String username);




}
