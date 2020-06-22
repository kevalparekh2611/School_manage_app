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
import com.example.scm.Bean.Bean_News;
import com.example.scm.Constants.Constant;
import com.example.scm.profile;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import static com.example.scm.Constants.Constant.idofthestudent;
import static com.example.scm.Constants.Constant.test;

/**
 * Created by jigar on 5/24/2019.
 */

public class DBHelper_News {


    Context ctx;


    public DBHelper_News(Context context) {
        ctx =context;

    }
    static ArrayList<Bean_News> arrba = new ArrayList<Bean_News>();
    public  ArrayList<Bean_News> getNews(final Context ctx) {

        RequestQueue req = Volley.newRequestQueue(ctx);

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.43.168:8081/Android/news.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrba.clear();
                        try {

                            for (int i=0; i<response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Bean_News ba = new Bean_News();
                                ba.setNewsdate(jsonObject.getString("Date"));
                                ba.setNews(jsonObject.getString("Link"));

                                arrba.add(ba);


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

/*    void hma(ArrayList<Bean_News> arb){
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
                Bean_News ba = new Bean_News();
                ba.setSid(cursor.getInt(cursor.getColumnIndex("StudentId")));
                ba.setAchieve(cursor.getString(cursor.getColumnIndex("StudentNews")));
                ba.setAdate(cursor.getString(cursor.getColumnIndex("NewsDate")));
//                System.out.println(cursor.getString(cursor.getColumnIndex("Adate")));


                arrba.add(ba);


            }
            while (cursor.moveToNext());

        }

    */