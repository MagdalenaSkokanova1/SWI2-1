/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.StudentDAO;
import domain.Subject;
import domain.Test;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author olda
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDao;
    
    @Override
    public void create(Student student) {
            studentDao.save(student);
    }
    
    @Override
    public Student findById(int id) {

            return studentDao.findById(id);
    }
    
    @Override
    public Student findByName(String name) {

            return studentDao.findByName(name);
    }
    
    @Override
    public Student findBySurname(String surname) {

            return studentDao.findBySurname(surname);
    }
 
    @Override
    public Student findByYear(int year) {

        return studentDao.findByYear(year);
    }
    
    @Override
    public Student findBySubject(Subject subject) {

        return studentDao.findBySubject(subject);
    }
    
    @Override
    public Student findByTest(Test test) {

        return studentDao.findByTest(test);
    }
    
    @Override
    public List<Student> findAll() {

        return studentDao.findAll();
    }

    @Override
    public void delete(Student student) {

        studentDao.delete(student);
    }
    
}
