/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dao;

import java.util.List;
import cz.domain.Student;
/**
 *
 * @author pompi20
 */
public interface StudentDao {
     /**
     * Finds and returns Student by given ID (primary key)
     */
    public Student findById(int id);

    /**
     * Saves Student entity to database, can either update existing Student or save new one
     */
    public void save(Student student);

    /**
     * Deletes given Student entity from database
     */
    public void delete(Student student);

    /**
     * Returns all Student entities from database
     */
    public List<Student> findAll();

}
