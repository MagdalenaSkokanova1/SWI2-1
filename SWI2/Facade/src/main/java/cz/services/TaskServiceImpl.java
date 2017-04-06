/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TaskDAO;
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
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskDAO taskDao;
    
    @Override
    public void create(Task task) {
            taskDao.save(task);
    }

    @Override
    public Task findById(int id) {

            return taskDao.findById(id);
    }

    @Override
    public Task findByQuestion(String question) {

        return taskDao.findByQuestion(question);
    }
    
    @Override
    public Task findByDificulty(int dificulty) {

        return taskDao.findByDificulty(dificulty);
    }
    
    @Override
    public Task findByCategory(String category) {

        return taskDao.findByCategory(category);
    }

    @Override
    public List<Task> findAll() {

        return taskDao.findAll();
    }

    @Override
    public void delete(Task task) {

        taskDao.delete(task);
    }
    
}
