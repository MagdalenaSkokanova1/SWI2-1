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
public class Student {
    private int id;
    private String jmeno;
    private String prijmeni;
    private String adresa;
    private String kontakt;
    private String fakulta;
    private String datumNarozeni;
    private int rocnik;
    private String obor;
    private String stupenStudia;
    
    private Subject[] subjects;
    private Material[] materials;
    private Test[] tests;

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

    public int getRocnik() {
        return rocnik;
    }

    public String getObor() {
        return obor;
    }

    public String getStupenStudia() {
        return stupenStudia;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public Test[] getTests() {
        return tests;
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

    public void setRocnik(int rocnik) {
        this.rocnik = rocnik;
    }

    public void setObor(String obor) {
        this.obor = obor;
    }

    public void setStupenStudia(String stupenStudia) {
        this.stupenStudia = stupenStudia;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }

    public void setTests(Test[] tests) {
        this.tests = tests;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Arrays.deepHashCode(this.subjects);
        hash = 29 * hash + Arrays.deepHashCode(this.materials);
        hash = 29 * hash + Arrays.deepHashCode(this.tests);
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
        final Student other = (Student) obj;
        if (!Arrays.deepEquals(this.subjects, other.subjects)) {
            return false;
        }
        if (!Arrays.deepEquals(this.materials, other.materials)) {
            return false;
        }
        if (!Arrays.deepEquals(this.tests, other.tests)) {
            return false;
        }
        return true;
    }
    
    
    
}
