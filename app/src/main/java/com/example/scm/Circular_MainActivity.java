package com.example.scm;



import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.scm.Adapter.Adapter_Circular;
import com.example.scm.Bean.Bean_Circular;
import com.example.scm.DBHelper.DBHelper_Circular;

import java.util.ArrayList;

public class Circular_MainActivity extends AppCompatActivity {


    DBHelper_Circular dbc;
    ArrayList<Bean_Circular> arrbc;
    ListView lst;
    void init(){
        dbc  = new DBHelper_Circular(this);
        lst = (ListView) findViewById(R.id.circular_list);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular__main);
        init();
        //Toast.makeText(getApplicationContext(),"Record found="+dbp.getTitle(),Toast.LENGTH_LONG).show();
        arrbc= dbc.getCir();
        final Adapter_Circular a=new Adapter_Circular(this, arrbc);
        lst.setAdapter(a);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                byte[] img =a.getImg((int)id);
                Intent intent= new Intent(getApplicationContext(),IW.class);
                intent.putExtra("img",img);
                startActivity(intent);
            }
        });

    }


}
//
// lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//@Override
//public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        byte[] b=a.getImg((int)l);
//
//        Intent intent = new Intent(getApplicationContext(),ImageViewerActivity.class);
//        intent.putExtra("image",b);
//        startActivity(intent);
//
//        }
//        });
