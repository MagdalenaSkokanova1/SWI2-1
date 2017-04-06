/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import domain.Task;
import dto.TaskCreateDTO;
import dto.TaskDTO;
import services.BeanMappingService;
import services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author olda
 */
public class TaskFacadeImpl implements TaskFacade{

    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int createTask(TaskCreateDTO t) {

        String encodedPassword = passwordEncoder.encode(t.getPassword());
        Task newTask = new Task(t.getNameTask(), t.getQuestion(), t.getDificulty(), t.getCategory(), encodedPassword);
        taskService.create(newTask);
        return newTask.getId();
    
    }

    @Override
    public void deleteTask(int taskId) {
        taskService.delete(taskService.findById(taskId));    }

    @Override
    public List<TaskDTO> getAllTasks() {

        return beanMappingService.mapTo(taskService.findAll(), TaskDTO.class);
    }

  
    
    @Override
    public TaskDTO getTaskWithId(int id) {
        return beanMappingService.mapTo(taskService.findById(id), TaskDTO.class);
    
    }

    
    
}
