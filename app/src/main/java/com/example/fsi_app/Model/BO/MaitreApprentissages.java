package com.example.fsi_app.Model.BO;

public class MaitreApprentissages {
    private int id;
    private String NomMaitreApp;
    private String PrenomMaitreApp;
    private String TelMaitreApp;
    private String MailMaitreApp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMaitreApp() {
        return NomMaitreApp;
    }

    public void setNomMaitreApp(String nomMaitreApp) {
        NomMaitreApp = nomMaitreApp;
    }

    public String getPrenomMaitreApp() {
        return PrenomMaitreApp;
    }

    public void setPrenomMaitreApp(String prenomMaitreApp) {
        PrenomMaitreApp = prenomMaitreApp;
    }

    public String getTelMaitreApp() {
        return TelMaitreApp;
    }

    public void setTelMaitreApp(String telMaitreApp) {
        TelMaitreApp = telMaitreApp;
    }

    public String getMailMaitreApp() {
        return MailMaitreApp;
    }

    public void setMailMaitreApp(String mailMaitreApp) {
        MailMaitreApp = mailMaitreApp;
    }

    public MaitreApprentissages(int id, String nomMaitreApp, String prenomMaitreApp, String telMaitreApp, String mailMaitreApp) {
        this.id = id;
        NomMaitreApp = nomMaitreApp;
        PrenomMaitreApp = prenomMaitreApp;
        TelMaitreApp = telMaitreApp;
        MailMaitreApp = mailMaitreApp;
    }

    public MaitreApprentissages() {

    }
}
