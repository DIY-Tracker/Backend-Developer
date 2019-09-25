package com.lambdaschool.diytracker.services;

import com.lambdaschool.diytracker.models.Project;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectService {

    List<Project> returnAllProjects();

    List<Project> returnProjectsByOwner(String username);

    Project findProjectById(long id);

   // Project findByName(String name);

    @Transactional
    void delete(long id);

    Project save(Project project);

    Project update(Project project, long id);


}
// ask what endpoints are needed before coding em up