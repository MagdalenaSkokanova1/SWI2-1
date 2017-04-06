/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import domain.Material;
import dto.MaterialCreateDTO;
import dto.MaterialDTO;
import services.BeanMappingService;
import services.MaterialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author olda
 */
public class MaterialFacadeImpl implements MaterialFacade{

    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private MaterialService materialService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int createMaterial(MaterialCreateDTO t) {

        String encodedPassword = passwordEncoder.encode(t.getPassword());
        Material newMaterial = new Material(t.getNameMaterial(), t.getTeacher(), t.getText(), encodedPassword);
        materialService.create(newMaterial);
        return newMaterial.getId();
    
    }

    @Override
    public void deleteMaterial(int materialId) {
        materialService.delete(materialService.findById(materialId));    }

    @Override
    public List<MaterialDTO> getAllMaterials() {

        return beanMappingService.mapTo(materialService.findAll(), MaterialDTO.class);
    }

  
    
    @Override
    public MaterialDTO getMaterialWithId(int id) {
        return beanMappingService.mapTo(materialService.findById(id), MaterialDTO.class);
    
    }

    
    
}
