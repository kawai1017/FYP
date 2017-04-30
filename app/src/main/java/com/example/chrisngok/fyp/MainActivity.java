package com.example.chrisngok.fyp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends BaseActivity {
    ImageButton hkmoh_button;
    ImageButton hkhm_button;
    ImageButton hksm_button;
    ImageButton hkspace_button;
    String startLang;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intial_page);
        getSupportActionBar().setTitle(R.string.app_name);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startLang = preferences.getString("lang", "");

        hkmoh_button = (ImageButton) findViewById(R.id.button_hkmoh);
        hkmoh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HKMOH_MainActivity.class);
                startActivity(myIntent);
            }
        });
        hkhm_button = (ImageButton) findViewById(R.id.button_hkhm);
        hkhm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HKHM_MainActivity.class);
                startActivity(myIntent);
            }
        });
        hksm_button = (ImageButton) findViewById(R.id.button_hksm);
        hksm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HKSM_MainActivity.class);
                startActivity(myIntent);
            }
        });
        hkspace_button = (ImageButton) findViewById(R.id.button_hkspace);
        hkspace_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HKSpace_MainActivity.class);
                startActivity(myIntent);
            }
        });


    }
    @Override
    protected void onResume() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String currentLang = preferences.getString("lang", "");
        if (!startLang.matches(currentLang)) {
            recreate();
        }
        super.onResume();
    }

}





