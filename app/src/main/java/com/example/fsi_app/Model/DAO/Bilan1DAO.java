package com.example.fsi_app.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.fsi_app.Model.BO.Bilan1s;

import java.util.ArrayList;
import java.util.Date;

public class Bilan1DAO {
    private EtudiantDAO etuitDAO;
    private SQLiteDatabase database;
    private final MySQLiteHelper mySQLiteHelper;

    public Bilan1DAO(Context context){
        mySQLiteHelper = new MySQLiteHelper(context);
        etuitDAO = new EtudiantDAO(context);
        etuitDAO.open();
    }
    private Bilan1s cursorToBilan1s(Cursor cursor) {
        Bilan1s unBilan1 = new Bilan1s();
        unBilan1.setId(cursor.getInt(0));

        long dateBil1 = cursor.getLong(1);
        Date date_Bil1 = new Date(dateBil1);
        unBilan1.setDate_bil1(date_Bil1);

        unBilan1.setNote_ent_bil1(cursor.getInt(2));
        unBilan1.setNote_doss_bil1(cursor.getInt(3));
        unBilan1.setOral_bil1(cursor.getInt(4));
        unBilan1.setRemarques_bil1(cursor.getString(5));
        int etudiant = cursor.getInt(6);
        unBilan1.setEtuit(etuitDAO.getByIdEtudiant(etudiant));
        return unBilan1;
    }
    public void open() throws SQLException {
        database = mySQLiteHelper.getWritableDatabase();
    }
    public void close(){
        mySQLiteHelper.close();
    }

    public ArrayList<Bilan1s> getAllBilan1(){
        ArrayList<Bilan1s> listBilan1 = new ArrayList<>();
        Cursor curseur = database.query(true, "bilan1",  new String[]{"id", "date_bil1", "note_ent_bil1", "note_doss_bil1", "note_oral_bil1", "remarques_bil1", "id_etu"},
                null, null, null, null, null, null);
        while(curseur.moveToNext()){
            Bilan1s unBilan1 = cursorToBilan1s(curseur);
            listBilan1.add(unBilan1);
        }
        curseur.close();

        return listBilan1;
    }

    public Bilan1s getByIdBilan1(int id){
        Bilan1s unBilan1 = null;
        Cursor curseur = database.query(true, "Bilan1", new String[]{"id", "date_bil1", "note_ent_bil1", "note_doss_bil1", "note_oral_bil1", "remarques_bil1", "id_etu"},
                "id_etu = " + id, null, null, null, null, null);
        while (curseur.moveToNext()){
            unBilan1 = cursorToBilan1s(curseur);
        }
        curseur.close();
        return unBilan1;
    }
    public Bilan1s insertBilan1(Bilan1s unBilan1){
        ContentValues value = new ContentValues();
        value.put("date_bil1", unBilan1.getDate_bil1().getTime());
        value.put("note_ent_bil1", unBilan1.getNote_ent_bil1());
        value.put("note_doss_bil1", unBilan1.getNote_doss_bil1());
        value.put("note_oral_bil1", unBilan1.getOral_bil1());
        value.put("remarques_bil1", unBilan1.getRemarques_bil1());
        value.put("id_etu", unBilan1.getEtuit().getId());
        int id = (int) database.insert("bilan1", null, value);
        unBilan1.setId(id);

        return unBilan1;
    }

    public void deleteBilan1(Bilan1s unBilan1){
        int id = unBilan1.getId();
        database.delete(MySQLiteHelper.TABLE_ETUDIANT, "id = "+id, null);
    }
}
