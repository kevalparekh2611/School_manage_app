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
import com.example.scm.Bean.Bean_Login;


public class DBHelper_Login extends SQLiteAssetHelper{

    int i;
    Context c;

    public DBHelper_Login(Context context) {
        super(context, Constant.DBname, null, Constant.DBversion);
        c=context;
    }

    public DBHelper_Login(Context context, String name, String storageDirectory, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, storageDirectory, factory, version);
    }

    public  int check(int id,int pass) {
        ArrayList<Bean_Login> arrblog = new ArrayList<Bean_Login>();
        SQLiteDatabase db = getReadableDatabase();
        String strQuery="select * from Login where LoginId=" + ""+id + " and LoginPassword=" + ""+pass+" ;";
        i=1;
        Cursor cursor = db.rawQuery(strQuery,null);
        if (cursor.moveToFirst()) {
            do {
                Bean_Login blog = new Bean_Login();
                blog.setId(cursor.getInt(cursor.getColumnIndex("LoginId")));
                blog.setPass(cursor.getInt(cursor.getColumnIndex("LoginPassword")));

                arrblog.add(blog);


            }
            while (cursor.moveToNext());

        }
            i=arrblog.size();
        db.close();

        return i;

    }

}
