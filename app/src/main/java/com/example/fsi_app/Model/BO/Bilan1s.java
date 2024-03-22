package com.example.fsi_app.Model.BO;

import java.util.Date;

public class Bilan1s {
    private int id;
    private Date date_bil1;
    private int note_ent_bil1;
    private int note_doss_bil1;
    private int oral_bil1;
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

    public int getNote_ent_bil1() {
        return note_ent_bil1;
    }

    public void setNote_ent_bil1(int note_ent_bil1) {
        this.note_ent_bil1 = note_ent_bil1;
    }

    public int getNote_doss_bil1() {
        return note_doss_bil1;
    }

    public void setNote_doss_bil1(int note_doss_bil1) {
        this.note_doss_bil1 = note_doss_bil1;
    }

    public int getOral_bil1() {
        return oral_bil1;
    }

    public void setOral_bil1(int oral_bil1) {
        this.oral_bil1 = oral_bil1;
    }

    public String getRemarques_bil1() {
        return remarques_bil1;
    }

    public void setRemarques_bil1(String remarques_bil1) {
        this.remarques_bil1 = remarques_bil1;
    }

    public Bilan1s(int id, Date date_bil1, int note_ent_bil1, int note_doss_bil1, int oral_bil1, String remarques_bil1, Etudiants etuit) {
        this.id = id;
        this.date_bil1 = date_bil1;
        this.note_ent_bil1 = note_ent_bil1;
        this.note_doss_bil1 = note_doss_bil1;
        this.oral_bil1 = oral_bil1;
        this.remarques_bil1 = remarques_bil1;
        this.etuit = etuit;
    }

    public Bilan1s(){

    }
}
