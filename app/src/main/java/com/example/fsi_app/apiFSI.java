package com.example.fsi_app;

import android.telecom.Call;

import com.example.fsi_app.Model.BO.Bilan1s;
import com.example.fsi_app.Model.BO.Bilan2s;
import com.example.fsi_app.Model.BO.Etudiants;


public interface apiFSI {
    String BASE_URL = "https://olen-ort.fr/p2024/BuffaloBillGates/Projet_FSI/public/api";

    //@GET("{bilan1}")
    //@GET("{bilan1}")Call<Bilan1s> getEtudiant(@Path("bilan1") String id);
    //@GET("{bilan1}")@GET("{bilan2}")
    //@GET("{bilan1}")Call<Bilan2s> getEtudiant(@Path("bilan2") String id);
    //@GET("{bilan1}")@GET("{etudiant}")
    //@GET("{bilan1}")Call<Etudiants> getEtudiant(@Path("etudiant") String id);
}
