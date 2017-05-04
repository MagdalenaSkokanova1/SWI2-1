/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TeacherDAO;
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
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDAO teacherDao;
    
    @Override
    public void create(Teacher teacher) {
            teacherDao.save(teacher);
    }

    @Override
    public Teacher findById(int id) {

            return teacherDao.findById(id);
    }

    @Override
    public Teacher findByName(String name) {

        return teacherDao.findByName(name);
    }
    
    @Override
    public Teacher findBySurname(String surname) {

        return teacherDao.findBySurname(surname);
    }
    
    @Override
    public Teacher findByFaculty(String faculty) {

        return teacherDao.findByFaculty(faculty);
    }
    
    @Override
    public Teacher findByDepartment(String department) {

        return teacherDao.findByDepartment(department);
    }

    @Override
    public List<Teacher> findAll() {

        return teacherDao.findAll();
    }

    @Override
    public void delete(Teacher teacher) {

        teacherDao.delete(teacher);
    }
    
}
