/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author pompi20
 */
@Entity
public class Student {
  
    private String name;
    private String surname;
    private String address;
    private String contact;
    private String faculty;
    private String dateOfBirth;
    private int year;
    private String fieldOfStudy;
    private String studiumLevel;
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(mappedBy = "student")
    private Set<Material> materials = new HashSet<>();

    
     public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        
    }
     
     public Set<Material> getMaterial() {
        return materials;
    }

    public void addMaterial(Material material) {
        if (material != null) {
            this.materials.add(material);
        }
    }

    public void addMaterial(Collection<Material> materials) {
        if (materials != null) {
            this.materials.addAll(materials);
        }
    }
     
    protected Student(){
    
    } 
    
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getYear() {
        return year;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public String getStudiumLevel() {
        return studiumLevel;
    }

    
     

    
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public void setStudiumLevel(String studiumLevel) {
        this.studiumLevel = studiumLevel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        
        return true;
    }

    
    
}
