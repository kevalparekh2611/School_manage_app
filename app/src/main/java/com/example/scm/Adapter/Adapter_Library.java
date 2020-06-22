package com.example.scm.Adapter;



import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.scm.R;
import com.example.scm.Bean.Bean_Library;

import java.util.ArrayList;


/**
 * Created by jigar on 5/27/2019.
 */

public class Adapter_Library extends BaseAdapter{
    ArrayList<Bean_Library> arrbl;
    Context context;

    public Adapter_Library(Context context,ArrayList<Bean_Library> arrbl){
        this.context=context;
        this.arrbl=arrbl;
    }


    @Override
    public int getCount() {
        return arrbl.size();
    }

    @Override
    public Object getItem(int i) {
        return arrbl.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arrbl.get(i).getSID();
    }

    private class ViewHolder{
        //TextView tv_sid;
        TextView tv_bname;
        TextView tv_idate;
        TextView tv_ddate;
        TextView tv_sub;
        TextView tv_submit;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
            viewHolder= new ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_library, viewGroup, false);
            //viewHolder.tv_sid= (TextView)view.findViewById(R.id.sid);
            viewHolder.tv_bname=(TextView)view.findViewById(R.id.bname);
            viewHolder.tv_idate= (TextView)view.findViewById(R.id.isdate);
            viewHolder.tv_ddate= (TextView)view.findViewById(R.id.ddate);
            viewHolder.tv_sub =(TextView)view.findViewById(R.id.sub);
            viewHolder.tv_submit=view.findViewById(R.id.textView4);

            view.setTag(viewHolder);

            viewHolder.tv_bname.setText(arrbl.get(i).getBOOK());
            viewHolder.tv_idate.setText((arrbl.get(i).getISSUE()));
            viewHolder.tv_ddate.setText(arrbl.get(i).getDUE());
            viewHolder.tv_sub.setText(arrbl.get(i).getSUBMIT());
            boolean b = (viewHolder.tv_sub.getText().toString().equals("N") || viewHolder.tv_sub.getText().toString().equals("n"));
            if (b) {
                viewHolder.tv_sub.setBackgroundColor(Color.rgb(249, 62, 87));
                viewHolder.tv_submit.setBackgroundColor(Color.rgb(249, 62, 87));

            }


        }
        else{
            viewHolder=(ViewHolder) view.getTag();

            viewHolder.tv_bname.setText(arrbl.get(i).getBOOK());
            viewHolder.tv_idate.setText((arrbl.get(i).getISSUE()));
            viewHolder.tv_ddate.setText(arrbl.get(i).getDUE());
            viewHolder.tv_sub.setText(arrbl.get(i).getSUBMIT());


        }


        //viewHolder.tv_sid.setText(""+arrbl.get(i).getSID());



        return view;
    }


}

