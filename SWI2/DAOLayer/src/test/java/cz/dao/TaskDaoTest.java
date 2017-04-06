package dao;

import domain.Test;
import domain.Teacher;
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
public class TaskDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TaskDao taskDao;

    @Test
    public void testSave() {
        Teacher techer = new Teacher("Petr", "Novák");
                
        Task task = new Task("toto je novy task","kategoria");

        taskDao.save(task);

        Task resultCreate = taskDao.findById(task.getId());
        assertEquals(task, resultCreate);
        
        
        task.addTeacher(teacher);
        taskDao.save(task);
        
        Task resultUpdate = taskDao.findById(task.getId());
        assertEquals(2, resultUpdate.getStudents().size());
    }

    @Test
    public void testDelete() {
        Task task = new Task("toto je testovaci task", "kategoria");

        taskDao.save(task);
        taskDao.delete(task);

        assertEquals(0, taskDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Task task = new Task("toto je testovaci task", "kategoria");

        taskDao.save(task);

        assertEquals(1, taskDao.findAll().size());
    }

}
