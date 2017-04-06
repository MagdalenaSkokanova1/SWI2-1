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
public class Task {
    private String question;
    private String correctAnswer;
    private String[] badAnswer;
    private int dificulty;
    private String category;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEST_ID")
    private Set<Test> tests = new HashSet<>();

    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEACHER_ID")
    private Set<Teacher> teachers = new HashSet<>();
    
     public Task(String question, String category) {
        this.question = question;
        this.category = category;
      }
    
   public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDificulty() {
        return dificulty;
    }

    public String getCategory() {
        return category;
    }

    public Set<Teacher> getTeacher() {
        return teachers;
    }
    public Set<Test> getTest() {
        return tests;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setBadAnswer(String[] badAnswer) {
        this.badAnswer = badAnswer;
    }

    public void setDificulty(int dificulty) {
        this.dificulty = dificulty;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public void addTest(Test test) {
        if (test != null) {
            this.tests.add(test);
        }
    }

    public void addTests(Collection<Test> tests) {
        if (tests != null) {
            this.tests.addAll(tests);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.tests);
        hash = 61 * hash + Objects.hashCode(this.teachers);
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
        final Task other = (Task) obj;
        if (!Objects.equals(this.tests, other.tests)) {
            return false;
        }
        if (!Objects.equals(this.teachers, other.teachers)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
