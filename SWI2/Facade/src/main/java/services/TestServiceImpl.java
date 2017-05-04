/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TestDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author olda
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDAO testDao;
    
    @Override
    public void create(Test test) {
            testDao.save(test);
    }

    @Override
    public Test findById(int id) {

            return testDao.findById(id);
    }

    @Override
    public Test findByRatio(Double ratio) {

        return testDao.findByRatio(ratio);
    }
    
    @Override
    public Test findByTitle(String title) {

        return testDao.findByTitle(title);
    }

    @Override
    public List<Test> findAll() {

        return testDao.findAll();
    }

    @Override
    public void delete(Test test) {

        testDao.delete(test);
    }
    
}
