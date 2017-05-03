/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.services;

import cz.dao.ProjectDAO;
import cz.domain.Project;
import cz.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author olda
 */

@ContextConfiguration(classes = ServiceConfiguration.class)
public class ProjectseServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    private ProjectDAO projectDao;
    
    
    @Autowired
    @InjectMocks
    private ProjectService projectService;
    
    
    private Project project;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        project = new Project("textProject");

        projectService.create(project);
    }
    
    @Test
    public void testFindAll() {
        when(projectDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(projectService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(projectDao.findById(1)).thenReturn(createTrainersTeam().get("text2Project"));
        assertEquals(projectService.findById(1), new Project("text2Project"));
    }
    
    private Map<String, Project> createTrainersTeam() {
        Map<String, Project> team = new HashMap<>();
        team.put("text1Project", new Project("text1Project"));
        team.put("text2Project", new Project("text2Project"));
        return team;
    }
    
    
}
