package com.lambdaschool.diytracker.services;

import com.lambdaschool.diytracker.models.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findProjectById(long id);

   // Project findByName(String name);

    void delete(long id);

    Project save(Project project);

    Project update(Project project, long id);


}
// ask what endpoints are needed before coding em up