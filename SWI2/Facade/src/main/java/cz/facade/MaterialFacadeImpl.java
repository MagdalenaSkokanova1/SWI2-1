/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.facade;

import cz.domain.Material;
//import cz.services.MaterialService;
import cz.services.BeanMappingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author pompi20
 */
public class MaterialFacadeImpl  implements MaterialFacade{
   
    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private MaterialseService materialService;
    
     
    @Override
    public int createMaterial(MaterialCreateDTO m) {

        Material newMaterial = new Material(m.getTextMateril());
        
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
