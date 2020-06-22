package com.example.scm;



import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.scm.Adapter.Adapter_Achievement;
import com.example.scm.Bean.Bean_Achievement;
import com.example.scm.DBHelper.DBHelper_Achievement;

import java.util.ArrayList;

import static com.example.scm.Constants.Constant.idofthestudent;
import static com.example.scm.Constants.Constant.test;


public class AchievementMainActivity extends AppCompatActivity {


    DBHelper_Achievement dba;
    ArrayList<Bean_Achievement> arrba  ;
    ListView lst;

    void init(){
        dba  = new DBHelper_Achievement(this);
        lst = (ListView) findViewById(R.id.Achievement_list);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_main);
        init();



        arrba= dba.getAchievement(this);
        lst.removeAllViewsInLayout();
        lst.setAdapter(new Adapter_Achievement(this, arrba));
//        Toast.makeText(AchievementMainActivity.this,""+ arrba.get(0).getAchieve(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(AchievementMainActivity.this,""+ arrba.get(1).getAchieve(), Toast.LENGTH_SHORT).show();

       // Toast.makeText(this, arrba.toString(), Toast.LENGTH_SHORT).show();



    }


/*    void View getView(String date, String achieve){

        View view  ;

        RecyclerView.ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            viewHolder= new RecyclerView.ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_achievement, viewGroup, false);
            //viewHolder.tv_sid= (TextView)view.findViewById(R.id.sid);
            viewHolder.tv_adate=(TextView)view.findViewById(R.id.achdate);
            viewHolder.tv_achieve= (TextView)view.findViewById(R.id.achieve);
            view.setTag(viewHolder);




        //viewHolder.tv_sid.setText(""+arrba.get(i).getSid());
        viewHolder.tv_adate.setText(arrba.get(i).getAdate());
        viewHolder.tv_achieve.setText((arrba.get(i).getAchieve()));
        return v;
    }*/


}

