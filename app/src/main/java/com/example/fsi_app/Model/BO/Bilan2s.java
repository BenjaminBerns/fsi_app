package com.example.fsi_app.Model.BO;

import java.util.Date;

public class Bilan2s {
    private int id;
    private Date date_bil2;
    private double note_doss_bil2;
    private double note_oral_bil2;
    private String remarques_bil2;
    private String sujet_analyse_bil2;
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

    public Date getDate_bil2() {
        return date_bil2;
    }

    public void setDate_bil2(Date date_bil2) {
        this.date_bil2 = date_bil2;
    }

    public double getNote_oral_bil2() {
        return note_oral_bil2;
    }

    public void setNote_oral_bil2(double note_oral_bil2) {
        this.note_oral_bil2 = note_oral_bil2;
    }

    public double getNote_doss_bil2() {
        return note_doss_bil2;
    }

    public void setNote_doss_bil2(double note_doss_bil2) {
        this.note_doss_bil2 = note_doss_bil2;
    }


    public String getRemarques_bil2() {
        return remarques_bil2;
    }

    public void setRemarques_bil2(String remarques_bil2) {
        this.remarques_bil2 = remarques_bil2;
    }

    public String getSujet_analyse_bil2() {
        return sujet_analyse_bil2;
    }

    public void setSujet_analyse_bil2(String sujet_analyse_bil2) {
        this.sujet_analyse_bil2 = sujet_analyse_bil2;
    }

    public Bilan2s(int id, Date date_bil2, double note_doss_bil2, double note_oral_bil2, String remarques_bil2, String sujet_analyse_bil2, Etudiants etuit) {
        this.id = id;
        this.date_bil2 = date_bil2;
        this.note_doss_bil2 = note_doss_bil2;
        this.note_oral_bil2 = note_oral_bil2;
        this.remarques_bil2 = remarques_bil2;
        this.sujet_analyse_bil2 = sujet_analyse_bil2;
        this.etuit = etuit;
    }

    public Bilan2s(){

    }
}
