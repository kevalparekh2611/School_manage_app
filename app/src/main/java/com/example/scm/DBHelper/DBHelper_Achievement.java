package com.example.scm.DBHelper;


import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.scm.Bean.Bean_Achievement;
import com.example.scm.Constants.Constant;
import com.example.scm.profile;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.scm.Constants.Constant.idofthestudent;
import static com.example.scm.Constants.Constant.test;

/**
 * Created by jigar on 5/24/2019.
 */

public class DBHelper_Achievement{


String kuchbhi;

Context ctx;
    public DBHelper_Achievement(Context context) {
       ctx=context;

    }
   static ArrayList<Bean_Achievement> arrba = new ArrayList<Bean_Achievement>();
    public  ArrayList<Bean_Achievement> getAchievement(final Context ctx) {

        RequestQueue req = Volley.newRequestQueue(ctx);

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.43.168:8081/Android/achieve.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrba.clear();
                        try {

                           for (int i=0; i<response.length(); i++) {
                               if(i == (idofthestudent-1)){
                               JSONObject jsonObject = response.getJSONObject(i);
                               Bean_Achievement ba = new Bean_Achievement();
                               ba.setSid(idofthestudent);
                               ba.setAchieve(jsonObject.getString("StudentAchievement"));
                               ba.setAdate(jsonObject.getString("AchievementDate"));

                               arrba.add(ba);}

                           }

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                        //Toast.makeText(ctx, arrba.get(1).getAchieve(), Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });



        req.add(stringRequest);
//        Toast.makeText(ctx,""+ arrba.get(1).getAchieve(), Toast.LENGTH_SHORT).show();
        return arrba;

    }

/*    void hma(ArrayList<Bean_Achievement> arb){
        arrba =arb;

    }*/



}

//stringRequest.setRetryPolicy(new RetryPolicy() {
//    @Override
//    public int getCurrentTimeout() {
//        return 0;
//    }
//
//    @Override
//    public int getCurrentRetryCount() {
//        return 0;
//    }
//
//    @Override
//    public void retry(VolleyError error) throws VolleyError {
//        Toast.makeText(ctx, error.getMessage(), Toast.LENGTH_SHORT).show();
//    }
//});
//Toast.makeText(ctx, "hello", Toast.LENGTH_SHORT).show();

    /*    if (cursor.moveToFirst()) {
            do {
                Bean_Achievement ba = new Bean_Achievement();
                ba.setSid(cursor.getInt(cursor.getColumnIndex("StudentId")));
                ba.setAchieve(cursor.getString(cursor.getColumnIndex("StudentAchievement")));
                ba.setAdate(cursor.getString(cursor.getColumnIndex("AchievementDate")));
//                System.out.println(cursor.getString(cursor.getColumnIndex("Adate")));


                arrba.add(ba);


            }
            while (cursor.moveToNext());

        }

    */