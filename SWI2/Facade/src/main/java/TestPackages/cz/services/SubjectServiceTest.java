/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.services;

import cz.dao.SubjectDAO;
import cz.domain.Subject;
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
public class SubjectServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    private SubjectDAO subjectDao;
    
    
    @Autowired
    @InjectMocks
    private SubjectService subjectService;
    
    
    private Subject subject;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        subject = new Subject("descriptionSubject", "semesterSubject");

        subjectService.create(subject);
    }
    
    @Test
    public void testFindAll() {
        when(subjectDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(subjectService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(subjectDao.findById(1)).thenReturn(createTrainersTeam().get("description2Subject"));
        assertEquals(subjectService.findById(1), new Subject("description2Subject", "semester2Subject"));
    }
    
    private Map<String, Subject> createTrainersTeam() {
        Map<String, Subject> team = new HashMap<>();
        team.put("description1Subject", new Subject("description1Subject", "semester1Subject"));
        team.put("description2Subject", new Subject("description2Subject", "semester2Subject"));
        return team;
    }
    
    
}
