package com.example.scm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        stubList =  findViewById(R.id.stub_list);
        stubGrid =  findViewById(R.id.stub_grid);

        //Inflate ViewStub before get view

        stubList.inflate();
        stubGrid.inflate();

        listView = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);

        //get list of product
        getProductList();

        //Get current view mode in share reference
        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview
        //Register item lick
        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);

        switchView();
    }

    private void switchView() {

        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            //Display listview
            stubList.setVisibility(View.VISIBLE);
            //Hide gridview
            stubGrid.setVisibility(View.GONE);
        } else {
            //Hide listview
            stubList.setVisibility(View.GONE);
            //Display gridview
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    private void setAdapters() {
        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
            listView.setAdapter(listViewAdapter);
        } else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    public List<Product> getProductList() {
        //pseudo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.ic_person_black_24dp, "Profile"));
        productList.add(new Product(R.drawable.ic_assignment_black_24dp, "Attendance"));
        productList.add(new Product(R.drawable.ic_edit_black_24dp, "HomeWork"));
        productList.add(new Product(R.drawable.ic_insert_drive_file_black_24dp, "Circulars"));
        productList.add(new Product(R.drawable.ic_event_note_black_24dp, "Remarks"));
        productList.add(new Product(R.drawable.ic_insert_invitation_black_24dp, "Calender"));
        productList.add(new Product(R.drawable.ic_attach_money_black_24dp, "Fees"));
        productList.add(new Product(R.drawable.ic_library_books_black_24dp, "Library"));
        productList.add(new Product(R.drawable.ic_trending_up_black_24dp, "Results"));
        productList.add(new Product(R.drawable.ic_notifications_active_black_24dp, "News"));
        productList.add(new Product(R.drawable.ic_format_list_numbered_black_24dp, "Achieve"));
        productList.add(new Product(R.drawable.ic_photo_library_black_24dp, "Gallery"));

        return productList;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {

        String selector;
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selector= productList.get(position).getTitle();

           if(selector.equals("Profile")){

               Intent i= new Intent(MainActivity.this,profile.class);
               startActivity(i);
           }
           else if(selector.equals("Library")){

               Intent i= new Intent(MainActivity.this,LibraryMainActivity.class);
               startActivity(i);
           }

           else if(selector.equals("Fees")){

               Intent i= new Intent(MainActivity.this,Fees.class);
               startActivity(i);
           }

           else if(selector.equals("Achieve")){

               Intent i= new Intent(MainActivity.this,AchievementMainActivity.class);
               startActivity(i);
           }

           else if(selector.equals("HomeWork")){

               Intent i= new Intent(MainActivity.this,HW_MainActivity.class);
               startActivity(i);
           }

           else if(selector.equals("Remarks")){

               Intent i= new Intent(MainActivity.this,Remarks_MainActivity.class);
               startActivity(i);
           }

           else if(selector.equals("News")){

               Intent i= new Intent(MainActivity.this,News_MainActivity.class);
               startActivity(i);
           }

           else if(selector.equals("Results")){

               Intent i= new Intent(MainActivity.this,ResultActivity.class);
               startActivity(i);
           }

           else if(selector.equals("Circulars")){

               Intent i= new Intent(MainActivity.this,Circular_MainActivity.class);
               startActivity(i);
           }

           else if(selector.equals("Gallery")){

               Intent i= new Intent(MainActivity.this,Main_Gallary.class);
               startActivity(i);
           }

           else if(selector.equals("Attendance")){

               Intent i= new Intent(MainActivity.this,activity_attendence.class);
               startActivity(i);
           }
           else if(selector.equals("Calender")){

               Intent i= new Intent(MainActivity.this,Display_calander.class);
               startActivity(i);
           }





        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_1:
                if(VIEW_MODE_LISTVIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                } else {
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }
                //Switch view
                switchView();
                //Save view mode in share reference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();

                break;
        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_refresh) {

        } else if (id == R.id.nav_logout) {
                super.onBackPressed();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
