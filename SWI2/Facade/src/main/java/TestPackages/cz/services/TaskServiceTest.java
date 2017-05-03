/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.services;

import cz.dao.TaskDAO;
import cz.domain.Task;
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
public class TaskseServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    private TaskDAO taskDao;
    
    
    @Autowired
    @InjectMocks
    private TaskService taskService;
    
    
    private Task task;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        task = new Task("questionTask", "categoryTask");

        taskService.create(task);
    }
    
    @Test
    public void testFindAll() {
        when(taskDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(taskService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(taskDao.findById(1)).thenReturn(createTrainersTeam().get("question2Task"));
        assertEquals(taskService.findById(1), new Task("question2Task", "category2Task"));
    }
    
    private Map<String, Task> createTrainersTeam() {
        Map<String, Task> team = new HashMap<>();
        team.put("question1Task", new Task("question1Task", "category1Task"));
        team.put("question2Task", new Task("question2Task", "category2Task"));
        return team;
    }
    
    
}
