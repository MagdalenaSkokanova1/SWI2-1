/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import domain.Material;
/**
 *
 * @author pompi20
 */
public interface MaterialDao {
     /**
     * Finds and returns Badge by given ID (primary key)
     */
    public Material findById(int id);

    /**
     * Saves Badge entity to database, can either update existing Badge or save new one
     */
    public void save(Material material);

    /**
     * Deletes given Badge entity from database
     */
    public void delete(Material material);

    /**
     * Returns all Badge entities from database
     */
    public List<Material> findAll();

}
