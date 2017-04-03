/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dao;



import cz.domain.Student;
import cz.utils.DaoLayerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pompi20
 */
public class StudentDaoImpl  implements StudentDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student findById(int id){
        try {
            return entityManager.find(Student.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
        

    

    @Override
    public void save(Student student){
        if (findById(student.getId()) != null) {
            try {
                entityManager.merge(student);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(student);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Student student){
        try {
            entityManager.remove(findById(student.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public List<Student> findAll(){
        try {
            return entityManager.createQuery("select s from Student s", Student.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    

}

