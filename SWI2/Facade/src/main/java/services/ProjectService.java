/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Project;
import domain.Teacher;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author olda
 */
public interface ProjectService extends UserDetailsService{
    void create(Project project);

    Project findById(int id);
    
    Project findByTeacher(Teacher teacher);

    List<Project> findAll();

    void delete(Project project);
}
