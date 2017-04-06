package dao;

import domain.Test;
import domain.Student;
import domain.Teacher;
import domain.Task;
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
public class TestDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestDao testDao;

    @Test
    public void testSave() {
        Teacher techer = new Teacher("Petr", "Novák");
        Student student1 = new Student("Stud1", "Dent1");
        Student student2 = new Student("Stud2", "Dent2");
        Task task = new Task("toto je novy task","kategoria");
        Test test = new Test("toto je novy task", 0.5);

        testDao.save(test);

        Test resultCreate = testDao.findById(test.getId());
        assertEquals(test, resultCreate);

        test.addStudent(student1);
        test.addStudent(student2);
        test.addtask(task);
        test.addteacher(teacher);
        testDao.save(test);
        
        Test resultUpdate = testDao.findById(test.getId());
        assertEquals(2, resultUpdate.getStudents().size());
    }

    @Test
    public void testDelete() {
        Test test = new Test("toto je testovaci test", 0.5);

        testDao.save(test);
        testDao.delete(test);

        assertEquals(0, testDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Test test = new Test("toto je testovaci test", 0.5);

        testDao.save(test);

        assertEquals(1, testDao.findAll().size());
    }

}
