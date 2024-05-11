package com.example.fsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fsi_app.Model.BO.Entreprises;
import com.example.fsi_app.Model.BO.Etudiants;
import com.example.fsi_app.Model.BO.Tuteurs;
import com.example.fsi_app.Model.DAO.EtudiantDAO;

import java.lang.reflect.Array;

public class info extends AppCompatActivity {
    private Button buttonbck;
    private Button deco;
    private TextView nom;
    private TextView prenom;
    private TextView tel;
    private TextView adresse;
    private TextView mail;
    private TextView classe;
    private TextView info;
    private TextView nomE;
    private TextView adresseE;
    private TextView cpE;
    private TextView villeE;
    private TextView nomT;
    private TextView prenomT;
    private TextView mailT;
    private TextView telT;
    private TextView idT;
    private int identifiant;
    private EtudiantDAO etuitDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        etuitDAO = new EtudiantDAO(this);
        etuitDAO.open();
        init();

    }

    private void init() {
        buttonbck = (Button) findViewById(R.id.btnb2);
        deco = (Button) findViewById(R.id.deconnexion3);

        nom = (TextView) findViewById(R.id.nom);
        prenom = (TextView) findViewById(R.id.prenom);
        tel = (TextView) findViewById(R.id.tel);
        adresse = (TextView) findViewById(R.id.adresse);
        mail = (TextView) findViewById(R.id.mail);
        classe = (TextView) findViewById(R.id.classe);
        info = (TextView) findViewById(R.id.info);

        nomE = (TextView) findViewById(R.id.nomE);
        adresseE = (TextView) findViewById(R.id.adresseE);
        cpE = (TextView) findViewById(R.id.cpE);
        villeE = (TextView) findViewById(R.id.villeE);

        nomT = (TextView) findViewById(R.id.nomT);
        prenomT = (TextView) findViewById(R.id.prenomT);
        mailT = (TextView) findViewById(R.id.mailT);
        telT = (TextView) findViewById(R.id.telT);
        idT = (TextView) findViewById(R.id.idT);

        identifiant = getIntent().getIntExtra("id", 0);

        //Entreprises lesEntreprises = new Entreprises(1, "Apple", "7 rue neyret", "Lyon", "69667");
        //Tuteurs leTuteur = new Tuteurs(1, "monsieur T", "prenom T", "t@gmail.com", "0766782532");


        /*nomE.setText(lesEntreprises.getNomEntreprise());
        adresseE.setText(lesEntreprises.getAdresse());
        cpE.setText(lesEntreprises.getCodePostal());
        villeE.setText(lesEntreprises.getVille());

        //idT.setText(leTuteur.getId());
        nomT.setText(leTuteur.getNomTuteur());
        prenomT.setText(leTuteur.getPrenomTuteur());
        mailT.setText(leTuteur.getMailTuteur());
        telT.setText(leTuteur.getTelTuteur());*/

        identifiant = getIntent().getIntExtra("id", 0);

        nom.setText(etuitDAO.getByIdEtudiant(identifiant).getNom_etu());
        prenom.setText(etuitDAO.getByIdEtudiant(identifiant).getPre_etu());
        tel.setText(etuitDAO.getByIdEtudiant(identifiant).getTel_etu());
        adresse.setText(etuitDAO.getByIdEtudiant(identifiant).getAdresse_etu());
        mail.setText(etuitDAO.getByIdEtudiant(identifiant).getMail_etu());
        classe.setText(etuitDAO.getByIdEtudiant(identifiant).getClasse_etu());
        info.setText(etuitDAO.getByIdEtudiant(identifiant).getInfos_etu());

        nomE.setText(etuitDAO.getByIdEtudiant(identifiant).getNom_entreprise_etu());
        adresseE.setText(etuitDAO.getByIdEtudiant(identifiant).getAdresse_etu());
        cpE.setText(etuitDAO.getByIdEtudiant(identifiant).getCp_etu());
        villeE.setText(etuitDAO.getByIdEtudiant(identifiant).getVille_etu());

        idT.setText(etuitDAO.getByIdEtudiant(identifiant).getNom_etu());
        nomT.setText(etuitDAO.getByIdEtudiant(identifiant).getNom_tuteur_etu());
        prenomT.setText(etuitDAO.getByIdEtudiant(identifiant).getPre_etu());
        mailT.setText(etuitDAO.getByIdEtudiant(identifiant).getMail_etu());
        telT.setText(etuitDAO.getByIdEtudiant(identifiant).getTel_etu());


        buttonbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info.this, activity_2.class);
                intent.putExtra("id", identifiant);
                startActivity(intent);
            }
        });
        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
