package com.example.fsi_app.Model.BO;

import java.util.Date;

public class Bilan1s {
    private int id;
    private Date date_bil1;
    private double note_ent_bil1;
    private double note_doss_bil1;
    private double note_oral_bil1;
    private String remarques_bil1;
    private Etudiants etuit;

    public Etudiants getEtuit() {
        return etuit;
    }

    public void setEtuit(Etudiants etuit) {
        this.etuit = etuit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_bil1() {
        return date_bil1;
    }

    public void setDate_bil1(Date date_bil1) {
        this.date_bil1 = date_bil1;
    }

    public double getNote_ent_bil1() {
        return note_ent_bil1;
    }

    public void setNote_ent_bil1(double note_ent_bil1) {
        this.note_ent_bil1 = note_ent_bil1;
    }

    public double getNote_doss_bil1() {
        return note_doss_bil1;
    }

    public void setNote_doss_bil1(double note_doss_bil1) {
        this.note_doss_bil1 = note_doss_bil1;
    }

    public double getNote_oral_bil1() {
        return note_oral_bil1;
    }

    public void setNote_oral_bil1(double note_oral_bil1) {
        this.note_oral_bil1 = note_oral_bil1;
    }

    public String getRemarques_bil1() {
        return remarques_bil1;
    }

    public void setRemarques_bil1(String remarques_bil1) {
        this.remarques_bil1 = remarques_bil1;
    }

    public Bilan1s(int id, Date date_bil1, double note_ent_bil1, double note_doss_bil1, double note_oral_bil1, String remarques_bil1, Etudiants etuit) {
        this.id = id;
        this.date_bil1 = date_bil1;
        this.note_ent_bil1 = note_ent_bil1;
        this.note_doss_bil1 = note_doss_bil1;
        this.note_oral_bil1 = note_oral_bil1;
        this.remarques_bil1 = remarques_bil1;
        this.etuit = etuit;
    }




    public Bilan1s(){

    }
}
