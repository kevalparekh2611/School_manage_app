package com.example.scm.Adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.scm.Bean.Bean_HW;
import com.example.scm.R;

import java.util.ArrayList;


/**
 * Created by jigar on 5/27/2019.
 */

public class Adapter_HW extends BaseAdapter{
    ArrayList<Bean_HW> arrbh;
    Context context;

    public Adapter_HW(Context context,ArrayList<Bean_HW> arrbh){
        this.context=context;
        this.arrbh=arrbh;
    }


    @Override
    public int getCount() {
        return arrbh.size();
    }

    @Override
    public Object getItem(int i) {
        return arrbh.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arrbh.get(i).getSid();
    }

    private class ViewHolder{
        TextView tv_sid;
        TextView tv_class;
        TextView tv_cteacher;
        TextView tv_hwdate;
        TextView tv_hw;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
            viewHolder= new ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_hw, viewGroup, false);
            viewHolder.tv_sid= (TextView)view.findViewById(R.id.sid);
            //viewHolder.tv_class=(TextView)view.findViewById(R.id.sclass);
            viewHolder.tv_cteacher= (TextView)view.findViewById(R.id.hwteacher);
            viewHolder.tv_hwdate= (TextView)view.findViewById(R.id.hwdate);
            viewHolder.tv_hw =(TextView)view.findViewById(R.id.hw);

            view.setTag(viewHolder);


        }else{
            viewHolder=(ViewHolder) view.getTag();
        }



        viewHolder.tv_cteacher.setText((arrbh.get(i).getCteacher()));
        viewHolder.tv_hwdate.setText(arrbh.get(i).getHWdate());
        viewHolder.tv_hw.setText(arrbh.get(i).getHW());


        return view;
    }

}

