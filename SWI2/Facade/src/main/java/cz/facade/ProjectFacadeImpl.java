/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import domain.Project;
import dto.ProjectCreateDTO;
import dto.ProjectDTO;
import services.BeanMappingService;
import services.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author olda
 */
public class ProjectFacadeImpl implements ProjectFacade{

    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int createProject(ProjectCreateDTO t) {

        String encodedPassword = passwordEncoder.encode(t.getPassword());
        Project newProject = new Project(t.getNameProject(), t.getTeacher(), encodedPassword);
        projectService.create(newProject);
        return newProject.getId();
    
    }

    @Override
    public void deleteProject(int projectId) {
        projectService.delete(projectService.findById(projectId));    }

    @Override
    public List<ProjectDTO> getAllProjects() {

        return beanMappingService.mapTo(projectService.findAll(), ProjectDTO.class);
    }

  
    
    @Override
    public ProjectDTO getProjectWithId(int id) {
        return beanMappingService.mapTo(projectService.findById(id), ProjectDTO.class);
    
    }

    
    
}
