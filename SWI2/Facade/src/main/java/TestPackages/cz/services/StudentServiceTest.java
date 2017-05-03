/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.services;

import cz.dao.StudentDAO;
import cz.domain.Student;
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
public class StudentServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    private StudentDAO studentDao;
    
    
    @Autowired
    @InjectMocks
    private StudentService studentService;
    
    
    private Student student;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        student = new Student("nameStudent", "surnameStudent");

        studentService.create(student);
    }
    
    @Test
    public void testFindAll() {
        when(studentDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(studentService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(studentDao.findById(1)).thenReturn(createTrainersTeam().get("name2Student"));
        assertEquals(studentService.findById(1), new Student("name2Student", "surname2Student"));
    }
    
    private Map<String, Student> createTrainersTeam() {
        Map<String, Student> team = new HashMap<>();
        team.put("name1Student", new Student("name1Student", "surname1Student"));
        team.put("name2Student", new Student("name2Student", "surname2Student"));
        return team;
    }
    
    
}
