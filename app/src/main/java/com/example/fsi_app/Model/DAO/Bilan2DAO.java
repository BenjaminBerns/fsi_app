package com.example.fsi_app.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.fsi_app.Model.BO.Bilan2s;

import java.util.ArrayList;
import java.util.Date;

public class Bilan2DAO {
    private EtudiantDAO etuitDAO;
    private SQLiteDatabase database;
    private final MySQLiteHelper mySQLiteHelper;
    public Bilan2DAO(Context context){
        mySQLiteHelper = new MySQLiteHelper(context);
        etuitDAO = new EtudiantDAO(context);
        etuitDAO.open();
    }
    private Bilan2s cursorToBilan2s(Cursor cursor) {
        Bilan2s unBilan2 = new Bilan2s();
        unBilan2.setId(cursor.getInt(0));
        long dateBil2 = cursor.getLong(1);
        Date date_Bil2 = new Date(dateBil2);
        unBilan2.setDate_bil2(date_Bil2);
        unBilan2.setNote_ent_bil2(cursor.getString(2));
        unBilan2.setNote_doss_bil2(cursor.getString(3));
        unBilan2.setOral_bil2(cursor.getString(4));
        unBilan2.setRemarques_bil2(cursor.getString(5));
        int etudiant = cursor.getInt(6);
        unBilan2.setEtuit(etuitDAO.getByIdEtudiant(etudiant));
        return unBilan2;
    }

    public void open() throws SQLException {
        database = mySQLiteHelper.getWritableDatabase();
    }
    public void close(){
        mySQLiteHelper.close();
    }

    public ArrayList<Bilan2s> getAllBilan2(){
        ArrayList<Bilan2s> listBilan2 = new ArrayList<>();
        Cursor curseur = database.query(true, "bilan2",  new String[]{"id", "date_bil2", "note_ent_bil2", "note_doss_bil2", "oral_bil2", "remarques_bil2", "id_etu"},
                null, null, null, null, null, null);
        while(curseur.moveToNext()){
            Bilan2s unBilan2 = cursorToBilan2s(curseur);
            listBilan2.add(unBilan2);
        }
        curseur.close();

        return listBilan2;
    }

    public Bilan2s getByIdBilan2(int id){
        Bilan2s unBilan2 = null;
        Cursor curseur = database.query(true, "Bilan2", new String[]{"id", "date_bil2", "note_ent_bil2", "note_doss_bil2", "oral_bil2", "remarques_bil2", "id_etu"},
                "id_etu = " + id, null, null, null, null, null);
        while (curseur.moveToNext()){
            unBilan2 = cursorToBilan2s(curseur);
        }
        curseur.close();
        return unBilan2;
    }
    public Bilan2s insertBilan2(Bilan2s unBilan2){
        ContentValues value = new ContentValues();
        value.put("date_bil2", unBilan2.getDate_bil2().getTime());
        value.put("note_ent_bil2", unBilan2.getNote_ent_bil2());
        value.put("note_doss_bil2", unBilan2.getNote_doss_bil2());
        value.put("note_oral_bil2", unBilan2.getOral_bil2());
        value.put("remarques_bil2", unBilan2.getRemarques_bil2());
        value.put("id_etu", unBilan2.getEtuit().getId());
        int id = (int) database.insert("bilan2", null, value);
        unBilan2.setId(id);

        return unBilan2;
    }

    public void deleteBilan2(Bilan2s unBilan2){
        int id = unBilan2.getId();
        database.delete(MySQLiteHelper.TABLE_ETUDIANT, "id = "+id, null);
    }

}
