package com.example.chrisngok.fyp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class HKMOH_MainActivity extends BaseActivity {
    String startlang;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hkmoh_main);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startlang = preferences.getString("lang", "");

        Button button_about_us = (Button) findViewById(R.id.hkmoh_about_us_default);
        button_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKMOH_MainActivity.this, HKMOH_AboutUsActivity.class);
                startActivity(myIntent);
            }
        });
        Button button_exhibit = (Button) findViewById(R.id.hkmoh_exhibit_default);
        button_exhibit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKMOH_MainActivity.this, ble_scanner.class);
                startActivity(myIntent);
            }
        });
        Button button_visiting_information = (Button) findViewById(R.id.hkmoh_visiting_information);
        button_visiting_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKMOH_MainActivity.this, HKMOH_VisitingInformation.class);
                startActivity(myIntent);
            }
        });
    }
    @Override
    protected void onResume() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String currentlang = preferences.getString("lang","");
        if(!startlang.matches(currentlang)){
            recreate();
        }
        super.onResume();
    }



}
