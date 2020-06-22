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
import com.example.scm.Bean.Bean_Library;
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

public class DBHelper_Library {


    Context ctx;


    public DBHelper_Library(Context context) {
        ctx =context;

    }
    static ArrayList<Bean_Library> arrba = new ArrayList<Bean_Library>();
    public  ArrayList<Bean_Library> getLibrary(final Context ctx) {

        RequestQueue req = Volley.newRequestQueue(ctx);

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.43.168:8081/Android/Library.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrba.clear();
                        try {

                            for (int i=0; i<response.length(); i++) {

                                if (i == idofthestudent-1) {
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    Bean_Library ba = new Bean_Library();
                                    ba.setBOOK(jsonObject.getString("BookName"));
                                    ba.setISSUE(jsonObject.getString("IssueDate"));
                                    ba.setDUE(jsonObject.getString("DueDate"));
                                    ba.setSUBMIT(jsonObject.getString("Submit"));

                                    arrba.add(ba);
                                }

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

/*    void hma(ArrayList<Bean_Library> arb){
        arrba =arb;

    }*/



}
