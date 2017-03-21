/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import domain.Project;
/**
 *
 * @author pompi20
 */
public interface ProjectDao {
     /**
     * Finds and returns Project by given ID (primary key)
     */
    public Project findById(int id);

    /**
     * Saves Project entity to database, can either update existing Project or save new one
     */
    public void save(Project project);

    /**
     * Deletes given Project entity from database
     */
    public void delete(Project project);

    /**
     * Returns all Project entities from database
     */
    public List<Project> findAll();

}
