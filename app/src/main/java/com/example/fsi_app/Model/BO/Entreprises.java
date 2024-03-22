package com.example.fsi_app.Model.BO;

public class Entreprises {
    private int id;
    private String NomEntreprise;
    private String Adresse;
    private String Ville;
    private String CodePostal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return NomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        NomEntreprise = nomEntreprise;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String codePostal) {
        CodePostal = codePostal;
    }

    public Entreprises(int id, String nomEntreprise, String adresse, String ville, String codePostal) {
        this.id = id;
        NomEntreprise = nomEntreprise;
        Adresse = adresse;
        Ville = ville;
        CodePostal = codePostal;
    }

    public Entreprises(){

    }
}
