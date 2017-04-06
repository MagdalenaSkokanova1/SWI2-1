/*
package cz.dao;

import cz.domain.Student;
import cz.domain.Subject;
import cz.domain.Material;
import cz.domain.Test;
import cz.utils.EmbeddedDerbyDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import org.hibernate.mapping.Set;

import static org.junit.Assert.*;


@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class StudentDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSave() {
        
        Student student1 = new Student("Stud1", "Dent1");
        
        
        studentDao.save(student1);
        
        

        Student resultCreate = studentDao.findById(student1.getId());
        assertEquals(student1, resultCreate);

        
    }

    @Test
    public void testDelete() {
        Student student = new Student("testStud1", "Dent1");

        studentDao.save(student);
        studentDao.delete(student);

        assertEquals(0, studentDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Student student = new Student("testStud1", "Dent1");

        studentDao.save(student);

        assertEquals(1, studentDao.findAll().size());
    }

}
*/