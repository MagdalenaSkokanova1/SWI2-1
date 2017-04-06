package dao;

import domain.Teacher;
import domain.Material;
import domain.Project;
import domain.Subject;
import domain.Task;
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
public class TeacherDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testSave() {
        Teacher techer = new Teacher("Petr", "Novák");
        Material material = new Material("toto je novy material");
        Project project = new Project("toto je novy project");
        Subject subject = new Subject("toto je novy subject", "6semseter");
        Task task = new Task("toto je novy task", "kategoria");
        Test test = new Test("toto je novy task", 0.5);

        teacherDao.save(teacher);

        Teacher resultCreate = teacherDao.findById(teacher.getId());
        assertEquals(teacher, resultCreate);

        teacher.addtask(task);
        teacher.addtest(test);
        teacher.addmaterial(material);
        teacher.addproject(project);
        teacher.addsubject(subject);
        teacherDao.save(teacher);
        
        Teacher resultUpdate = teacherDao.findById(teacher.getId());
        assertEquals(2, resultUpdate.getStudents().size());
    }

    @Test
    public void testDelete() {
        Teacher teacher = new Teacher("toto je testovaci teacher", "Novák");

        teacherDao.save(teacher);
        teacherDao.delete(teacher);

        assertEquals(0, teacherDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Teacher teacher = new Teacher("toto je testovaci teacher", "Novák");

        teacherDao.save(teacher);

        assertEquals(1, teacherDao.findAll().size());
    }

}
