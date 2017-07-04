package com.triplebbackhillsbbq.triplebbackhillsbbq;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_menu);


        // Create an ArrayList of menu items/objects using the custom MenuItem class.
        ArrayList<MenuItem> menuItem = new ArrayList<>();
        menuItem.add(new MenuItem(getString(R.string.menu_item_pork_burnt_title), getString(R.string.menu_item_pork_burnt_description), R.drawable.pork_burnt_end_sandwich));
        menuItem.add(new MenuItem(getString(R.string.menu_item_junk_yard_title), getString(R.string.menu_item_junk_yard_description), R.drawable.junk_yard_dog));
        menuItem.add(new MenuItem(getString(R.string.menu_item_egg_title), getString(R.string.menu_item_egg_description), R.drawable.egg));
        menuItem.add(new MenuItem(getString(R.string.menu_item_pulled_pig_title), getString(R.string.menu_item_pulled_pig_description), R.drawable.pulled_pig));
        menuItem.add(new MenuItem(getString(R.string.menu_item_hot_mess_title), getString(R.string.menu_item_hot_mess_description), R.drawable.hot_mess));
        menuItem.add(new MenuItem(getString(R.string.menu_item_ruben_title), getString(R.string.menu_item_ruben_description), R.drawable.ruben));

        // Create an {@link CustomArrayListAdaptor}, whose data source is a list of
        // {@link menuAdaptor}. The adapter knows how to create list item views for each item
        // in the list.
        CustomArrayListAdaptor menuAdaptor = new CustomArrayListAdaptor(this, menuItem);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(menuAdaptor);
    }
}