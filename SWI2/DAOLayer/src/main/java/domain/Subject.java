/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classModel;

import java.util.Arrays;

/**
 *
 * @author pompi20
 */
public class Subject {
    private int id;
    private String popis;
    private int kredity;
    private String semester;
    
    private Student[] students;
    private Teacher[] teachers;

    public int getId() {
        return id;
    }

    public String getPopis() {
        return popis;
    }

    public int getKredity() {
        return kredity;
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

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setKredity(int kredity) {
        this.kredity = kredity;
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
