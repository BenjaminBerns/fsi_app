package com.example.fsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fsi_app.Model.DAO.EtudiantDAO;

public class activity_2 extends AppCompatActivity {
    private Button buttonNotes;
    private Button buttonInfo;
    private Button deco;
    private int identifiant;
    private EtudiantDAO etuitDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        etuitDAO = new EtudiantDAO(this);
        etuitDAO.open();
        initiation();

    }

    private void initiation(){
        buttonNotes = (Button) findViewById(R.id.button3);
        buttonInfo = (Button) findViewById(R.id.button2);
        deco = (Button) findViewById(R.id.deconnexion);



        identifiant = getIntent().getIntExtra("l'étudiant", 0);

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
