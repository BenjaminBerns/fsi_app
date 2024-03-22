package com.example.fsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        init();

    }

    private void init(){
        //lien avec xml
        buttonConnexion = (Button) findViewById(R.id.button);
        identifiant = (EditText) findViewById(R.id.Identifiant);
        mdp = (EditText) findViewById(R.id.mdp);

        //création d'étudiants pour simuler la bdd en dur puis création pour mysqlite
        Etudiants Student1 = new Etudiants(1, "Berns", "Benjamin", "benjiberns@mail.fr", "9 rue des monts", "0768723210", "SLAM", "bberns", "mdp123", "lyon", "69000", "GrandLyon", "aucunes info supplémentaire","2SIO", "Yemisen", "Yemisen");
        Etudiants Student2 = new Etudiants(2, "Baudoy", "Romain", "romain1105@gmail.com", "grange blanche", "0613558003", "SLAM", "rbauddoy", "mdp123", "LYON", "69000", "DCS", "aucunes info supplémentaire","2SIO", "DCSmaitreApprentissage", "DCStuteur");

        Calendar laDate = new GregorianCalendar(2020,11,12);
        Date ddj = laDate.getTime();
        lesnotes1 = new Bilan1s(1, ddj, 12, 15, 10, "ouais pas mal", Student1);
        lesnotes2 = new Bilan2s(1, ddj, "13", "16", "17", "très bien !!", Student2);

        etuitDAO.insertEtudiant(Student1);
        etuitDAO.insertEtudiant(Student2);
        bilan1Dao.insertBilan1(lesnotes1);
        bilan2Dao.insertBilan2(lesnotes2);

        toutLesEtudiants = etuitDAO.getAllEtudiant();

        //ajout dans la liste pour parcourir touts les étudiants dans la connexion
        Etudiants[] LesEtudiants = new Etudiants[2];
        LesEtudiants[0] = Student1;
        LesEtudiants[1] = Student2;

        Intent etu = new Intent(MainActivity.this, info.class);
        etu.putExtra("listeEtudiants", LesEtudiants);

        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = identifiant.getText().toString();
                String pass = mdp.getText().toString();

                //connexion avec informations
                for (Etudiants lEtudiants : toutLesEtudiants ) {
                    if (lEtudiants.getUsername_etu().equals(user)){
                        if (lEtudiants.getPass_etu().equals(pass)){
                            Intent intent = new Intent(MainActivity.this, activity_2.class);
                            intent.putExtra("l'étudiant", lEtudiants.getId());
                            startActivity(intent);
                        }
                    }
                }
            }
        });

    }
}