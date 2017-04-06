/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ProjectDAO;
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
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectDAO projectDao;
    
    @Override
    public void create(Project project) {
            projectDao.save(project);
    }

    @Override
    public Project findById(int id) {

            return projectDao.findById(id);
    }
    
    @Override
    public Project findByTeacher(Teacher teacher) {

        return projectDao.findByTeacher(teacher);
    }

    @Override
    public List<Project> findAll() {

        return projectDao.findAll();
    }

    @Override
    public void delete(Project project) {

        projectDao.delete(project);
    }
    
}
