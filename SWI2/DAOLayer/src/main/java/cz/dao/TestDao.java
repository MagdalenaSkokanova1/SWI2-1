/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dao;

import java.util.List;
import cz.domain.Test;
/**
 *
 * @author pompi20
 */
public interface TestDao {
     /**
     * Finds and returns Test by given ID (primary key)
     */
    public Test findById(int id);

    /**
     * Saves Test entity to database, can either update existing Test or save new one
     */
    public void save(Test test);

    /**
     * Deletes given Test entity from database
     */
    public void delete(Test test);

    /**
     * Returns all Test entities from database
     */
    public List<Test> findAll();

}
