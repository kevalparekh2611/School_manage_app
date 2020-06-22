package com.example.scm;


import android.annotation.SuppressLint;

import android.app.VoiceInteractor;
import com.example.scm.Constants.Constant;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.scm.Constants.Constant.idofthestudent;

public class login extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button login1;
    int userId;
    int Password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login1 =  findViewById(R.id.btn_login);
        login1.setOnClickListener( new View.OnClickListener(){

            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {

                get_data();
//                background backgroundx = new background(getApplicationContext());
//                backgroundx.execute(type,""+ userId, ""+Password);



                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        "http://192.168.43.168:8081/Android/abc.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                                if(response.equals("login success !!!!! Welcome user")){
                                    Intent in = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(in);
                                    idofthestudent = userId;

                                }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(login.this, error.toString(), Toast.LENGTH_SHORT).show();

                            }

                        })  {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String > params =new HashMap<>();
                        params.put("user_name",""+userId);
                        params.put("password",""+Password);
                        return params;
                    }};





                RequestQueue rq = Volley.newRequestQueue(login.this);
                rq.add(stringRequest);

            }
        });


    }
    void get_data(){

        user =findViewById(R.id.login_input_user);
        pass =findViewById(R.id.login_input_password);

        userId = Integer.parseInt(user.getText().toString());
        Password = Integer.parseInt(pass.getText().toString());
    }
}
