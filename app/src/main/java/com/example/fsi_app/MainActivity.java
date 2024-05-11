package com.example.fsi_app;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fsi_app.Model.BO.Bilan1s;
import com.example.fsi_app.Model.BO.Bilan2s;
import com.example.fsi_app.Model.BO.Etudiants;
import com.example.fsi_app.Model.DAO.Bilan1DAO;
import com.example.fsi_app.Model.DAO.Bilan2DAO;
import com.example.fsi_app.Model.DAO.EtudiantDAO;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button buttonConnexion;
    private EtudiantDAO etuitDAO;
    private Bilan1DAO bilan1Dao;
    private Bilan2DAO bilan2Dao;
    private ArrayList<Etudiants> toutLesEtudiants;
    private EditText identifiant;
    private EditText mdp;
    private Bilan1s lesnotes1;
    private Bilan2s lesnotes2;
    private ArrayList<String> lesMdp;
    private ArrayList<Etudiants> lesEtuSQL;
    private ArrayList<Bilan1s> lesBil1SQL;
    private ArrayList<Bilan2s> lesBil2SQL;
    private ArrayList<Etudiants> lesEtu;
    private ArrayList<Bilan1s> lesBil1;
    private ArrayList<Bilan2s> lesBil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etuitDAO = new EtudiantDAO(this);
        etuitDAO.open();
        bilan1Dao = new Bilan1DAO(this);
        bilan1Dao.open();
        bilan2Dao = new Bilan2DAO(this);
        bilan2Dao.open();
        initBdd();
        init();
    }

    private void init() {
        //lien avec xml
        buttonConnexion = (Button) findViewById(R.id.button);
        identifiant = (EditText) findViewById(R.id.Identifiant);
        mdp = (EditText) findViewById(R.id.mdp);
        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = identifiant.getText().toString();
                String pass = mdp.getText().toString();

                toutLesEtudiants = etuitDAO.getAllEtudiant();

                //connexion avec informations
                if (user.isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this, "nom d'utilisateurs manquant !", Toast.LENGTH_SHORT);
                    toast.show();
                }else if (pass.isEmpty()){
                        Toast toast = Toast.makeText(MainActivity.this, "mot de passe manquant !", Toast.LENGTH_SHORT);
                        toast.show();
                }
                else{
                    for (Etudiants lEtudiants : toutLesEtudiants) {
                        if (lEtudiants.getUsername_etu().equals(user)) {
                            if (etuitDAO.getMdp(lEtudiants.getId()).equals(pass)) {
                                Intent intent = new Intent(MainActivity.this, activity_2.class);
                                intent.putExtra("id", lEtudiants.getId());
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
    }
    public void initBdd () {
        Call<ArrayList<String>> callMdp = retrofitE.getInstance().getMyApi().getMdp();

        callMdp.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> callMdp, Response<ArrayList<String>> response) {
                if(response.isSuccessful() && response.body() != null){
                    lesMdp = response.body();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> callMdp, Throwable t) {
                Log.d("Erreur", "Pas de Mdp");
            }
        });

        Call<ArrayList<Etudiants>> callEtudiant = retrofitE.getInstance().getMyApi().getEtu();//On interroge notre API
        callEtudiant.enqueue(new Callback<ArrayList<Etudiants>>() {
            @Override
            public void onResponse(Call<ArrayList<Etudiants>> callEtudiant, Response<ArrayList<Etudiants>> response) {
                if(response.isSuccessful() && response.body() != null){
                    Log.d("Reponse", "Les étudiants ont bien été récupérés");
                    lesEtuSQL = etuitDAO.getAllEtudiant();
                    if (lesEtuSQL != null) {
                        for (Etudiants etu : lesEtuSQL) {
                            etuitDAO.deleteEtudiant(etu);
                        }
                    }
                    else {
                        Log.d("Reponse", "Aucun étudiant enregistré localement");
                    }
                    lesEtu = response.body();
                    //Réinitialisation du competeur d'incrémentation :
                    etuitDAO.remiseAZero();
                    for(int i = 0; i < lesEtu.size(); i++) {

                        etuitDAO.insertEtudiant(lesEtu.get(i), lesMdp.get(i));
                    }
                }
                else{
                    Log.d("Reponse", "Les étudiants n'ont pas été trouvés");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Etudiants>> callEtudiant, Throwable t) {
                Log.d("erreur", t.getMessage());
            }
        });

        Call<ArrayList<Bilan1s>> callBilan1s = retrofitE.getInstance().getMyApi().getBil1();
        callBilan1s.enqueue(new Callback<ArrayList<Bilan1s>>() {
            @Override
            public void onResponse(Call<ArrayList<Bilan1s>> call, Response<ArrayList<Bilan1s>> response) {
                if(response.isSuccessful() && response.body() != null){
                    Log.d("Reponse", "Les Bilans 1 ont bien été trouvés");
                    lesBil1SQL = bilan1Dao.getAllBilan1();
                    if(lesBil1SQL != null){
                        for(Bilan1s bil1 : lesBil1SQL){
                            bilan1Dao.deleteBilan1(bil1);
                        }
                    }
                    else {
                        Log.d("Reponse", "Aucun Bilan1 enregistré localement");
                    }
                    lesBil1 = response.body();
                }
                else {

                    Log.d("Reponse", "Les Bilans 1 n'ont pas été trouvés");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Bilan1s>> call, Throwable t) {
                Log.d("erreur", t.getMessage());
            }
        });

        Call<ArrayList<Etudiants>> callEtuBilan1 = retrofitE.getInstance().getMyApi().getEtuBil1();
        callEtuBilan1.enqueue(new Callback<ArrayList<Etudiants>>() {
            @Override
            public void onResponse(Call<ArrayList<Etudiants>> callEtuBilan1, Response<ArrayList<Etudiants>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("Reponse", "Les étubil1 ont bien été trouvés");
                    ArrayList<Etudiants> lesEtuBil1 = response.body();
                    bilan1Dao.remiseAZero();
                    for (int i = 0; i < lesBil1.size(); i++) {
                        lesBil1.get(i).setEtuit(lesEtuBil1.get(i));
                        bilan1Dao.insertBilan1(lesBil1.get(i));
                    }
                } else {
                    Log.d("Reponse", "Les étudiants liés aux bilans 1 n'ont pas été trouvé");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Etudiants>> callEtuBilan1, Throwable t) {
                Log.d("erreur", t.getMessage());
            }
        });


        Call<ArrayList<Bilan2s>> callBilan2s = retrofitE.getInstance().getMyApi().getBil2();
        callBilan2s.enqueue(new Callback<ArrayList<Bilan2s>>() {
            @Override
            public void onResponse(Call<ArrayList<Bilan2s>> callBilan2s, Response<ArrayList<Bilan2s>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("Reponse", "Les Bilans 2 ont bien été trouvés");
                    lesBil2SQL = bilan2Dao.getAllBilan2();
                    if (lesBil2SQL != null) {
                        for (Bilan2s bil2 : lesBil2SQL) {
                            bilan2Dao.deleteBilan2(bil2);
                        }
                    } else {
                        Log.d("Reponse", "Aucun étudiant enregistré localement");
                    }
                    lesBil2 = response.body();
                } else {

                    Log.d("Reponse", "Les Bilans 2 n'ont pas été trouvés");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Bilan2s>> callBilan2s, Throwable t) {
                Log.d("erreur", t.getMessage());
            }
        });

        Call<ArrayList<Etudiants>> callEtuBilan2 = retrofitE.getInstance().getMyApi().getEtuBil2();
        callEtuBilan2.enqueue(new Callback<ArrayList<Etudiants>>() {
            @Override
            public void onResponse(Call<ArrayList<Etudiants>> callEtuBilan2, Response<ArrayList<Etudiants>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("Reponse", "Les étudiants liés aux bilans 2 ont bien été trouvés");
                    ArrayList<Etudiants> lesEtuBil1 = response.body();
                    bilan2Dao.remiseAZero();
                    for (int i = 0; i < lesBil2.size(); i++) {
                        lesBil2.get(i).setEtuit(lesEtuBil1.get(i));
                        bilan2Dao.insertBilan2(lesBil2.get(i));
                    }
                } else {
                    Log.d("Reponse", "Les étudiants liés aux bilans 2 n'ont pas été trouvé");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Etudiants>> callEtuBilan2, Throwable t) {
                Log.d("erreur", t.getMessage());
            }
        });
    }
}