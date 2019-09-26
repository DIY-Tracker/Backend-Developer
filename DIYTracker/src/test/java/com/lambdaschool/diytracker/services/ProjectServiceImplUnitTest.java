package com.lambdaschool.diytracker.services;

import com.lambdaschool.diytracker.DiytrackerApplicationTests;
import com.lambdaschool.diytracker.models.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DiytrackerApplicationTests.class)
public class ProjectServiceImplUnitTest
{
    @Autowired
    private ProjectService projectService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void returnAllProjects() {
        assertEquals(3, projectService.returnAllProjects().size());
    }

    //Find By ID
    @Test
    public void findProjectById( ) {
        assertEquals("TESTING", projectService.findProjectById(16).getProjectName());
    }




    @Test
    public void delete( ){

    }


    @Test
    public void save( ) {

    }

    @Test
    public void update() {

    }
}
