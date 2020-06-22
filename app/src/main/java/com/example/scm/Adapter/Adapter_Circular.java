package com.example.scm.Adapter;



import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.scm.Bean.Bean_Circular;
import com.example.scm.R;

import java.util.ArrayList;


/**
 * Created by jigar on 5/27/2019.
 */

public class Adapter_Circular extends BaseAdapter{
    ArrayList<Bean_Circular> arrbc;
    Context context;

    public Adapter_Circular(Context context,ArrayList<Bean_Circular> arrbc){
        this.context=context;
        this.arrbc=arrbc;
    }


    @Override
    public int getCount() {
        return arrbc.size();
    }

    @Override
    public Object getItem(int i) {
        return arrbc.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arrbc.get(i).getCNo();
    }

    public byte[] getImg(int i){return arrbc.get(i).getCircular();}

    private class ViewHolder{
        TextView tv_date;
        ImageView tv_circular;



    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
            viewHolder= new ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_circular, viewGroup, false);
            viewHolder.tv_date= (TextView)view.findViewById(R.id.cdate);
            viewHolder.tv_circular=view.findViewById(R.id.cir);
            view.setTag(viewHolder);


        }else{
            viewHolder=(ViewHolder) view.getTag();
        }

        Bitmap bmp = BitmapFactory.decodeByteArray(arrbc.get(i).getCircular(),0,arrbc.get(i).getCircular().length);
        viewHolder.tv_date.setText(arrbc.get(i).getCDate());
        viewHolder.tv_circular.setImageBitmap(bmp);




        return view;
    }

}

