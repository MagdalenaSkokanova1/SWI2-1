/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Arrays;


/**
 *
 * @author pompi20
 */
public class Teacher {
    private int id;
    private String jmeno;
    private String prijmeni;
    private String adresa;
    private String kontakt;
    private String fakulta;
    private String datumNarozeni;
    private String ustav;
        
    
    private Test[] tests;
    private Task[] tasks;
    private Project[] projects;
    private Subject[] subjects;
    private Material[] materials;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="PROJECT_ID")
    private Projekt project;

    @NotNull
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="SUBJECT_ID")
    private Subject subject;
    
    @NotNull
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="MATERIAL_ID")
    private Material material;
    
    @NotNull
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TASK_ID")
    private Task task;
    
    @NotNull
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TEST_ID")
    private Test test;
        
     public Teacher(Project project, Subject subject, Material material, Task task, Test test) {
        this.project = project;
        this.subject = subject;
        this.material = material;
        this.task = task;
        this.test = test;
        
    }

    public int getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getKontakt() {
        return kontakt;
    }

    public String getFakulta() {
        return fakulta;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public String getUstav() {
        return ustav;
    }

    public Test[] getTests() {
        return tests;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public Project[] getProjects() {
        return projects;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public void setFakulta(String fakulta) {
        this.fakulta = fakulta;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public void setUstav(String ustav) {
        this.ustav = ustav;
    }

    public void setTests(Test[] tests) {
        this.tests = tests;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Arrays.deepHashCode(this.tests);
        hash = 97 * hash + Arrays.deepHashCode(this.tasks);
        hash = 97 * hash + Arrays.deepHashCode(this.projects);
        hash = 97 * hash + Arrays.deepHashCode(this.subjects);
        hash = 97 * hash + Arrays.deepHashCode(this.materials);
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
        if (!Arrays.deepEquals(this.tests, other.tests)) {
            return false;
        }
        if (!Arrays.deepEquals(this.tasks, other.tasks)) {
            return false;
        }
        if (!Arrays.deepEquals(this.projects, other.projects)) {
            return false;
        }
        if (!Arrays.deepEquals(this.subjects, other.subjects)) {
            return false;
        }
        if (!Arrays.deepEquals(this.materials, other.materials)) {
            return false;
        }
        return true;
    }

   
    
}
