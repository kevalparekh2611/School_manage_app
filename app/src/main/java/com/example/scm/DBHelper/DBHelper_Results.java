package com.example.scm.DBHelper;




import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;


import com.example.scm.Bean.Bean_Achievement;
import com.example.scm.Bean.Bean_Results;
import com.example.scm.Constants.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



import java.util.ArrayList;

import static com.example.scm.Constants.Constant.idofthestudent;

/**
 * Created by jigar on 5/24/2019.
 */

public class DBHelper_Results extends SQLiteAssetHelper{



    public DBHelper_Results(Context context) {
        super(context, Constant.DBname, null, Constant.DBversion);
    }

    public  ArrayList<Bean_Results> getResult() {
        ArrayList<Bean_Results> arrba = new ArrayList<Bean_Results>();
        SQLiteDatabase db = getReadableDatabase();
        String strQuery="select * from SubjectWiseMarks swm inner join Student s where swm.StudentId=s.StudentId and s.StudentId="+""+idofthestudent;
        Cursor cursor = db.rawQuery(strQuery,null);
       

        if (cursor.moveToFirst()) {
            do {

                int marks[]=new int[8];
                int total=0;
                Bean_Results ba=new Bean_Results();
                ba.setSid(       cursor.getInt(0)       );
                ba.setSname(     cursor.getString(   10));
                ba.setSclass(    cursor.getString(   16));
                ba.setMaths(     cursor.getString(1   ));
                ba.setAndroid(   cursor.getString(   2));
                ba.setJava(      cursor.getString(   3));
                ba.setDatabase(  cursor.getString(   4));
                ba.setCpp(       cursor.getString(   5));
                ba.setAI(        cursor.getString(   6));
                ba.setNetworking(cursor.getString(   7));
                ba.setOS(        cursor.getString(   8));
                int j=1;
                for(int i = 1 ;i<9;i++)
                {
                    if(!cursor.getString(i).equals("-")){
                        marks[j]=Integer.parseInt(cursor.getString(i)) ;
                        j++;
                    }
                    else marks[j]=0;

                }

               /* marks[1]=Integer.parseInt(cursor.getString(cursor.getColumnIndex("swm.Maths"))    ) ;
                marks[2]=Integer.parseInt(cursor.getString(cursor.getColumnIndex("swm.Android"))  ) ;
                marks[3]=Integer.parseInt(cursor.getString(cursor.getColumnIndex("swm.Java"))     ) ;
                marks[4]=Integer.parseInt(cursor.getString(cursor.getColumnIndex("swm.Database")) ) ;
                marks[5]=Integer.parseInt(cursor.getString(cursor.getColumnIndex("swm.C++"))      ) ;
                marks[6]=Integer.parseInt(cursor.getString(cursor.getColumnIndex("swm.AI"))       ) ;
                marks[7]=Integer.parseInt(cursor.getString(cursor.getColumnIndex("swm.Networking")));
                marks[8]=Integer.parseInt(cursor.getString(cursor.getColumnIndex("swm.OS"))       ) ;*/

                for(int i=0;i<marks.length;i++){
                    total+=marks[i];
                }

                ba.setTotal(""+(total/6)+"%");

                //ba.setTotal();
                arrba.add(ba);
            }
            while (cursor.moveToNext());
        }





        db.close();
        return arrba;

    }

}


/*cursor.getColumnIndex("swm.StudentId"))
        cursor.getColumnIndex("s.StudentName"))
        cursor.getColumnIndex("s.StudentClass"))
        cursor.getColumnIndex("swm.Maths"))
        cursor.getColumnIndex("swm.Android"))
        cursor.getColumnIndex("swm.Java"))
        cursor.getColumnIndex("swm.Database"))
        cursor.getColumnIndex("swm.C++"))
        cursor.getColumnIndex("swm.AI"))
        cursor.getColumnIndex("swm.Networking"))
        cursor.getColumnIndex("swm.OS"))      */