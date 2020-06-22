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

public class Fees extends AppCompatActivity {


    TextView total,paid,due,install;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);

        total=findViewById(R.id.t_fees_value);
        paid=findViewById(R.id.p_fees_value);
        due=findViewById(R.id.d_fees_value);
        install=findViewById(R.id.u_fees_value);


        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.43.168:8081/Android/fees.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

//                                Toast.makeText(profile.this, "hello", Toast.LENGTH_SHORT).show();

                        try {
                            JSONObject jsonObject = response.getJSONObject(idofthestudent-1);
                            total.setText(jsonObject.getString("TotalFee"));
                            paid.setText(jsonObject.getString("PaidFee"));
                            install.setText(jsonObject.getString("Installment"));
                            due.setText(""+
                                    (Integer.parseInt(jsonObject.getString("TotalFee"))
                                     -
                                    Integer.parseInt( jsonObject.getString("PaidFee"))));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Fees.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(Fees.this, error.toString(), Toast.LENGTH_SHORT).show();

            }


        });



        RequestQueue rq = Volley.newRequestQueue(Fees.this);
        rq.add(stringRequest);



    }}
