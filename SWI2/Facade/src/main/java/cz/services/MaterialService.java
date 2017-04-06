/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Material;
import domain.Student;
import domain.Teacher;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author olda
 */
public interface MaterialService extends UserDetailsService{
    void create(Material material);

    Material findById(int id);
    
    Material findByTeacher(Teacher teacher);

    Material findByText(String text);

    List<Material> findAll();

    void delete(Material material);
}
