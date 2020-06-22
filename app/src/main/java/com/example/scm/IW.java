package com.example.scm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.scm.Adapter.Adapter_Circular;
import com.example.scm.Bean.Bean_Circular;
import com.example.scm.DBHelper.DBHelper_Circular;

import java.util.ArrayList;

public class IW extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iw);


        ImageView x = findViewById(R.id.image);
        byte[] img =getIntent().getByteArrayExtra("img");
        Bitmap bmp = BitmapFactory.decodeByteArray(img,0,img.length);
        x.setImageBitmap(bmp);
    }
}
/*

    ImageView i = findViewById(R.id.image);
    Bitmap bmp = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("img"),0,getIntent().getByteArrayExtra("img").length);
        i.setImageBitmap(bmp);
*/
