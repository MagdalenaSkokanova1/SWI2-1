/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Task;
import utils.DaoLayerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pompi20
 */
public class TaskDaoImpl  implements TaskDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task findById(int id){
        try {
            return entityManager.find(Task.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
        

    

    @Override
    public void save(Task task){
        if (findById(task.getId()) != null) {
            try {
                entityManager.merge(task);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(task);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Task task){
        try {
            entityManager.remove(findById(task.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public List<Task> findAll(){
        try {
            return entityManager.createQuery("select t from Task t", Task.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    

}

