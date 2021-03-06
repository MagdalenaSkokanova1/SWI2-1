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
@Entity
public class Material {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Student student;
    /*
    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Set<Teacher> teachers = new HashSet<>();
    */
    
    
    
    
    public Material(String text) {
        this.text = text;
    }

    protected Material(){}
    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*public Set<Student> getStudents() {
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
    }*/

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        //hash = 59 * hash + Objects.hashCode(this.students);
        //hash = 59 * hash + Objects.hashCode(this.teachers);
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
        final Material other = (Material) obj;
       /* if (!Objects.equals(this.students, other.students)) {
            return false;
        }
        if (!Objects.equals(this.teachers, other.teachers)) {
            return false;
        }*/
        return true;
    }
    
    
    
}
