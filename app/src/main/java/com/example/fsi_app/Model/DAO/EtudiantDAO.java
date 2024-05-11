package com.example.fsi_app.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import com.example.fsi_app.Model.BO.Etudiants;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
public class EtudiantDAO {
    private SQLiteDatabase database;
    private final MySQLiteHelper mySQLiteHelper;
    private Etudiants cursorToEtudiant(Cursor cursor) {
        Etudiants unEtudiants = new Etudiants();
        unEtudiants.setId(cursor.getInt(0));
        unEtudiants.setNom_etu(cursor.getString(1));
        unEtudiants.setPre_etu(cursor.getString(2));
        unEtudiants.setMail_etu(cursor.getString(3));
        unEtudiants.setTel_etu(cursor.getString(4));
        unEtudiants.setAdresse_etu(cursor.getString(5));
        unEtudiants.setVille_etu(cursor.getString(6));
        unEtudiants.setCp_etu(cursor.getString(7));
        unEtudiants.setSpe_etu(cursor.getString(8));
        unEtudiants.setInfos_etu(cursor.getString(9));
        unEtudiants.setUsername_etu(cursor.getString(10));
        unEtudiants.setNom_entreprise_etu(cursor.getString(11));
        unEtudiants.setNom_tuteur_etu(cursor.getString(12));
        unEtudiants.setNom_maitre_apprenti(cursor.getString(13));
        unEtudiants.setClasse_etu(cursor.getString(14));
        return unEtudiants;
    }
    private String cursorToMdp(Cursor cursor) {
        String Mdp = cursor.getString(0);
        return Mdp;
    }
    public String getMdp(int id){
        String Mdp = null;
        Cursor curseur = database.query(true, "etudiants", new String[]{"pass_etu"},"id = " + id, null, null, null, null, null);
        while (curseur.moveToNext()){
            Mdp = cursorToMdp(curseur);
        }
        curseur.close();
        return Mdp;
    }
    public EtudiantDAO(Context context){
        mySQLiteHelper = new MySQLiteHelper(context);
    }
    public void open() throws SQLException {
        database = mySQLiteHelper.getWritableDatabase();
    }
    public void close(){
        mySQLiteHelper.close();
    }

    public ArrayList<Etudiants> getAllEtudiant(){
        ArrayList<Etudiants> listEtu = new ArrayList<>();
        Cursor curseur = database.query(true, "etudiants", new String[]{"id", "nom_etu", "pre_etu", "mail_etu", "tel_etu", "adresse_etu", "ville_etu", "cp_etu", "spe_etu", "infos_etu", "username_etu", "nom_entreprise_etu", "nom_tuteur_etu", "nom_maitre_apprenti", "classe_etu"},
                null, null, null, null, null, null);
        while(curseur.moveToNext()){
            Etudiants unEtudiants = cursorToEtudiant(curseur);
            listEtu.add(unEtudiants);
        }
        curseur.close();

        return listEtu;
    }
    public Etudiants getByIdEtudiant(int id){
        Etudiants unEtudiant = null;
        Cursor curseur = database.query(true, "etudiants", new String[]{"id", "nom_etu", "pre_etu", "mail_etu", "tel_etu", "adresse_etu", "ville_etu", "cp_etu", "spe_etu", "infos_etu", "username_etu", "nom_entreprise_etu", "nom_tuteur_etu", "nom_maitre_apprenti", "classe_etu"},
                "id = " + id, null, null, null, null, null);
        while (curseur.moveToNext()){
            unEtudiant = cursorToEtudiant(curseur);
        }
        curseur.close();
        return unEtudiant;
    }
    public Etudiants insertEtudiant(Etudiants unEudiant, String Mdp){
        ContentValues value = new ContentValues();
        value.put("nom_etu", unEudiant.getNom_etu());
        value.put("pre_etu", unEudiant.getPre_etu());
        value.put("mail_etu", unEudiant.getMail_etu());
        value.put("tel_etu", unEudiant.getTel_etu());
        value.put("adresse_etu", unEudiant.getAdresse_etu());
        value.put("ville_etu", unEudiant.getVille_etu());
        value.put("cp_etu", unEudiant.getCp_etu());
        value.put("spe_etu", unEudiant.getSpe_etu());
        value.put("infos_etu", unEudiant.getInfos_etu());
        value.put("username_etu", unEudiant.getUsername_etu());
        value.put("pass_etu", Mdp);
        value.put("nom_entreprise_etu", unEudiant.getNom_entreprise_etu());
        value.put("nom_tuteur_etu", unEudiant.getNom_tuteur_etu());
        value.put("nom_maitre_apprenti", unEudiant.getNom_maitre_apprenti());
        value.put("classe_etu", unEudiant.getClasse_etu());
        int id = (int) database.insert("etudiants", null, value);
        unEudiant.setId(id);

        return unEudiant;
    }

    public void deleteEtudiant(Etudiants unEtudiant){
        int id = unEtudiant.getId();
        database.delete(MySQLiteHelper.TABLE_ETUDIANT, "id = "+id, null);
    }

    public void remiseAZero() {
        // Réinitialiser le compteur d'auto-incrémentation
        database.execSQL("DELETE FROM sqlite_sequence WHERE name='etudiants';");
    }
}
