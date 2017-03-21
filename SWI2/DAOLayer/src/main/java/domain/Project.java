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
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Teacher teacher;
    
     public Project(Teacher teacher) {
        this.teacher = teacher;
            }
    
    
    private Teacher[] teachers;

    public int getId() {
        return id;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Arrays.deepHashCode(this.teachers);
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
        final Project other = (Project) obj;
        if (!Arrays.deepEquals(this.teachers, other.teachers)) {
            return false;
        }
        return true;
    }
    
}
