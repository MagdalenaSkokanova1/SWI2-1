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
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;

    @NotNull
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Set<Teacher> teachers = new HashSet<>();
    
    public Project(String text) {
    this.text = text;    
    }
  
    public int getId() {
        return id;
    }

     public Set<Teacher> getTeacher() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        if (teacher != null) {
            this.teachers.add(teacher);
        }
    }

    public void addTeachers(Collection<Teacher> teachers) {
        if (teachers != null) {
            this.teachers.addAll(teachers);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.teachers);
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
        final Project other = (Project) obj;
        if (!Objects.equals(this.teachers, other.teachers)) {
            return false;
        }
        return true;
    } 
}
