/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import domain.Task;
/**
 *
 * @author pompi20
 */
public interface TaskDao {
     /**
     * Finds and returns Task by given ID (primary key)
     */
    public Task findById(int id);

    /**
     * Saves Task entity to database, can either update existing Task or save new one
     */
    public void save(Task task);

    /**
     * Deletes given Task entity from database
     */
    public void delete(Task task);

    /**
     * Returns all Task entities from database
     */
    public List<Task> findAll();

}
