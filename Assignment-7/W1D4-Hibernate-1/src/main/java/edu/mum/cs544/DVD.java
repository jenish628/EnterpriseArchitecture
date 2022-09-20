package edu.mum.cs544;

import jakarta.persistence.Entity;

@Entity
public class DVD extends  Product{
    private String genere;

    public DVD(){

    }

    public DVD(String genere) {
        this.genere = genere;
    }

    public DVD(String name, String description, String genere) {
        super(name, description);
        this.genere = genere;
    }
}
