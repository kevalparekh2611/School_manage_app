package com.example.scm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scm.Adapter.Adapter_Library;
import com.example.scm.Bean.Bean_Library;
import com.example.scm.DBHelper.DBHelper_Library;

import java.util.ArrayList;



public class LibraryMainActivity extends AppCompatActivity {


    DBHelper_Library dbl;
    ArrayList<Bean_Library> arrbl;
    ListView lst;




    void init(){
        dbl  = new DBHelper_Library(this);
        lst = (ListView) findViewById(R.id.Library_list);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_main);
        init();
        //Toast.makeText(getApplicationContext(),"Record found="+dbp.getTitle(),Toast.LENGTH_LONG).show();


        arrbl= dbl.getLibrary(this);
        lst.removeAllViewsInLayout();
        lst.setAdapter(new Adapter_Library(this, arrbl));






    }




}

