package cz.dao;

import cz.dao.MaterialDao;
import cz.domain.Material;
import cz.domain.Student;
import cz.domain.Teacher;
import cz.utils.EmbeddedDerbyDatabase;
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
public class MaterialDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MaterialDao materialDao;

    @Test
    public void testSave() {
        Teacher techer = new Teacher("Petr", "Novák");
        Student student1 = new Student("Stud1", "Dent1");
        Student student2 = new Student("Stud2", "Dent2");
        
        Material material = new Material("toto je novy material");

        materialDao.save(material);

        Material resultCreate = materialDao.findById(material.getId());
        assertEquals(material, resultCreate);

        material.addStudent(student1);
        material.addStudent(student2);
        materialDao.save(material);
        
        Material resultUpdate = materialDao.findById(material.getId());
        assertEquals(2, resultUpdate.getStudents().size());
    }

    @Test
    public void testDelete() {
        Material material = new Material("toto je testovaci material");

        materialDao.save(material);
        materialDao.delete(material);

        assertEquals(0, materialDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Material material = new Material("toto je testovaci material");

        materialDao.save(material);

        assertEquals(1, materialDao.findAll().size());
    }

}