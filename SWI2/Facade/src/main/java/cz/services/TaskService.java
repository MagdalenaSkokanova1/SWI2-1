/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Task;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author olda
 */
public interface TaskService extends UserDetailsService{
    void create(Task task);

    Task findById(int id);
    
    Task findByQuestion(String question);

    Task findByDificulty(int dificulty);
    
    Task findByCategory(String category);

    List<Task> findAll();

    void delete(Task task);
}
