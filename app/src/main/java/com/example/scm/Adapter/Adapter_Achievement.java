package com.example.scm.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.scm.Bean.Bean_Achievement;
import com.example.scm.R;

import java.util.ArrayList;


/**
 * Created by jigar on 5/27/2019.
 */

public class Adapter_Achievement extends BaseAdapter{
    ArrayList<Bean_Achievement> arrba;
    Context context;

    public Adapter_Achievement(Context context,ArrayList<Bean_Achievement> arrba){
        this.context=context;
        this.arrba=arrba;
    }


    @Override
    public int getCount() {
        return arrba.size();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView tv_sid;
        TextView tv_adate;
        TextView tv_achieve;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
            viewHolder= new ViewHolder();
            view=layoutInflater.inflate(R.layout.activity_achievement, viewGroup, false);
            //viewHolder.tv_sid= (TextView)view.findViewById(R.id.sid);
            viewHolder.tv_adate=(TextView)view.findViewById(R.id.achdate);
            viewHolder.tv_achieve= (TextView)view.findViewById(R.id.achieve);
            view.setTag(viewHolder);


        }else{
            viewHolder=(ViewHolder) view.getTag();
        }


        //viewHolder.tv_sid.setText(""+arrba.get(i).getSid());
        viewHolder.tv_adate.setText(arrba.get(i).getAdate());
        viewHolder.tv_achieve.setText((arrba.get(i).getAchieve()));
        return view;
    }

}
