package com.example.scm.Adapter;



import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.scm.Bean.Bean_Remarks;
import com.example.scm.R;

import java.util.ArrayList;


/**
 * Created by jigar on 5/27/2019.
 */

public class Adapter_Remarks extends BaseAdapter{
    ArrayList<Bean_Remarks> arrbr;
    Context context;

    public Adapter_Remarks(Context context,ArrayList<Bean_Remarks> arrbr){
        this.context=context;
        this.arrbr=arrbr;
    }


    @Override
    public int getCount() {
        return arrbr.size();
    }

    @Override
    public Object getItem(int i) {
        return arrbr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arrbr.get(i).getSid();
    }

    private class ViewHolder{
        TextView tv_sid;
        TextView tv_rdate;
        TextView tv_behave;
        TextView tv_note;



    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
            viewHolder= new ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_remarks, viewGroup, false);
            //viewHolder.tv_sid= (TextView)view.findViewById(R.id.sid);
            viewHolder.tv_rdate=(TextView)view.findViewById(R.id.rdate);
            //viewHolder.tv_behave= (TextView)view.findViewById(R.id.udate);
            viewHolder.tv_note= (TextView)view.findViewById(R.id.remark);
            view.setTag(viewHolder);


        }else{
            viewHolder=(ViewHolder) view.getTag();
        }


        //viewHolder.tv_sid.setText(""+arrbr.get(i).getSid());
        viewHolder.tv_rdate.setText( arrbr.get(i).getRedate());
        //viewHolder.tv_behave.setText((arrbr.get(i).getBehave()));
        viewHolder.tv_note.setText(arrbr.get(i).getNote());



        return view;
    }

}

