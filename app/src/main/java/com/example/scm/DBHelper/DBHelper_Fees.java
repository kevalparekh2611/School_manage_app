package com.example.scm.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



import java.util.ArrayList;
import com.example.scm.Constants.Constant;
import com.example.scm.Bean.Bean_Fees;

import static com.example.scm.Constants.Constant.idofthestudent;

/**
 * Created by jigar on 5/24/2019.
 */

public class DBHelper_Fees extends SQLiteAssetHelper{



    public DBHelper_Fees(Context context) {
        super(context, Constant.DBname, null, Constant.DBversion);
    }

    public  ArrayList<Bean_Fees> getFee() {
        ArrayList<Bean_Fees> arrbf = new ArrayList<Bean_Fees>();
        SQLiteDatabase db = getReadableDatabase();
        String strQuery="select * from Fees where StudentId="+""+idofthestudent;;
        Cursor cursor = db.rawQuery(strQuery,null);
        Bean_Fees bf = new Bean_Fees();
        if (cursor.moveToFirst()) {
            do {

                bf.setSid(cursor.getInt(cursor.getColumnIndex("StudentId")));
                bf.setTotalFees(cursor.getDouble(cursor.getColumnIndex("TotalFee")));
                bf.setPaidFees(cursor.getDouble(cursor.getColumnIndex("PaidFee")));
                bf.setDueFees(bf.getTotalFees()-bf.getPaidFees());
                bf.setInstallment(cursor.getInt(cursor.getColumnIndex("Installment")));




            }
            while (cursor.moveToNext());
            arrbf.add(bf);

        }

        db.close();
        return arrbf;

    }

}

