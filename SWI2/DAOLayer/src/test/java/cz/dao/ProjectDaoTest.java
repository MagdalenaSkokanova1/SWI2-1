package dao;

import domain.Project;
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
public class ProjectDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ProjectDao projectDao;

    @Test
    public void testSave() {
        Teacher techer = new Teacher("Petr", "Novák");
            
        Project project = new Project("toto je novy project");

        projectDao.save(project);

        Project resultCreate = projectDao.findById(project.getId());
        assertEquals(project, resultCreate);

        project.addTeacher(teacher);
        projectDao.save(project);
        
        Project resultUpdate = projectDao.findById(project.getId());
        assertEquals(2, resultUpdate.getStudents().size());
    }

    @Test
    public void testDelete() {
        Project project = new Project("toto je testovaci project");

        projectDao.save(project);
        projectDao.delete(project);

        assertEquals(0, projectDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Project project = new Project("toto je testovaci project");

        projectDao.save(project);

        assertEquals(1, projectDao.findAll().size());
    }

}
