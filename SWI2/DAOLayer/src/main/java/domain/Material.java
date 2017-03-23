/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author pompi20
 */
public class Material {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="STUDENT_ID")
    private Set<Student> students = new HashSet<>();
    
    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Teacher teacher;
    
    private String text;
    
    
    public Material(String text) {
        this.text = text;
        
    }

    
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Student[] getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Arrays.deepHashCode(this.students);
        hash = 59 * hash + Objects.hashCode(this.teacher);
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
        if (!Arrays.deepEquals(this.students, other.students)) {
            return false;
        }
        if (!Objects.equals(this.teacher, other.teacher)) {
            return false;
        }
        return true;
    }
    
    
    
}
