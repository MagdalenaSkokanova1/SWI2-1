/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author pompi20
 */
public class Test {
   
    private Double ratio;
    private String title;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="STUDENT_ID")
    private Student student;

    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Teacher teacher;
    
    @NotNull
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TASK_ID")
    private Task[] tasks;
    
     public Test(Student student, Teacher teacher, Task task) {
        this.student = student;
        this.teacher = teacher;
        this.tasks = tasks;        
    }
    

    public int getId() {
        return id;
    }

    public Double getRatio() {
        return ratio;
    }

    public String getTitle() {
        return title;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Arrays.deepHashCode(this.tasks);
        hash = 89 * hash + Objects.hashCode(this.teacher);
        hash = 89 * hash + Objects.hashCode(this.student);
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
        final Test other = (Test) obj;
        if (!Arrays.deepEquals(this.tasks, other.tasks)) {
            return false;
        }
        if (!Objects.equals(this.teacher, other.teacher)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return true;
    }
    
  
    
}
