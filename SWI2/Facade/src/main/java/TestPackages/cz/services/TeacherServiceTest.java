/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.services;

import cz.dao.TeacherDAO;
import cz.domain.Teacher;
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
public class TeacherServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    private TeacherDAO teacherDao;
    
    
    @Autowired
    @InjectMocks
    private TeacherService teacherService;
    
    
    private Teacher teacher;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        teacher = new Teacher("nameTeacher", "surnameTeacher");

        teacherService.create(teacher);
    }
    
    @Test
    public void testFindAll() {
        when(teacherDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(teacherService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(teacherDao.findById(1)).thenReturn(createTrainersTeam().get("name2Teacher"));
        assertEquals(teacherService.findById(1), new Teacher("name2Teacher", "surname2Teacher"));
    }
    
    private Map<String, Teacher> createTrainersTeam() {
        Map<String, Teacher> team = new HashMap<>();
        team.put("name1Teacher", new Teacher("name1Teacher", "surname1Teacher"));
        team.put("name2Teacher", new Teacher("name2Teacher", "surname2Teacher"));
        return team;
    }
    
    
}
