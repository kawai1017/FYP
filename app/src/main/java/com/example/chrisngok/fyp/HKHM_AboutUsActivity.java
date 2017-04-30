package com.example.chrisngok.fyp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;


public class HKHM_AboutUsActivity extends BaseActivity {
    String startLang;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museum_about_us);
        getSupportActionBar().setTitle(R.string.hkhm);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startLang = preferences.getString("lang", "");

        ImageView img = (ImageView) findViewById(R.id.thumbnail);
        img.setImageResource(R.drawable.frontpage_hkhm);
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(R.string.hkhm_about_us_message);


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

