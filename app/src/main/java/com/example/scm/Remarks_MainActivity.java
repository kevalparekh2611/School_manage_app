package com.example.scm;



import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scm.Adapter.Adapter_Remarks;
import com.example.scm.Bean.Bean_Remarks;
import com.example.scm.DBHelper.DBHelper_Remarks;

import java.util.ArrayList;



public class Remarks_MainActivity extends AppCompatActivity {


    DBHelper_Remarks dbr;
    ArrayList<Bean_Remarks> arrbr;
    ListView lst;

    void init(){
        dbr  = new DBHelper_Remarks(this);
        lst = (ListView) findViewById(R.id.Remarks_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remarks__main);
        init();
        //Toast.makeText(getApplicationContext(),"Record found="+dbp.getTitle(),Toast.LENGTH_LONG).show();
        arrbr= dbr.getRemarks(this);
        lst.removeAllViewsInLayout();
        lst.setAdapter(new Adapter_Remarks(this, arrbr));



    }




}

