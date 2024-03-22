package com.example.fsi_app.Model.BO;

public class Tuteurs {
    private int id;
    private String NomTuteur;
    private String PrenomTuteur;
    private String TelTuteur;
    private String MailTuteur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomTuteur() {
        return NomTuteur;
    }

    public void setNomTuteur(String nomTuteur) {
        NomTuteur = nomTuteur;
    }

    public String getPrenomTuteur() {
        return PrenomTuteur;
    }

    public void setPrenomTuteur(String prenomTuteur) {
        PrenomTuteur = prenomTuteur;
    }

    public String getTelTuteur() {
        return TelTuteur;
    }

    public void setTelTuteur(String telTuteur) {
        TelTuteur = telTuteur;
    }

    public String getMailTuteur() {
        return MailTuteur;
    }

    public void setMailTuteur(String mailTuteur) {
        MailTuteur = mailTuteur;
    }

    public Tuteurs(int id, String nomTuteur, String prenomTuteur, String telTuteur, String mailTuteur) {
        this.id = id;
        NomTuteur = nomTuteur;
        PrenomTuteur = prenomTuteur;
        TelTuteur = telTuteur;
        MailTuteur = mailTuteur;
    }

    public Tuteurs() {

    }
}
