package com.example.scm.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.scm.Bean.Bean_Achievement;
import com.example.scm.Bean.Bean_News;
import com.example.scm.R;

import java.util.ArrayList;


/**
 * Created by jigar on 5/27/2019.
 */

public class Adapter_News extends BaseAdapter{
    ArrayList<Bean_News> arrbn;
    Context context;

    public Adapter_News(Context context,ArrayList<Bean_News> arrbn){
        this.context=context;
        this.arrbn=arrbn;
    }


    @Override
    public int getCount() {
        return arrbn.size();
    }

    @Override
    public Object getItem(int i) {
        return arrbn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arrbn.get(i).getNewsno();
    }

    private class ViewHolder{
        TextView tv_sid;
        TextView tv_ndate;
        TextView tv_news;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
            viewHolder= new ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_news, viewGroup, false);
            //viewHolder.tv_sid= (TextView)view.findViewById(R.id.sid);
            viewHolder.tv_ndate=(TextView)view.findViewById(R.id.ndate);
            viewHolder.tv_news= (TextView)view.findViewById(R.id.news);
            view.setTag(viewHolder);


        }else{
            viewHolder=(ViewHolder) view.getTag();
        }


        //viewHolder.tv_sid.setText(""+arrba.get(i).getSid());
        viewHolder.tv_ndate.setText(arrbn.get(i).getNewsdate());
        viewHolder.tv_news.setText((arrbn.get(i).getNews()));
        return view;
    }

}

