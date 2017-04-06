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
    
    @NotNull
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="SUBJECT_ID")
    private Set<Subject> subjects = new HashSet<>();

    
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="MATERIAL_ID")
    private Set<Material> materials = new HashSet<>();
    
    
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEST_ID")
    private Set<Test> tests = new HashSet<>();

    
     public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        
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

    
     public Set<Subject> getSubject() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        if (subject != null) {
            this.subjects.add(subject);
        }
    }

    public void addSubject(Collection<Subject> subject) {
        if (subject != null) {
            this.subjects.addAll(subject);
        }
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
      
    public Set<Test> getTest() {
        return tests;
    }

    public void addTest(Test test) {
        if (test != null) {
            this.tests.add(test);
        }
    }

    public void addTest(Collection<Test> tests) {
        if (tests != null) {
            this.tests.addAll(tests);
        }
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
        hash = 59 * hash + Objects.hashCode(this.subjects);
        hash = 59 * hash + Objects.hashCode(this.materials);
        hash = 59 * hash + Objects.hashCode(this.tests);
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
        if (!Objects.equals(this.subjects, other.subjects)) {
            return false;
        }
        if (!Objects.equals(this.materials, other.materials)) {
            return false;
        }
        if (!Objects.equals(this.tests, other.tests)) {
            return false;
        }
        return true;
    }

    
    
}
