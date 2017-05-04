/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Teacher;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author olda
 */
public interface TeacherService extends UserDetailsService{
    void create(Teacher teacher);

    Teacher findById(int id);
    
    Teacher findByName(String name);
    
    Teacher findBySurname(String surname);
    
    Teacher findByFaculty(String faculty);
    
    Teacher findByDepartment(String department);

    List<Teacher> findAll();

    void delete(Teacher teacher);
}
