/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.services;

import cz.dao.TestDAO;
import cz.domain.Test;
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
public class TestServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    private TestDAO testDao;
    
    
    @Autowired
    @InjectMocks
    private TestService testService;
    
    
    private Test test;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        test = new Test("titleTest", 0.0);

        testService.create(test);
    }
    
    @Test
    public void testFindAll() {
        when(testDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(testService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(testDao.findById(1)).thenReturn(createTrainersTeam().get("title2Test"));
        assertEquals(testService.findById(1), new Test("title2Test", 2.0));
    }
    
    private Map<String, Test> createTrainersTeam() {
        Map<String, Test> team = new HashMap<>();
        team.put("title1Test", new Test("title1Test", 1.0));
        team.put("title2Test", new Test("title2Test", 2.0));
        return team;
    }
    
    
}
