package com.example.scm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.scm.Adapter.Adapter_Circular;
import com.example.scm.Adapter.Adapter_gallary;
import com.example.scm.Bean.Bean_Gallary;
import com.example.scm.DBHelper.DBHelper_Gallary;

import java.util.ArrayList;

public class Main_Gallary extends AppCompatActivity {


    DBHelper_Gallary dbg;
    ArrayList<Bean_Gallary> arrbg;
    GridView lst;
    void init(){
        dbg  = new DBHelper_Gallary(this);
        lst =  findViewById(R.id.gallary_list);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__gallary);

        init();

        arrbg= dbg.getGallary();
        final Adapter_gallary a=new Adapter_gallary(this, arrbg);
        lst.setAdapter(a);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                byte[] img =a.getImg((int)position);
                Intent intent= new Intent(getApplicationContext(),IW.class);
                intent.putExtra("img",img);
                startActivity(intent);
            }
        });
    }
}
