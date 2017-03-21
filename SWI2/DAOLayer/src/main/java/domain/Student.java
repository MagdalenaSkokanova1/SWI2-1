/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.Objects;

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
    
    private Subject[] subjects;
    private Material[] materials;
    private Test[] tests;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="SUBJECT_ID")
    private Subject subject;

   
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="MATERIAL_ID")
    private Material material;
    
     public Student(Student student, Teacher teacher) {
        this.subject = subject;
        this.material = material;
        
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

    public Subject[] getSubjects() {
        return subjects;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public Test[] getTests() {
        return tests;
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

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }

    public void setTests(Test[] tests) {
        this.tests = tests;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Arrays.deepHashCode(this.subjects);
        hash = 29 * hash + Arrays.deepHashCode(this.materials);
        hash = 29 * hash + Arrays.deepHashCode(this.tests);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Arrays.deepEquals(this.subjects, other.subjects)) {
            return false;
        }
        if (!Arrays.deepEquals(this.materials, other.materials)) {
            return false;
        }
        if (!Arrays.deepEquals(this.tests, other.tests)) {
            return false;
        }
        return true;
    }
    
    
    
}
