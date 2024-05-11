package com.example.fsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fsi_app.Model.BO.Bilan1s;
import com.example.fsi_app.Model.BO.Etudiants;
import com.example.fsi_app.Model.DAO.Bilan1DAO;
import com.example.fsi_app.Model.DAO.EtudiantDAO;

public class activity_2 extends AppCompatActivity {
    private Button buttonNotes;
    private Button buttonInfo;
    private Button deco;
    private int identifiant;
    private EtudiantDAO etuitDAO;
    private Bilan1DAO bil1DAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        etuitDAO = new EtudiantDAO(this);
        etuitDAO.open();
        bil1DAO = new Bilan1DAO(this);
        bil1DAO.open();
        initiation();

    }

    private void initiation(){
        buttonNotes = (Button) findViewById(R.id.button3);
        buttonInfo = (Button) findViewById(R.id.button2);
        deco = (Button) findViewById(R.id.deconnexion);

        identifiant = getIntent().getIntExtra("id", 0);
        Log.d("Message", "id : " + identifiant);

        Bilan1s bil1 = bil1DAO.getByIdBilan1(3);
        Log.d("Message", "id_etu : " + bil1.getDate_bil1());

        buttonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_2.this, notes.class);
                intent.putExtra("id", identifiant);
                startActivity(intent);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_2.this, info.class);
                intent.putExtra("id", identifiant);
                startActivity(intent);
            }
        });

        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
