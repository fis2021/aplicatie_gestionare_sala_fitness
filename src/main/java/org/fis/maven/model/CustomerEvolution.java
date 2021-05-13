package org.fis.maven.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class CustomerEvolution {
    @Id
    private String name;
    private String Kg;
    private String Inaltimea;
    private String CentimetriiTaliei;

    public CustomerEvolution(String name, String Kg, String Inaltimea, String CentimetriiTaliei) {
        this.name = name;
        this.Kg = Kg;
        this.Inaltimea = Inaltimea;
        this.CentimetriiTaliei = CentimetriiTaliei;

    }

    public CustomerEvolution() {

    }

    public String getname(){
        return this.name;
    }

    public String getKg(){
        return this.Kg;
    }

    public String getInaltimea(){ return this.Inaltimea; }

    public String getCentimetriiTaliei(){
        return this.CentimetriiTaliei;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEvolution customerEvolution = (CustomerEvolution) o;

        if (!Objects.equals(name, customerEvolution.name)) return false;
        if (!Objects.equals(Kg, customerEvolution.Kg)) return false;
        if (!Objects.equals(Inaltimea, customerEvolution.Inaltimea)) return false;
        if (!Objects.equals(CentimetriiTaliei, customerEvolution.CentimetriiTaliei)) return false;
        return true;
    }
}
