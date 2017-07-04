package com.triplebbackhillsbbq.triplebbackhillsbbq;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends AppCompatActivity {

    //Global variables for the Image Slider functionality.
    private static final Integer[] menuItems = {R.drawable.ruben, R.drawable.eggs, R.drawable.beans, R.drawable.ribs, R.drawable.mac, R.drawable.chicken};
    private ArrayList<Integer> menuItemsArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Part of the Image Slider functionality. Executes the init method.
        init();

        // Opens the food menu page by setting a listener on the "browse_menu_text_view" text view.
        TextView textView = (TextView) findViewById(R.id.browse_menu_text_view);
        // Set a click listener on that View
        textView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the menu text view is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the MenuActivity}
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                // Start the new activity
                startActivity(intent);
            }
        });
    }

    //Part of the Image Slider functionality.
    private void init() {
        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        Collections.addAll(menuItemsArray, menuItems);
        mPager.setAdapter(new CustomPagerAdapter(MainActivity.this, menuItemsArray));
        indicator.setViewPager(mPager);
    }


    // Shows directions from the users current location to the business destination.
    // In this case, I used the business name as its shown in Google Maps to ensure the correct destination is provided.
    // I found that if I did not do this, it provided directions to a slightly different address.
    public void getDirections(View view) {
        Intent directionsIntent = new Intent(Intent.ACTION_VIEW);
        directionsIntent.setData(Uri.parse("google.navigation:q=The+Triple+B+Backhills+BBQ+on+Best, +83814"));
        // According to the documentation, if the Google Maps app is not installed or is disabled, the URL launches Google Maps in a browser and performs the requested action.
        directionsIntent.setPackage("com.google.android.apps.maps");
        // If no maps application is available, the following code will prevent the app from crashing.  In this case the following error handing inst required.  See above note.
        if (directionsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(directionsIntent);
        }
    }

    // Displays a Google Maps location of the Google Maps business location using the latest Google Maps URL standard.
    public void showBusinessLocationMap(View view) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("https://www.google.com/maps/search/?api=1&query=47.700562,-116.77881&query_place_id=ChIJrTomot7GYVMRTjlP_C9zN88&dir_action=navigate"));
        // According to the documentation, if the Google Maps app is not installed or is disabled, the URL launches Google Maps in a browser and performs the requested action.
        mapIntent.setPackage("com.google.android.apps.maps");
        // If no maps application is available, the following code will prevent the app from crashing.  In this case the following error handing inst required.  See above note.
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }


    // Uses the default phone app to call the business phone number.
    public void dialPhoneNumber(View view) {
        String phoneNumber = getString(R.string.business_phone_intent);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        // If no phone application is available, the following code will prevent the app from crashing.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // Prompts the user to select and app to share the yelp website with other users.
    public void shareWebsite(View view) {
        String pageURL = getString(R.string.business_yelp_url);
        Intent intent = new Intent(Intent.ACTION_SEND).setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, pageURL);
        // If no share application is available, the following code will prevent the app from crashing.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, getString(R.string.share_website)));
        }
    }


    // Opens the business website using the default website app on the device.
    public void openWebsite(View view) {
        String pageURL = getString(R.string.backhills_url);
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(pageURL));
        // If no share application is available, the following code will prevent the app from crashing.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // Opens the business website using the default website app on the device.
    public void openFacebook(View view) {
        String pageURL = getString(R.string.facebook_url);
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(pageURL));
        // If no share application is available, the following code will prevent the app from crashing.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}








