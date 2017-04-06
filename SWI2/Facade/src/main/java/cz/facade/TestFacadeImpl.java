/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import domain.Test;
import dto.TestCreateDTO;
import dto.TestDTO;
import services.BeanMappingService;
import services.TestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author olda
 */
public class TestFacadeImpl implements TestFacade{

    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private TestService testService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int createTest(TestCreateDTO t) {

        String encodedPassword = passwordEncoder.encode(t.getPassword());
        Test newTest = new Test(t.getNameTest(), t.getRatio(), t.getTitle(), encodedPassword);
        testService.create(newTest);
        return newTest.getId();
    
    }

    @Override
    public void deleteTest(int testId) {
        testService.delete(testService.findById(testId));    }

    @Override
    public List<TestDTO> getAllTests() {

        return beanMappingService.mapTo(testService.findAll(), TestDTO.class);
    }

  
    
    @Override
    public TestDTO getTestWithId(int id) {
        return beanMappingService.mapTo(testService.findById(id), TestDTO.class);
    
    }

    
    
}
