package com.example.chrisngok.fyp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;


public class HKSpace_MainActivity extends BaseActivity {
    String startLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museum_main);
        getSupportActionBar().setTitle(R.string.hkspace);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startLang = preferences.getString("lang", "");
        Button button_about_us = (Button) findViewById(R.id.about_us);
        button_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKSpace_MainActivity.this, HKSpace_AboutUsActivity.class);
                startActivity(myIntent);
            }
        });
        Button button_exhibit = (Button) findViewById(R.id.exhibit);
        button_exhibit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKSpace_MainActivity.this, HKSpace_ExhibitActivity.class);
                startActivity(myIntent);
            }
        });
        Button button_visiting_information = (Button) findViewById(R.id.visit);
        button_visiting_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKSpace_MainActivity.this, HKSpace_VisitingInformation.class);
                startActivity(myIntent);
            }
        });
        Button button_transport = (Button) findViewById(R.id.transport);
        button_transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKSpace_MainActivity.this, HKSpace_TransportActivity.class);
                startActivity(myIntent);
            }
        });
    }

    protected void onResume() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String currentLang = preferences.getString("lang", "");
        if (!startLang.matches(currentLang)) {
            recreate();
        }
        super.onResume();
    }
}
