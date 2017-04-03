/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dao;

import cz.domain.Test;
import cz.utils.DaoLayerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pompi20
 */
public class TestDaoImpl  implements TestDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Test findById(int id){
        try {
            return entityManager.find(Test.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
        

    

    @Override
    public void save(Test test){
        if (findById(test.getId()) != null) {
            try {
                entityManager.merge(test);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(test);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Test test){
        try {
            entityManager.remove(findById(test.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public List<Test> findAll(){
        try {
            return entityManager.createQuery("select t from Test t", Test.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    

}

