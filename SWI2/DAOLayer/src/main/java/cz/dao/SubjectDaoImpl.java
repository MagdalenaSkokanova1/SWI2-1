/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dao;

import cz.domain.Subject;
import cz.utils.DaoLayerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pompi20
 */
public class SubjectDaoImpl  implements SubjectDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Subject findById(int id){
        try {
            return entityManager.find(Subject.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
        

    

    @Override
    public void save(Subject subject){
        if (findById(subject.getId()) != null) {
            try {
                entityManager.merge(subject);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(subject);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Subject subject){
        try {
            entityManager.remove(findById(subject.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public List<Subject> findAll(){
        try {
            return entityManager.createQuery("select s from Subject s", Subject.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    

}

