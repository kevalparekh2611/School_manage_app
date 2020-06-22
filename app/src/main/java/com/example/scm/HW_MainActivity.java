package com.example.scm;



import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.scm.Adapter.Adapter_HW;
import com.example.scm.Bean.Bean_HW;
import com.example.scm.DBHelper.DBHelper_HW;

import java.util.ArrayList;



public class HW_MainActivity extends AppCompatActivity {


    DBHelper_HW dbh;
    ArrayList<Bean_HW> arrbh;
    ListView lst;

    void init(){
        dbh  = new DBHelper_HW(this);
        lst = (ListView) findViewById(R.id.hw_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw__main);
        init();
        //Toast.makeText(getApplicationContext(),"Record found="+dbp.getTitle(),Toast.LENGTH_LONG).show();
        arrbh= dbh.getHW(this);
        lst.removeAllViewsInLayout();
        lst.setAdapter(new Adapter_HW(this, arrbh));



    }




}
