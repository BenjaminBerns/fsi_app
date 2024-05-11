package com.example.fsi_app;

import retrofit2.Call;

import com.example.fsi_app.Model.BO.Bilan1s;
import com.example.fsi_app.Model.BO.Bilan2s;
import com.example.fsi_app.Model.BO.Etudiants;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface apiFSI {
    String BASE_URL = "https://olen-ort.fr/p2024/BuffaloBillGates/Projet_FSI/public/api/";
    @GET("mdp")
    Call<ArrayList<String>> getMdp();

    @GET("Etudiants")//Param en +
    Call<ArrayList<Etudiants>> getEtu();//Rajouter paramètre à url

    @GET("Bilans1")
    Call<ArrayList<Bilan1s>> getBil1();

    @GET("EtuBilan1")
    Call<ArrayList<Etudiants>> getEtuBil1();

    @GET("Bilans2")
    Call<ArrayList<Bilan2s>> getBil2();

    @GET("EtuBilan2")
    Call<ArrayList<Etudiants>> getEtuBil2();
}
