package com.example.scm.DBHelper;


import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.Toast;


import com.example.scm.Bean.Bean_Circular;
import com.example.scm.Constants.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



import java.util.ArrayList;

/**
 * Created by jigar on 5/24/2019.
 */

public class DBHelper_Circular extends SQLiteAssetHelper{



    public DBHelper_Circular(Context context) {
        super(context, Constant.DBname, null, Constant.DBversion);
    }

    public  ArrayList<Bean_Circular> getCir() {
        ArrayList<Bean_Circular> arrbc = new ArrayList<Bean_Circular>();
        SQLiteDatabase db = getReadableDatabase();
        String strQuery="select * from Circular";
        Cursor cursor = db.rawQuery(strQuery,null);
        if (cursor.moveToFirst()) {
            do {
                Bean_Circular bc = new Bean_Circular();

                bc.setCDate(cursor.getString(cursor.getColumnIndex("Date")));
                bc.setCircular(cursor.getBlob(cursor.getColumnIndex("Schedule")));

                arrbc.add(bc);

            }
            while (cursor.moveToNext());

        }

        db.close();
        return arrbc;

    }


}

