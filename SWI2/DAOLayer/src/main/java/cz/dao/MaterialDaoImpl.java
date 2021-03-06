/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dao;

import cz.domain.Material;
import cz.utils.DaoLayerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pompi20
 */
public class MaterialDaoImpl  implements MaterialDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Material findById(int id){
        try {
            return entityManager.find(Material.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
        

    

    @Override
    public void save(Material material){
        if (findById(material.getId()) != null) {
            try {
                entityManager.merge(material);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(material);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Material material){
        try {
            entityManager.remove(findById(material.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public List<Material> findAll(){
        try {
            return entityManager.createQuery("select m from Material m", Material.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    

}

