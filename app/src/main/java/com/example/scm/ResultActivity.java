package com.example.scm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.scm.Constants.Constant.idofthestudent;

public class ResultActivity extends AppCompatActivity {
    //Button b1,b2;
    //    LinearLayout papaLay, momLay;

    TextView snm,sid,sclass,maths,androidi,cpp,database,os,javas,networking,ai,total;
    String arr[]=new String[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        b1 = (Button) findViewById(R.id.button5);
//        b2 = (Button) findViewById(R.id.button6);
//        papaLay = (LinearLayout) findViewById(R.id.papa_name);
//        momLay = (LinearLayout) findViewById(R.id.mom_name);


        snm = findViewById(R.id.stname);
        sid = findViewById(R.id.stid);
        sclass = findViewById(R.id.stclass);
        maths = findViewById(R.id.maths);
        ai = findViewById(R.id.ai);
        javas = findViewById(R.id.java);
        cpp = findViewById(R.id.cpp);
        os = findViewById(R.id.os);
        database = findViewById(R.id.db);
        androidi = findViewById(R.id.android);
        networking = findViewById(R.id.network);
        total = findViewById(R.id.total);




        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.43.168:8081/Android/subwise.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

//                                Toast.makeText(profile.this, "hello", Toast.LENGTH_SHORT).show();

                        try {
                            JSONObject jsonObject = response.getJSONObject(idofthestudent-1);
                            sid.setText(""+idofthestudent);
                            sclass.setText(jsonObject.getString("Class"));
                            snm.setText(jsonObject.getString("name"));
                            arr[0]=jsonObject.getString("C++");
                            arr[1]=jsonObject.getString("Maths");
                            arr[2]=jsonObject.getString("Android");
                            arr[3]=jsonObject.getString("Java");
                            arr[4]=jsonObject.getString("Database");
                            arr[5]=jsonObject.getString("AI");
                            arr[6]=jsonObject.getString("Networking");
                            arr[7]=jsonObject.getString("OS");
                            cpp.setText(jsonObject.getString("C++"));
                            maths.setText(jsonObject.getString("Maths"));
                            androidi.setText(jsonObject.getString("Android"));
                            javas.setText(jsonObject.getString("Java"));
                            database.setText(jsonObject.getString("Database"));
                            ai.setText(jsonObject.getString("AI"));
                            networking.setText(jsonObject.getString("Networking"));
                            os.setText(jsonObject.getString("OS"));
                            int sum=0,count=0;
                            for(int i=0;i<8;i++){
                                if(!arr[i].equals("-")){
                                    sum+= Integer.parseInt(arr[i]);
                                    count++;
                                }
                            }
                            total.setText(""+(int)(sum/count)+"%");



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ResultActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(ResultActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }


        });



        RequestQueue rq = Volley.newRequestQueue(ResultActivity.this);
        rq.add(stringRequest);



    }



//    public void parent(View v){
////        papaLay.setVisibility(View.VISIBLE);
////        momLay.setVisibility(View.VISIBLE);
//        papa_img.setVisibility(v.VISIBLE);
//        papa_txt.setVisibility(v.VISIBLE);
//        mom_img.setVisibility(v.VISIBLE);
//        mom_txt.setVisibility(v.VISIBLE);
//        fcontact.setVisibility(v.VISIBLE);
//        mcontact.setVisibility(v.VISIBLE);
//        add_txt.setVisibility(v.GONE);
//        b1.setBackgroundColor(Color.parseColor("#0041D5"));
//        b2.setBackgroundColor(Color.parseColor("#D6D7D7"));
//    }
//    public void add(View w){
////        papaLay.setVisibility(View.GONE);
////        momLay.setVisibility(View.GONE);
//        papa_img.setVisibility(w.GONE);
//        papa_txt.setVisibility(w.GONE);
//        mom_txt.setVisibility(w.GONE);
//        mom_img.setVisibility(w.GONE);
//        mcontact.setVisibility(w.GONE);
//        fcontact.setVisibility(w.GONE);
//        add_txt.setVisibility(w.VISIBLE);
//        b1.setBackgroundColor(Color.parseColor("#D6D7D7"));
//        b2.setBackgroundColor(Color.parseColor("#0041D5"));
//
//    }
}