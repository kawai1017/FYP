package com.example.chrisngok.fyp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by spha0605 on 30/4/2017.
 */

public class HKHM_ExhibitActivity extends BaseActivity {
    String startLang;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museum_map);
        getSupportActionBar().setTitle(R.string.exhibit_map);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startLang = preferences.getString("lang", "");

        ImageView imageView = (ImageView) findViewById(R.id.mMap);
        imageView.setImageResource(R.drawable.hkhm_museum_map);

        Button button_startGuide = (Button) findViewById(R.id.startGuide_button);
        button_startGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKHM_ExhibitActivity.this, ble_scanner.class);
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

