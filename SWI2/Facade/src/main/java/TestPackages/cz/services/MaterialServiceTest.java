/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.services;

import cz.dao.MaterialDAO;
import cz.domain.Material;
import cz.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author olda
 */

@ContextConfiguration(classes = ServiceConfiguration.class)
public class MaterialServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    private MaterialDAO materialDao;
    
    
    @Autowired
    @InjectMocks
    private MaterialService materialService;
    
    
    private Material material;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        material = new Material("textMaterial");

        materialService.create(material);
    }
    
    @Test
    public void testFindAll() {
        when(materialDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(materialService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(materialDao.findById(1)).thenReturn(createTrainersTeam().get("text2Material"));
        assertEquals(materialService.findById(1), new Material("text2Material"));
    }
    
    private Map<String, Material> createTrainersTeam() {
        Map<String, Material> team = new HashMap<>();
        team.put("text1Material", new Material("text1Material"));
        team.put("text2Material", new Material("text2Material"));
        return team;
    }
    
    
}
