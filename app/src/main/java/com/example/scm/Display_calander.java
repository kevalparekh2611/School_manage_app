package com.example.scm;



import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.scm.Adapter.Adapter_Achievement;
import com.example.scm.Adapter.Adapter_Calender;
import com.example.scm.Bean.Bean_Achievement;
import com.example.scm.Bean.Bean_Calender;
import com.example.scm.DBHelper.DBHelper_Achievement;
import com.example.scm.DBHelper.DBHelper_Calender;

import java.util.ArrayList;



public class Display_calander extends AppCompatActivity {


    DBHelper_Calender dba;
    ArrayList<Bean_Calender> arrba;
    ListView lst;

    void init(){
        dba  = new DBHelper_Calender(this);
        lst = (ListView) findViewById(R.id.Calender_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_calander);
        init();
        //Toast.makeText(getApplicationContext(),"Record found="+dbp.getTitle(),Toast.LENGTH_LONG).show();
        arrba= dba.getCalender(this);
        lst.removeAllViewsInLayout();
        lst.setAdapter(new Adapter_Calender(this, arrba));



    }




}

