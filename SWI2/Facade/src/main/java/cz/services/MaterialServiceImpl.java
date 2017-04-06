/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.MaterialDAO;
import domain.Student;
import domain.Teacher;
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
public class MaterialServiceImpl implements MaterialService{

    @Autowired
    private MaterialDAO materialDao;
    
    @Override
    public void create(Material material) {
            materialDao.save(material);
    }

    @Override
    public Material findById(int id) {

            return materialDao.findById(id);
    }

    @Override
    public Material findByText(String text) {

        return materialDao.findByText(text);
    }
    
    @Override
    public Material findByTeacher(Teacher teacher) {

        return materialDao.findByTeacher(teacher);
    }

    @Override
    public List<Material> findAll() {

        return materialDao.findAll();
    }

    @Override
    public void delete(Material material) {

        materialDao.delete(material);
    }
    
}
