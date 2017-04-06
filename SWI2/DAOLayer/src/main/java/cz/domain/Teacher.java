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
public class Teacher {
    
    private String name;
    private String surname;
    private String address;
    private String contact;
    private String faculty;
    private String birthDate;
    private String department;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="PROJECT_ID")
    private Set<Project> projects = new HashSet<>();
    
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="SUBJECT_ID")
    private Set<Subject> subjects = new HashSet<>();
    
    
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="MATERIAL_ID")
    private Set<Material> materials = new HashSet<>();
     
    
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TASK_ID")
    private Set<Task> tasks = new HashSet<>();
    
    
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEST_ID")
    private Set<Test> tests = new HashSet<>();
        
     public Teacher(String name, String surname) {
         this.name = name;
         this.surname = surname;
                 
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        if (project != null) {
            this.projects.add(project);
        }
    }

    public void addProjects(Collection<Project> projects) {
        if (projects != null) {
            this.projects.addAll(projects);
        }
    }
    
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        if (subject != null) {
            this.subjects.add(subject);
        }
    }

    public void addSubjects(Collection<Subject> subjects) {
        if (subjects != null) {
            this.subjects.addAll(subjects);
        }
    }
    
    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }
public void addMaterial(Material material) {
        if (material != null) {
            this.materials.add(material);
        }
    }

    public void addMaterials(Collection<Material> materialmaterials) {
        if (materials != null) {
            this.materials.addAll(materials);
        }
    }
    
    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
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
    
    public void setTests(Set<Test> tests) {
        this.tests = tests;
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
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Set<Test> getTests() {
        return tests;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.projects);
        hash = 17 * hash + Objects.hashCode(this.subjects);
        hash = 17 * hash + Objects.hashCode(this.materials);
        hash = 17 * hash + Objects.hashCode(this.tasks);
        hash = 17 * hash + Objects.hashCode(this.tests);
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
        final Teacher other = (Teacher) obj;
        if (!Objects.equals(this.projects, other.projects)) {
            return false;
        }
        if (!Objects.equals(this.subjects, other.subjects)) {
            return false;
        }
        if (!Objects.equals(this.materials, other.materials)) {
            return false;
        }
        if (!Objects.equals(this.tasks, other.tasks)) {
            return false;
        }
        if (!Objects.equals(this.tests, other.tests)) {
            return false;
        }
        return true;
    }

    
    
   
    
}
