package com.example.fsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fsi_app.Model.BO.Bilan1s;
import com.example.fsi_app.Model.BO.Bilan2s;
import com.example.fsi_app.Model.BO.Etudiants;
import com.example.fsi_app.Model.DAO.Bilan1DAO;
import com.example.fsi_app.Model.DAO.Bilan2DAO;
import com.example.fsi_app.Model.DAO.EtudiantDAO;

public class notes extends AppCompatActivity {
    private Button buttonbck;
    private Button deco;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private EtudiantDAO etuitDAO;
    private int identifiant;
    private Bilan1DAO bilan1Dao;
    private Bilan2DAO bilan2Dao;
    private Bilan1s bil1;
    private Bilan2s bil2;
    private Date dateBil1;
    private Date dateBil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);
        etuitDAO = new EtudiantDAO(this);
        etuitDAO.open();
        bilan1Dao = new Bilan1DAO(this);
        bilan1Dao.open();
        bilan2Dao = new Bilan2DAO(this);
        bilan2Dao.open();
        init();

    }

    private void init() {
        buttonbck = (Button) findViewById(R.id.btnb2);
        deco = (Button) findViewById(R.id.deconnexion2);

        tv1 = (TextView) findViewById(R.id.editText1_1);
        tv2 = (TextView) findViewById(R.id.editText1_2);
        tv3 = (TextView) findViewById(R.id.editText1_3);
        tv4 = (TextView) findViewById(R.id.editText1_4);
        tv5 = (TextView) findViewById(R.id.editText1_5);

        tv6 = (TextView) findViewById(R.id.editText2_1);
        tv7 = (TextView) findViewById(R.id.editText2_2);
        tv8 = (TextView) findViewById(R.id.editText2_3);
        tv9 = (TextView) findViewById(R.id.editText2_4);
        tv10 = (TextView) findViewById(R.id.editText2_5);

        Locale locale = new Locale("fr");

        identifiant = getIntent().getIntExtra("id", 0);
        Log.d("Message", "id : " + identifiant);

        bil1 = bilan1Dao.getByIdBilan1(identifiant);
        bil2 = bilan2Dao.getByIdBilan2(identifiant);

        //Calendar laDate = new GregorianCalendar(2024, 3,21);
        //Date ddj = laDate.getTime();

        //Locale locale = new Locale("fr");
        //laDate = new Date(intentNotes.getExtras().getLong("dateBil"));
        //tv1.setText(DateFormat.getDateInstance(DateFormat.LONG, locale).format(laDate));


        //Etudiants Student1 = new Etudiants(1, "Berns", "Benjamin", "benjiberns@mail.fr", "9 rue des monts", "0768723210", "SLAM", "bberns", "mdp123", "lyon", "69000", "GrandLyon", "aucunes info supplémentaire","2SIO", "Yemisen", "Yemisen");
        //Etudiants Student2 = new Etudiants(2, "Baudoy", "Romain", "romain1105@gmail.com", "grange blanche", "0613558003", "SLAM", "rbauddoy", "mdp123", "LYON", "69000", "DCS", "aucunes info supplémentaire","2SIO", "DCSmaitreApprentissage", "DCStuteur");


        //Date dateDuJour = lesnotes1.getDate_bil1();
        //tv1.setText((CharSequence) dateDuJour);
        //(CharSequence) bil1.getDate_bil1()
        dateBil1 = new Date(bil1.getDate_bil1().getTime());
        tv1.setText(DateFormat.getDateInstance(DateFormat.LONG, locale).format(dateBil1));

        //String noteEntBil1 = lesnotes1.getNote_ent_bil1();
        //tv2.setText(noteEntBil1);
        tv2.setText(" ");

        //String noteDosBil1 = lesnotes1.getNote_doss_bil1();
        //tv3.setText(noteDosBil1);
        tv3.setText(String.valueOf(bil1.getNote_doss_bil1()));

        //String oralBil1 = lesnotes1.getOral_bil1();
        //tv4.setText(oralBil1);
        tv4.setText(String.valueOf(bil1.getNote_oral_bil1()));

        //String remarquesbil1 = lesnotes1.getRemarques_bil1();
        //tv5.setText(remarquesbil1);
        tv5.setText(bil1.getRemarques_bil1());

        //Date dateDuJour2 = lesnotes2.getDate_bil2();
        //tv6.setText((CharSequence) dateDuJour2);
        //(CharSequence) bil2.getDate_bil2()
        dateBil2 = new Date(bil2.getDate_bil2().getTime());
        tv6.setText(DateFormat.getDateInstance(DateFormat.LONG, locale).format(dateBil2));

        tv7.setText(" ");

        //String noteDosBil2 = lesnotes2.getNote_doss_bil2();
        //tv8.setText(noteDosBil2);
        tv8.setText(String.valueOf(bil2.getNote_doss_bil2()));

        //String oralBil2 = lesnotes2.getOral_bil2();
        //tv9.setText(oralBil2);
        tv9.setText(String.valueOf(bil2.getNote_oral_bil2()));

        //String remarquesbil2 = lesnotes2.getRemarques_bil2();
        //tv10.setText(remarquesbil2);
        tv10.setText(bil2.getRemarques_bil2());


        buttonbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notes.this, activity_2.class);
                intent.putExtra("id", identifiant);
                startActivity(intent);
            }
        });

        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notes.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
