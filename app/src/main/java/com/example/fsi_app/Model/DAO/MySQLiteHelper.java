package com.example.fsi_app.Model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MySQLiteHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "dbs12374824";
        private static final int DATABASE_VERSION = 7;
        public static final String TABLE_ETUDIANT = "etudiants";
        public static final String TABLE_BILAN1 = "bilan1s";
        public static final String TABLE_BILAN2 = "bilan2s";
        private static final String DATABASE_CREATE_ETUDIANT = "CREATE TABLE IF NOT EXISTS " +
                TABLE_ETUDIANT + "( id integer primary key autoincrement, " +
                "nom_etu text, pre_etu text, mail_etu text, tel_etu text, adresse_etu text, " +
                "ville_etu text, cp_etu text, spe_etu text, infos_etu text, " +
                "username_etu text, pass_etu text, " +
                "nom_entreprise_etu text, " +
                "nom_tuteur_etu text," +
                "nom_maitre_apprenti text," +
                "classe_etu text)";
        private static final String DATABASE_CREATE_BILAN1 = "CREATE TABLE IF NOT EXISTS " +
                TABLE_BILAN1 + "( id integer primary key autoincrement, " +
                "date_bil1 date, note_ent_bil1 real, note_doss_bil1 real, note_oral_bil1 real, remarques_bil1 text," +
                "id_etu integer," +
                "FOREIGN KEY(id_etu) REFERENCES etudiants(id));";
        private static final String DATABASE_CREATE_BILAN2 = "CREATE TABLE IF NOT EXISTS " +
                TABLE_BILAN2 + "( id integer primary key autoincrement, " +
                "date_bil2 date, note_doss_bil2 real, note_oral_bil2 real, remarques_bil2 text, sujet_analyse_bil2 text," +
                "id_etu integer," +
                "FOREIGN KEY(id_etu) REFERENCES etudiants(id));";

        public MySQLiteHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_ETUDIANT);
            db.execSQL(DATABASE_CREATE_BILAN1);
            db.execSQL(DATABASE_CREATE_BILAN2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(MySQLiteHelper.class.getName(),
                    "Upgrading database from version " + oldVersion +
                            " to " + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BILAN1);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BILAN2);
            onCreate(db);
        }
    }

