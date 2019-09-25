package com.lambdaschool.diytracker.controllers;

import com.lambdaschool.diytracker.models.Project;
import com.lambdaschool.diytracker.models.User;
import com.lambdaschool.diytracker.services.ProjectService;
import com.lambdaschool.diytracker.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    // Read ALL

    @GetMapping(value = "/projects", produces = {"application/json"})
    public ResponseEntity<?> listAllProjects(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Project> allProjects = projectService.returnAllProjects();
        return new ResponseEntity<>(allProjects, HttpStatus.OK);
    }

    @GetMapping(value = "/projects/{id}", produces = {"application/json"})
    public ResponseEntity<?> getProjectById(HttpServletRequest request, @PathVariable long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Project project = projectService.findProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    //Read All By User

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @GetMapping(value = "/projects/{user}",
//            produces = {"application/json"})
//    public ResponseEntity<?> getProjectByUser(HttpServletRequest request,
//                                              @PathVariable
//                                                      User user)
//    {
//        logger.trace(request.getMethod()
//                .toUpperCase() + " " + request.getRequestURI() + " accessed");
//
//        Project projectsByUser = (Project) projectService.findProjectsByUser(user);
//        return new ResponseEntity<>(projectsByUser, HttpStatus.OK);
//    }


    // Create

    @PostMapping(value = "/projects/{userid}")
    public ResponseEntity<?> addNewProject(HttpServletRequest request, @Valid
    @RequestBody Project newProject, @PathVariable
            long userid) throws URISyntaxException
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        User projectUser = userService.findUserById(userid);

        Project tempProject = new Project(newProject.getProjectName(), projectUser, newProject.getDescription(), newProject.getPhotoUrl(), newProject.getMaterials(), newProject.getSteps());

        tempProject = projectService.save(tempProject);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newProjectURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{useremailid}")
                .buildAndExpand(newProject.getProjectId())
                .toUri();
        responseHeaders.setLocation(newProjectURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    //Update

    @PutMapping(value = "/project/{id}")
    public ResponseEntity<?> updateProject(HttpServletRequest request,
                                           @RequestBody
                                                   Project updateProject,
                                           @PathVariable
                                                   long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        projectService.update(updateProject, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete

    @DeleteMapping("/project/{id}")
    public ResponseEntity<?> deleteProjectById(HttpServletRequest request,
                                               @PathVariable
                                                       long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}