/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Subject;
import domain.Teacher;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author olda
 */
public interface SubjectService extends UserDetailsService{
    void create(Subject subject);

    Subject findById(int id);
    
    Subject findByDescription(String description);

    Subject findBySemester(String semester);
    
    Subject findByTeacher(Teacher teacher);

    List<Subject> findAll();

    void delete(Subject subject);
}
