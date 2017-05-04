/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Student;
import domain.Subject;
import domain.Test;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author olda
 */
public interface StudentService extends UserDetailsService{
    void create(Student student);

    Student findById(int id);
    
    Student findByName(String name);
    
    Student findBySurname(String surname);
    
    Student findByYear(int year);
    
    Student findBySubject(Subject subject);
    
    Student findByTest(Test test);

    List<Student> findAll();

    void delete(Student student);
}
