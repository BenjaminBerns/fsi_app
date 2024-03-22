package com.example.fsi_app.Model.BO;

import java.util.Date;

public class Bilan2s {
    private int id;
    private Date date_bil2;
    private String note_ent_bil2;
    private String note_doss_bil2;
    private String oral_bil2;
    private String remarques_bil2;
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

    public String getNote_ent_bil2() {
        return note_ent_bil2;
    }

    public void setNote_ent_bil2(String note_ent_bil2) {
        this.note_ent_bil2 = note_ent_bil2;
    }

    public String getNote_doss_bil2() {
        return note_doss_bil2;
    }

    public void setNote_doss_bil2(String note_doss_bil2) {
        this.note_doss_bil2 = note_doss_bil2;
    }

    public String getOral_bil2() {
        return oral_bil2;
    }

    public void setOral_bil2(String oral_bil2) {
        this.oral_bil2 = oral_bil2;
    }

    public String getRemarques_bil2() {
        return remarques_bil2;
    }

    public void setRemarques_bil2(String remarques_bil2) {
        this.remarques_bil2 = remarques_bil2;
    }

    public Bilan2s(int id, Date date_bil2, String note_ent_bil2, String note_doss_bil2, String oral_bil2, String remarques_bil2, Etudiants etuit) {
        this.id = id;
        this.date_bil2 = date_bil2;
        this.note_ent_bil2 = note_ent_bil2;
        this.note_doss_bil2 = note_doss_bil2;
        this.oral_bil2 = oral_bil2;
        this.remarques_bil2 = remarques_bil2;
        this.etuit = etuit;
    }

    public Bilan2s(){

    }
}
