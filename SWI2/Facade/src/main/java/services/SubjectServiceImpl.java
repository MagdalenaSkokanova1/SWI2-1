/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.SubjectDAO;
import domain.Teacher;
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
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectDAO subjectDao;
    
    @Override
    public void create(Subject subject) {
            subjectDao.save(subject);
    }

    @Override
    public Subject findById(int id) {

            return subjectDao.findById(id);
    }

    @Override
    public Subject findByDescription(String description) {

        return subjectDao.findByDescription(description);
    }
    
    @Override
    public Subject findBySemester(String semester) {

        return subjectDao.findBySemester(semester);
    }
    
    @Override
    public Subject findByTeacher(Teacher teacher) {

        return subjectDao.findByTeacher(teacher);
    }

    @Override
    public List<Subject> findAll() {

        return subjectDao.findAll();
    }

    @Override
    public void delete(Subject subject) {

        subjectDao.delete(subject);
    }
    
}
