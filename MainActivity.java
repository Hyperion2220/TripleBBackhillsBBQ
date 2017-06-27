package com.triplebbackhillsbbq.triplebbackhillsbbq;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Shows directions from the users current location to the business destination.
    //In this case, I used the business name as its shown in Google Maps to ensure the correct destination is provided.
    //I found that if I did not do this, it provided directions to a slightly different address.
    public void getDirections(View view) {
        Intent directionsIntent = new Intent(Intent.ACTION_VIEW);
        directionsIntent.setData(Uri.parse("google.navigation:q=The+Triple+B+Backhills+BBQ+on+Best, +83814"));
        //According to the documentation, if the Google Maps app is not installed or is disabled, the URL launches Google Maps in a browser and performs the requested action.
        directionsIntent.setPackage("com.google.android.apps.maps");
        //If no maps application is available, the following code will prevent the app from crashing.  In this case the following error handing inst required.  See above note.
        if (directionsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(directionsIntent);
        }
    }
    //Displays a Google Maps location of the Google Maps business location using the latest Google Maps URL standard.
    public void showBusinessLocationMap(View view) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("https://www.google.com/maps/search/?api=1&query=47.700562,-116.77881&query_place_id=ChIJrTomot7GYVMRTjlP_C9zN88&dir_action=navigate"));
        //According to the documentation, if the Google Maps app is not installed or is disabled, the URL launches Google Maps in a browser and performs the requested action.
        mapIntent.setPackage("com.google.android.apps.maps");
        //If no maps application is available, the following code will prevent the app from crashing.  In this case the following error handing inst required.  See above note.
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    //Uses the default phone app to call the business phone number.
    public void dialPhoneNumber(View view) {
        String phoneNumber = "2087553797";
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        //If no phone application is available, the following code will prevent the app from crashing.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //Prompts the user to select and app to share the business website with other users.
    public void shareWebsite(View view) {
        String pageURL = "http://www.backhillsbbq.com";
        Intent intent = new Intent(Intent.ACTION_SEND).setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, pageURL);
        //If no share application is available, the following code will prevent the app from crashing.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Share website using:"));
        }
    }

    //Opens the business website using the default website app on the device.
    public void openWebsite(View view) {
        String pageURL = "http://www.backhillsbbq.com";
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(pageURL));
        //If no share application is available, the following code will prevent the app from crashing.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}








