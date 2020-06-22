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

public class profile extends AppCompatActivity {
    //Button b1,b2;
    //    LinearLayout papaLay, momLay;

    TextView papa_txt,mom_txt,add_txt,mcontact,fcontact,snm,dob,sid,sclass,tname;
    ImageView papa_img,mom_img,student_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        b1 = (Button) findViewById(R.id.button5);
//        b2 = (Button) findViewById(R.id.button6);
//        papaLay = (LinearLayout) findViewById(R.id.papa_name);
//        momLay = (LinearLayout) findViewById(R.id.mom_name);

        add_txt =  findViewById(R.id.add_txt);
        papa_img = (ImageView) findViewById(R.id.papa_img);
        papa_txt = (TextView) findViewById(R.id.fnm);
        mom_img = (ImageView) findViewById(R.id.mom_img);
        mom_txt = (TextView) findViewById(R.id.mnm);
        fcontact = findViewById(R.id.fc);
        mcontact = findViewById(R.id.mc);
        snm = findViewById(R.id.snm);
        dob = findViewById(R.id.dob);
        sid = findViewById(R.id.sid);
        sclass = findViewById(R.id.sclass);
        tname = findViewById(R.id.tname);
        student_img = findViewById(R.id.display);


              JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,
                        "http://192.168.43.168:8081/Android/profiles.php", null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

//                                Toast.makeText(profile.this, "hello", Toast.LENGTH_SHORT).show();

                                try {
                                    JSONObject jsonObject = response.getJSONObject(idofthestudent-1);
                                    sid.setText(""+idofthestudent);
                                    papa_txt.setText(jsonObject.getString("fname"));
                                    fcontact.setText(jsonObject.getString("fc"));
                                    mom_txt.setText(jsonObject.getString("mname"));
                                    mcontact.setText(jsonObject.getString("mc"));
                                    add_txt.setText(jsonObject.getString("add"));
                                    sclass.setText(jsonObject.getString("class"));
                                    dob.setText(jsonObject.getString("dob"));
                                    tname.setText(jsonObject.getString("tname"));
                                    snm.setText(jsonObject.getString("name"));
                                    byte[] byteArray = Base64.decode(jsonObject.getString("image"),Base64.DEFAULT);
                                    Bitmap bmp = BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
                                    student_img.setImageBitmap(bmp);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(profile.this, e.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(profile.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }


            });



        RequestQueue rq = Volley.newRequestQueue(profile.this);
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