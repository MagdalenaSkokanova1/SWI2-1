/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import domain.Teacher;
import dto.TeacherCreateDTO;
import dto.TeacherDTO;
import services.BeanMappingService;
import services.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author olda
 */
public class TeacherFacadeImpl implements TeacherFacade{

    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private TeacherService teacherService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int createTeacher(TeacherCreateDTO t) {

        String encodedPassword = passwordEncoder.encode(t.getPassword());
        Teacher newTeacher = new Teacher(t.getNameTeacher(), t.getSurname(), t.getFaculty(), t.getDepartment(), encodedPassword);
        teacherService.create(newTeacher);
        return newTeacher.getId();
    
    }

    @Override
    public void deleteTeacher(int teacherId) {
        teacherService.delete(teacherService.findById(teacherId));    }

    @Override
    public List<TeacherDTO> getAllTeachers() {

        return beanMappingService.mapTo(teacherService.findAll(), TeacherDTO.class);
    }

  
    
    @Override
    public TeacherDTO getTeacherWithId(int id) {
        return beanMappingService.mapTo(teacherService.findById(id), TeacherDTO.class);
    
    }

    
    
}
