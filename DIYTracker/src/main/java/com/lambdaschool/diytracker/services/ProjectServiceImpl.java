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
//    @Override
//    public List<Project> returnProjectsByOwner(String username) {
//        return projectRepos.findProjectsByUser(username);
//    }

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

            if (projectRepos.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName()))
            {
                projectRepos.deleteById(id);
            }
            else
            {
                throw new ResourceNotFoundException(authentication.getName() + " not authorized to make change");
            }
        }
        else
        {
            throw new ResourceNotFoundException("Project with ID " + id + " Can not be found!");
        }
    }

    @Transactional
    @Override
    public Project save(Project project) {
//        if (projectRepos.findProjectsByUser(project.getProjectName()) != null)
//        {
//            throw new ResourceNotFoundException(project.getProjectName() + " Is already Taken!");
//        }
//        Project newProject = new Project();
//
//        newProject.setProjectName(project.getProjectName());
//        newProject.setDescription(project.getDescription());
//
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                if (project.getUser().getUsername().equalsIgnoreCase(authentication.getName()))
                {
                    return projectRepos.save(project);
                } else
                {
                    throw new ResourceNotFoundException((authentication.getName() + "not authorized to make change"));
                }
    }

    @Override
    public Project update(Project project, long id) {
        Authentication authentication = SecurityContextHolder.getContext()
                        .getAuthentication();

        Project currentProject = projectRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project with id " + id + " Not Found!"));


                    if (projectRepos.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName()))
                    {
                        if (project.getPhotoUrl()!= null)
                        {
                            currentProject.setPhotoUrl(project.getPhotoUrl());
                        }

                        if (project.getProjectName() != null)
                        {
                            currentProject.setProjectName(project.getProjectName());
                        }

                        if (project.getDescription() != null)
                        {
                            currentProject.setDescription(project.getDescription());
                        }
                        if (project.getSteps() != null && project.getSteps().size() > 0)
                        {
                            currentProject.setSteps(project.getSteps());
                        }
                        if (project.getMaterials() != null && project.getMaterials().size() > 0)
                        {
                            currentProject.setMaterials(project.getMaterials());
                        }

                    return projectRepos.save(currentProject);
                } else
                {
                    throw new ResourceNotFoundException("Project with id " + id + " does not belong to current user.");
                }
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
