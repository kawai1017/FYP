package com.example.chrisngok.fyp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class HKHM_AboutUsActivity extends BaseActivity {
    String startlang;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hkhm_about_us);
        getSupportActionBar().setTitle(R.string.hkhm);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startlang = preferences.getString("lang", "");
    }

    @Override
    protected void onResume() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String currentlang = preferences.getString("lang", "");
        if (!startlang.matches(currentlang)) {
            recreate();
        }
        super.onResume();
    }
}

