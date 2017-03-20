/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author pompi20
 */
public class Material {
    private int id;
    private String text;
    private Student[] students;
    private Teacher teacher;

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
