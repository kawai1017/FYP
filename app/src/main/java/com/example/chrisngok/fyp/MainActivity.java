package com.example.chrisngok.fyp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.util.Log;
import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends BaseActivity {
    ImageButton hkmoh_button;
    ImageButton hkhm_button;
    ImageButton hksm_button;
    ImageButton hkspace_button;
    String startlang;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intial_page);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startlang = preferences.getString("lang", "en");


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
                Intent myIntent = new Intent(MainActivity.this, HKSpaceMainActivity.class);
                startActivity(myIntent);
            }
        });



        }

}





