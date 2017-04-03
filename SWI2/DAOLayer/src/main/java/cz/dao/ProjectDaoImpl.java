/*
 * To change this license header, choose License Headers in ProjectDaoImpl Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dao;



import cz.domain.Project;
import cz.utils.DaoLayerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


/**
 *
 * @author pompi20
 */
public class ProjectDaoImpl  implements ProjectDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Project findById(int id){
        try {
            return entityManager.find(Project.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
        

    

    @Override
    public void save(Project project){
        if (findById(project.getId()) != null) {
            try {
                entityManager.merge(project);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(project);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Project project){
        try {
            entityManager.remove(findById(project.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public List<Project> findAll(){
        try {
            return entityManager.createQuery("select p from Project p", Project.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    

}

