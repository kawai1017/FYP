package com.example.chrisngok.fyp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;


public class HKSpaceMainActivity extends BaseActivity {
    String startlang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museum_main);
        getSupportActionBar().setTitle(R.string.hkspace);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startlang = preferences.getString("lang", "");
        Button button_about_us = (Button) findViewById(R.id.about_us);
        button_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKSpaceMainActivity.this, HKSpace_AboutUsActivity.class);
                startActivity(myIntent);
            }
        });
        Button button_exhibit = (Button) findViewById(R.id.exhibit);
        button_exhibit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKSpaceMainActivity.this, ble_scanner.class);
                startActivity(myIntent);
            }
        });
    }

    protected void onResume() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String currentlang = preferences.getString("lang", "");
        if (!startlang.matches(currentlang)) {
            recreate();
        }
        super.onResume();
    }
}
