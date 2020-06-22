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
import android.widget.CalendarView;
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

public class activity_attendence extends AppCompatActivity {
    //Button b1,b2;
    //    LinearLayout papaLay, momLay;

    TextView status,tp,ta,th,tl,total;
    String arr[] = new String[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
//        b1 = (Button) findViewById(R.id.button5);
//        b2 = (Button) findViewById(R.id.button6);
//        papaLay = (LinearLayout) findViewById(R.id.papa_name);
//        momLay = (LinearLayout) findViewById(R.id.mom_name);
        status = findViewById(R.id.status);
        tp = findViewById(R.id.tp);
        ta = findViewById(R.id.ta);
        th = findViewById(R.id.th);
        tl = findViewById(R.id.tl);
        total= findViewById(R.id.totalattendence);
        final CalendarView cv = findViewById(R.id.calender);




        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.43.168:8081/Android/attend.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

//                                Toast.makeText(profile.this, "hello", Toast.LENGTH_SHORT).show();

                        try {
                            JSONObject jsonObject = response.getJSONObject(idofthestudent-1);
                            arr[0]=jsonObject.getString("24");
                            arr[1]=jsonObject.getString("25");
                            arr[2]=jsonObject.getString("26");
                            arr[3]=jsonObject.getString("27");
                            arr[4]=jsonObject.getString("28");
                            arr[5]=jsonObject.getString("29");
                            arr[6]=jsonObject.getString("30");
                            arr[7]=jsonObject.getString("1");
                            arr[8]=jsonObject.getString("2");

                            int tpc=0,tac=0,thc=0,tlc=0;
                            for(int i=0;i<9;i++){
                                if(arr[i].equals("P")){
                                    tpc++;
                                }
                                if(arr[i].equals("A")){
                                    tac++;
                                }
                                if(arr[i].equals("H")){
                                    thc++;
                                }
                                if(arr[i].equals("L")){
                                    tlc++;
                                }

                            }
                            double att = tpc+tac+thc;
                            att = Math.round((tpc/att)*100);
                            tp.setText(""+tpc);
                            ta.setText(""+tac);
                            th.setText(""+thc);
                            tl.setText(""+tlc);
                            total.setText(""+att+"%");


                            cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                                @Override
                                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                                    String Date = ""+dayOfMonth+"/"+""+(month+1)+"/"+""+year;

                                    if(Date.equals("24/6/2019")){
                                        status.setText(arr[0]);

                                    }
                                    else if(Date.equals("25/6/2019")){
                                        status.setText(arr[1]);
                                    }
                                    else if(Date.equals("26/6/2019")){
                                        status.setText(arr[2]);
                                    }
                                    else if(Date.equals("27/6/2019")){
                                        status.setText(arr[3]);
                                    }
                                    else if(Date.equals("28/6/2019")){
                                        status.setText(arr[4]);
                                    }
                                    else if(Date.equals("29/6/2019")){
                                        status.setText(arr[5]);
                                    }
                                    else if(Date.equals("30/6/2019")){
                                        status.setText(arr[6]);
                                    }
                                    else if(Date.equals("01/07/2019")){
                                        status.setText(arr[7]);
                                    }
                                    else if(Date.equals("02/07/2019")){
                                        status.setText(arr[8]);
                                    }
                                    else status.setText("Data Not Entered");

                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(activity_attendence.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(activity_attendence.this, error.toString(), Toast.LENGTH_SHORT).show();

            }


        });



        RequestQueue rq = Volley.newRequestQueue(activity_attendence.this);
        rq.add(stringRequest);



    }}


