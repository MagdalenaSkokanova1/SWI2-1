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
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 *
 * @author pompi20
 */
public class Subject {
    
    private String description;
    private int credits;
    private String semester;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    
    
    @NotNull
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="STUDENT_ID")
    private Set<Student> students = new HashSet<>();

    @NotNull
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Set<Teacher> teachers = new HashSet<>();
    
     public Subject(String description, String semester) {
        this.description = description;
        this.semester = semester;
        
    }
    
    
    
    
    
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getCredits() {
        return credits;
    }

    public String getSemester() {
        return semester;
    }

     public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public Set<Teacher> getTeacher() {
        return teachers;
    }

    public void addStudent(Student student) {
        if (student != null) {
            this.students.add(student);
        }
    }

    public void addStudents(Collection<Student> students) {
        if (students != null) {
            this.students.addAll(students);
        }
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.students);
        hash = 17 * hash + Objects.hashCode(this.teachers);
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
        final Subject other = (Subject) obj;
        if (!Objects.equals(this.students, other.students)) {
            return false;
        }
        if (!Objects.equals(this.teachers, other.teachers)) {
            return false;
        }
        return true;
    }

    
    
}
