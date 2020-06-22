package com.example.scm.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.scm.Bean.Bean_Achievement;
import com.example.scm.Bean.Bean_Calender;
import com.example.scm.R;

import java.util.ArrayList;


/**
 * Created by jigar on 5/27/2019.
 */

public class Adapter_Calender extends BaseAdapter{
    ArrayList<Bean_Calender> arrbcal;
    Context context;

    public Adapter_Calender(Context context,ArrayList<Bean_Calender> arrbcal){
        this.context=context;
        this.arrbcal=arrbcal;
    }


    @Override
    public int getCount() {
        return arrbcal.size();
    }

    @Override
    public Object getItem(int i) {
        return arrbcal.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    private class ViewHolder{

        TextView tv_date;
        TextView tv_desc;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
            viewHolder= new ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_calender, viewGroup, false);

            viewHolder.tv_date=(TextView)view.findViewById(R.id.caldate);
            viewHolder.tv_desc= (TextView)view.findViewById(R.id.caldesc);
            view.setTag(viewHolder);


        }else{
            viewHolder=(ViewHolder) view.getTag();
        }


        //viewHolder.tv_sid.setText(""+arrba.get(i).getSid());
        viewHolder.tv_date.setText(arrbcal.get(i).getCaldate());
        viewHolder.tv_desc.setText((arrbcal.get(i).getDescription()));
        return view;
    }

}
