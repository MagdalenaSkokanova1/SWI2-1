/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Arrays;


/**
 *
 * @author pompi20
 */
public class Subject {
    
    private String description;
    private int credits;
    private String semester;
    
    private Student[] students;
    private Teacher[] teachers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    
    
    @NotNull
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="STUDENT_ID")
    private Student student;

    
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Teacher teacher;
    
     public Subject(Student student, Teacher teacher) {
        this.student = student;
        this.teacher = teacher;
        
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

    public Student[] getStudents() {
        return students;
    }

    public Teacher[] getTeachers() {
        return teachers;
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

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Arrays.deepHashCode(this.students);
        hash = 13 * hash + Arrays.deepHashCode(this.teachers);
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
        final Subject other = (Subject) obj;
        if (!Arrays.deepEquals(this.students, other.students)) {
            return false;
        }
        if (!Arrays.deepEquals(this.teachers, other.teachers)) {
            return false;
        }
        return true;
    }
    
    
   
    
}
