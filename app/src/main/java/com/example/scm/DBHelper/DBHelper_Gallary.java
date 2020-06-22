package com.example.scm.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.scm.Bean.Bean_Gallary;
import com.example.scm.Constants.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

import static com.example.scm.Constants.Constant.idofthestudent;

public class DBHelper_Gallary extends SQLiteAssetHelper {


    public DBHelper_Gallary(Context context) {
        super(context, Constant.DBname, null, Constant.DBversion);
    }

    public ArrayList<Bean_Gallary> getGallary() {
        ArrayList<Bean_Gallary> arrbg = new ArrayList<Bean_Gallary>();
        SQLiteDatabase db = getReadableDatabase();
        String strQuery = "select * from Gallary where Id="+""+idofthestudent;
        Cursor cursor = db.rawQuery(strQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Bean_Gallary bg = new Bean_Gallary();

                bg.setId(cursor.getInt(cursor.getColumnIndex("Id")));
                bg.setImage(cursor.getBlob(cursor.getColumnIndex("Images")));

                arrbg.add(bg);

            }
            while (cursor.moveToNext());

        }

        db.close();
        return arrbg;
    }
}
