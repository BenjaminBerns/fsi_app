package com.example.fsi_app.Model.BO;

public class Classes {
    private int id;
    private String Libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public Classes(int id, String libelle) {
        this.id = id;
        Libelle = libelle;
    }

    public Classes(){

    }
}
