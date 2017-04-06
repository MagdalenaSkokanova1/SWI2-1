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

    public Teacher getTeacher() {
        return teacher;
    }

    public Test[] getTests() {
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

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setTests(Test[] tests) {
        this.tests = tests;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.teacher);
        hash = 53 * hash + Arrays.deepHashCode(this.tests);
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
        if (!Objects.equals(this.teacher, other.teacher)) {
            return false;
        }
        if (!Arrays.deepEquals(this.tests, other.tests)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
