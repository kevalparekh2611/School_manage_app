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
import com.example.scm.Bean.Bean_Gallary;
import com.example.scm.R;

import java.util.ArrayList;


/**
 * Created by jigar on 5/27/2019.
 */

public class Adapter_gallary extends BaseAdapter{
    ArrayList<Bean_Gallary> arrbg;
    Context context;

    public Adapter_gallary(Context context, ArrayList<Bean_Gallary> arrbg){
        this.context=context;
        this.arrbg=arrbg;
    }


    @Override
    public int getCount() {
        return arrbg.size();
    }

    @Override
    public Object getItem(int position) {
        return arrbg.get(position);
    }

//    @Override
//    public Object getItem(int i) {
//        return arrbg.get(i);
//    }

    @Override
    public long getItemId(int i) {
        return arrbg.get(i).getId();
    }

    public byte[] getImg(int i){return arrbg.get(i).getImage();}

    private class ViewHolder{
        ImageView tv_img;

    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
            viewHolder= new ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_layout_gallary, viewGroup, false);
            viewHolder.tv_img= view.findViewById(R.id.img_gal);
            view.setTag(viewHolder);


        }else{
            viewHolder=(ViewHolder) view.getTag();
        }

        Bitmap bmp = BitmapFactory.decodeByteArray(arrbg.get(i).getImage(),0,arrbg.get(i).getImage().length);
        viewHolder.tv_img.setImageBitmap(bmp);

        return view;
    }

}