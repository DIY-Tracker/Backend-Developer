package com.lambdaschool.diytracker.services;

import com.lambdaschool.diytracker.exceptions.ResourceNotFoundException;
import com.lambdaschool.diytracker.models.Project;
import com.lambdaschool.diytracker.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "projectService")
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepo projectRepos;


    @Override
    public List<Project> returnAllProjects() {
     List<Project> projects = new ArrayList<>();
     projectRepos.findAll().iterator().forEachRemaining(projects::add);
     return projects;
    }
//Find all Projects by Username
    @Override
    public List<Project> returnProjectsByOwner(String username) {
        return projectRepos.findProjectsByUser(username);
    }
//Find By ID
    @Override
    public Project findProjectById(long id) {
        return projectRepos.findById(id).orElseThrow(()-> new ResourceNotFoundException("Project with ID " + id + " Can not be found!"));
    }



    @Transactional
    @Override
    public void delete(long id){
        if (projectRepos.findById(id).isPresent()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                throw new ResourceNotFoundException("Project with ID " + id + " Can not be found!");
        }
               // .orElseThrow(() -> new ResourceNotFoundException("Project with ID " + id + " Can not be found!"));
        projectRepos.deleteById(id);
    }

    @Transactional
    @Override
    public Project save(Project project) {
        if (projectRepos.findProjectsByUser(project.getProjectName()) != null)
        {
            throw new ResourceNotFoundException(project.getProjectName() + " Is already Taken!");
        }
        Project newProject = new Project();

        newProject.setProjectName(project.getProjectName());
        newProject.setDescription(project.getDescription());

    }

    @Override
    public Project update(Project project, long id) {
        return null;
    }

}
//
//    List<Project> returnAllProjects();
//
//    List<Project> returnProjectsByOwner(String username);
//
//    Project findProjectById(long id);
//
//    // Project findByName(String name);
//
//    void delete(long id);

//    Project save(Project project);
//
//    Project update(Project project, long id);
//
