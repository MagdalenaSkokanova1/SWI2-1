/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import domain.Student;
import dto.StudentCreateDTO;
import dto.StudentDTO;
import services.BeanMappingService;
import services.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author olda
 */
public class StudentFacadeImpl implements StudentFacade{

    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int createStudent(StudentCreateDTO t) {

        String encodedPassword = passwordEncoder.encode(t.getPassword());
        Student newStudent = new Student(t.getNameStudent(), t.getSurname(), t.getYear(), t.getSubject(), t.getTest(), encodedPassword);
        studentService.create(newStudent);
        return newStudent.getId();
    
    }

    @Override
    public void deleteStudent(int studentId) {
        studentService.delete(studentService.findById(studentId));    }

    @Override
    public List<StudentDTO> getAllStudents() {

        return beanMappingService.mapTo(studentService.findAll(), StudentDTO.class);
    }

  
    
    @Override
    public StudentDTO getStudentWithId(int id) {
        return beanMappingService.mapTo(studentService.findById(id), StudentDTO.class);
    
    }

    
    
}
