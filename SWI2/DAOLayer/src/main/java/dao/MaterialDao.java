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
     * Finds and returns Material by given ID (primary key)
     */
    public Material findById(int id);

    /**
     * Saves Material entity to database, can either update existing Material or save new one
     */
    public void save(Material material);

    /**
     * Deletes given Material entity from database
     */
    public void delete(Material material);

    /**
     * Returns all Material entities from database
     */
    public List<Material> findAll();

}
