package com.example.fsi_app.Model.BO;

public class Etudiants {
    private int id;
    private String nom_etu;
    private String pre_etu;
    private String mail_etu;
    private String adresse_etu;
    private String tel_etu;
    private String spe_etu;
    private String username_etu;
    private String ville_etu;
    private String cp_etu;
    private String nom_entreprise_etu;
    private String infos_etu;
    private String classe_etu;
    private String nom_maitre_apprenti;
    private String nom_tuteur_etu;

    public String getAdresse_etu() {
        return adresse_etu;
    }

    public void setAdresse_etu(String adresse_etu) {
        this.adresse_etu = adresse_etu;
    }

    public String getVille_etu() {
        return ville_etu;
    }

    public void setVille_etu(String ville_etu) {
        this.ville_etu = ville_etu;
    }

    public String getCp_etu() {
        return cp_etu;
    }

    public void setCp_etu(String cp_etu) {
        this.cp_etu = cp_etu;
    }

    public String getInfos_etu() {
        return infos_etu;
    }

    public void setInfos_etu(String infos_etu) {
        this.infos_etu = infos_etu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_etu() {
        return nom_etu;
    }

    public void setNom_etu(String nom_etu) {
        this.nom_etu = nom_etu;
    }

    public String getPre_etu() {
        return pre_etu;
    }

    public void setPre_etu(String pre_etu) {
        this.pre_etu = pre_etu;
    }

    public String getMail_etu() {
        return mail_etu;
    }

    public void setMail_etu(String mail_etu) {
        this.mail_etu = mail_etu;
    }

    public String getTel_etu() {
        return tel_etu;
    }

    public void setTel_etu(String tel_etu) {
        this.tel_etu = tel_etu;
    }

    public String getSpe_etu() {
        return spe_etu;
    }

    public void setSpe_etu(String spe_etu) {
        this.spe_etu = spe_etu;
    }

    public String getUsername_etu() {
        return username_etu;
    }

    public void setUsername_etu(String username_etu) {
        this.username_etu = username_etu;
    }

    public String getNom_entreprise_etu() {
        return nom_entreprise_etu;
    }

    public void setNom_entreprise_etu(String nom_entreprise_etu) {
        this.nom_entreprise_etu = nom_entreprise_etu;
    }

    public String getClasse_etu() {
        return classe_etu;
    }

    public void setClasse_etu(String classe_etu) {
        this.classe_etu = classe_etu;
    }


    public String getNom_maitre_apprenti() {
        return nom_maitre_apprenti;
    }

    public void setNom_maitre_apprenti(String nom_maitre_apprenti) {
        this.nom_maitre_apprenti = nom_maitre_apprenti;
    }

    public String getNom_tuteur_etu() {
        return nom_tuteur_etu;
    }

    public void setNom_tuteur_etu(String nom_tuteur_etu) {
        this.nom_tuteur_etu = nom_tuteur_etu;
    }

    public Etudiants(int id, String nom_etu, String pre_etu, String mail_etu, String adresse_etu, String tel_etu, String spe_etu, String username_etu, String ville_etu, String cp_etu, String nom_entreprise_etu, String infos_etu, String classe_etu, String nom_maitre_apprenti, String nom_tuteur_etu) {
        this.id = id;
        this.nom_etu = nom_etu;
        this.pre_etu = pre_etu;
        this.mail_etu = mail_etu;
        this.adresse_etu = adresse_etu;
        this.tel_etu = tel_etu;
        this.spe_etu = spe_etu;
        this.username_etu = username_etu;
        this.ville_etu = ville_etu;
        this.cp_etu = cp_etu;
        this.nom_entreprise_etu = nom_entreprise_etu;
        this.infos_etu = infos_etu;
        this.classe_etu = classe_etu;
        this.nom_maitre_apprenti = nom_maitre_apprenti;
        this.nom_tuteur_etu = nom_tuteur_etu;
    }

    public Etudiants(){

    }
}
