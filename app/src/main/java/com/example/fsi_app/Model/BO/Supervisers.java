package com.example.fsi_app.Model.BO;

public class Supervisers {
    private int NbAlternantMax;

    public int getNbAlternantMax() {
        return NbAlternantMax;
    }

    public void setNbAlternantMax(int nbAlternantMax) {
        NbAlternantMax = nbAlternantMax;
    }

    public Supervisers(int nbAlternantMax) {
        NbAlternantMax = nbAlternantMax;
    }

    public Supervisers() {

    }
}
