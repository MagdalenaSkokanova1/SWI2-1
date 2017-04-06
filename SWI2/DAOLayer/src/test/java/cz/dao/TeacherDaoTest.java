
/*package cz.dao;

import cz.domain.Teacher;
import cz.domain.Material;
import cz.domain.Project;
import cz.domain.Subject;
import cz.domain.Task;
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

 * @author Pavel Kouřil
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TeacherDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testSave() {
        Teacher teacher = new Teacher("Petr", "Novák");
        Material material = new Material("toto je novy material");
        Project project = new Project("toto je novy project");
        Subject subject = new Subject("toto je novy subject", "6semseter");
        Task task = new Task("toto je novy task", "kategoria");
        Test test = new Test("toto je novy task", 0.5);

        teacherDao.save(teacher);

        Teacher resultCreate = teacherDao.findById(teacher.getId());
        assertEquals(teacher, resultCreate);

        teacher.addTask(task);
        teacher.addTest(test);
        teacher.addMaterial(material);
        teacher.addProject(project);
        teacher.addSubject(subject);
        teacherDao.save(teacher);
        
        Teacher resultUpdate = teacherDao.findById(teacher.getId());
        assertEquals(teacher, resultUpdate);
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
*/