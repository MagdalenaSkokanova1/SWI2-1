package dao;

import domain.Student;
import domain.Subject;
import domain.Material;
import domain.Test;
import utils.EmbeddedDerbyDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.sql.Date;
import org.hibernate.mapping.Set;

import static org.junit.Assert.*;

/**
 * @author Pavel Kouřil
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class StudentDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSave() {
        
        Student student1 = new Student("Stud1", "Dent1");
        Student student2 = new Student("Stud2", "Dent2");
      
        Subject subject = new Subject("semester", "6 semester");
        Material material = new Material("toto je novy material");
        Test test = new Test("toto je novy task", 0.5);

        studentDao.save(student);

        Student resultCreate = studentDao.findById(student.getId());
        assertEquals(student, resultCreate);

        student.addStudent(student1);
        student.addSubject(subject);
        student.addMaterial(material);
        student.addTest(test);
                
        studentDao.save(student);
        
        Student resultUpdate = studentDao.findById(student.getId());
        assertEquals(2, resultUpdate.getStudents().size());
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
