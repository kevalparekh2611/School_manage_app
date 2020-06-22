package com.example.scm;



import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scm.Adapter.Adapter_News;
import com.example.scm.Adapter.Adapter_Remarks;
import com.example.scm.Bean.Bean_News;
import com.example.scm.Bean.Bean_Remarks;
import com.example.scm.DBHelper.DBHelper_News;
import com.example.scm.DBHelper.DBHelper_Remarks;

import java.util.ArrayList;



public class News_MainActivity extends AppCompatActivity {


    DBHelper_News dbn;
    ArrayList<Bean_News> arrbn;
    ListView lst;

    void init(){
        dbn  = new DBHelper_News(this);
        lst = (ListView) findViewById(R.id.news_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__main);
        init();
        //Toast.makeText(getApplicationContext(),"Record found="+dbp.getTitle(),Toast.LENGTH_LONG).show();
        arrbn= dbn.getNews(this);
        lst.removeAllViewsInLayout();
        lst.setAdapter(new Adapter_News(this, arrbn));



    }




}

