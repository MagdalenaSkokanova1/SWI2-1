/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dao;

import java.util.List;
import cz.domain.Subject;
/**
 *
 * @author pompi20
 */
public interface SubjectDao {
     /**
     * Finds and returns Subject by given ID (primary key)
     */
    public Subject findById(int id);

    /**
     * Saves Subject entity to database, can either update existing Subject or save new one
     */
    public void save(Subject subject);

    /**
     * Deletes given Subject entity from database
     */
    public void delete(Subject subject);

    /**
     * Returns all Subject entities from database
     */
    public List<Subject> findAll();

}
