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
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Student> students = new HashSet<>();

    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Set<Teacher> teachers = new HashSet<>();
    
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TASK_ID")
    private Set<Task> tasks = new HashSet<>();
        
     public Test(String title ,Double ratio) {
         this.title = title;
         this.ratio = ratio;
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

    public Set<Task> getTask() {
        return tasks;
    }

    public void addTask(Task task) {
        if (task != null) {
            this.tasks.add(task);
        }
    }

    public void addTasks(Collection<Task> tasks) {
        if (tasks != null) {
            this.tasks.addAll(tasks);
        }
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

    
    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.students);
        hash = 53 * hash + Objects.hashCode(this.teachers);
        hash = 53 * hash + Objects.hashCode(this.tasks);
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
        if (!Objects.equals(this.students, other.students)) {
            return false;
        }
        if (!Objects.equals(this.teachers, other.teachers)) {
            return false;
        }
        if (!Objects.equals(this.tasks, other.tasks)) {
            return false;
        }
        return true;
    }

    
    
}
