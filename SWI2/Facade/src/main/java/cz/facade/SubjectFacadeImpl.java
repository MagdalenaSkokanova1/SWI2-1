/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import domain.Subject;
import dto.SubjectCreateDTO;
import dto.SubjectDTO;
import services.BeanMappingService;
import services.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author olda
 */
public class SubjectFacadeImpl implements SubjectFacade{

    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int createSubject(SubjectCreateDTO t) {

        String encodedPassword = passwordEncoder.encode(t.getPassword());
        Subject newSubject = new Subject(t.getNameSubject(), t.getDescription(), t.getSemester(), t.getTeacher(), encodedPassword);
        subjectService.create(newSubject);
        return newSubject.getId();
    
    }

    @Override
    public void deleteSubject(int subjectId) {
        subjectService.delete(subjectService.findById(subjectId));    }

    @Override
    public List<SubjectDTO> getAllSubjects() {

        return beanMappingService.mapTo(subjectService.findAll(), SubjectDTO.class);
    }

  
    
    @Override
    public SubjectDTO getSubjectWithId(int id) {
        return beanMappingService.mapTo(subjectService.findById(id), SubjectDTO.class);
    
    }

    
    
}
