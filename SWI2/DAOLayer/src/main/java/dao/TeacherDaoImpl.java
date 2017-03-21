/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Teacher;
import utils.DaoLayerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pompi20
 */
public class TeacherDaoImpl  implements TeacherDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Teacher findById(int id){
        try {
            return entityManager.find(Teacher.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
        

    

    @Override
    public void save(Teacher teacher){
        if (findById(teacher.getId()) != null) {
            try {
                entityManager.merge(teacher);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(teacher);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Teacher teacher){
        try {
            entityManager.remove(findById(teacher.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public List<Teacher> findAll(){
        try {
            return entityManager.createQuery("select t from Teacher t", Teacher.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    

}

