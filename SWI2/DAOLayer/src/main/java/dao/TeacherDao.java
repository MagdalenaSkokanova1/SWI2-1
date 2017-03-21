/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import domain.Teacher;
/**
 *
 * @author pompi20
 */
public interface TeacherDao {
     /**
     * Finds and returns Teacher by given ID (primary key)
     */
    public Teacher findById(int id);

    /**
     * Saves Teacher entity to database, can either update existing Teacher or save new one
     */
    public void save(Teacher teacher);

    /**
     * Deletes given Teacher entity from database
     */
    public void delete(Teacher teacher);

    /**
     * Returns all Teacher entities from database
     */
    public List<Teacher> findAll();

}
