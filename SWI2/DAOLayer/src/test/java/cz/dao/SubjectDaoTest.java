package cz.dao;

import cz.domain.Student;
import cz.domain.Teacher;
import cz.domain.Subject;
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
public class SubjectDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SubjectDao subjectDao;

    @Test
    public void testSave() {
        Teacher teacher = new Teacher("Petr", "Novák");
        Student student1 = new Student("Stud1", "Dent1");
        Student student2 = new Student("Stud2", "Dent2");
        
        Subject subject = new Subject("toto je novy subject", "6semseter");

        subjectDao.save(subject);

        Subject resultCreate = subjectDao.findById(subject.getId());
        assertEquals(subject, resultCreate);

        subject.addStudent(student1);
        subject.addStudent(student2);
        subject.addTeacher(teacher);
        subjectDao.save(subject);
        
        Subject resultUpdate = subjectDao.findById(subject.getId());
        assertEquals(2, resultUpdate.getStudents().size());
    }

    @Test
    public void testDelete() {
        Subject subject = new Subject("toto je testovaci subject", "6semseter");

        subjectDao.save(subject);
        subjectDao.delete(subject);

        assertEquals(0, subjectDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Subject subject = new Subject("toto je testovaci subject", "6semseter");

        subjectDao.save(subject);

        assertEquals(1, subjectDao.findAll().size());
    }

}
