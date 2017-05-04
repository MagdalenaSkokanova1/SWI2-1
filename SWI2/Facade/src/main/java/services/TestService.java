/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Test;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author olda
 */
public interface TestService extends UserDetailsService{
    void create(Test test);

    Test findById(int id);
    
    Test findByRatio(Double ratio);

    Test findByTitle(String title);

    List<Test> findAll();

    void delete(Test test);
}
