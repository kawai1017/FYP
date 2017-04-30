package com.example.chrisngok.fyp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

public class HKMOH_AboutUsActivity extends BaseActivity {
    String startLang;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museum_about_us);
        getSupportActionBar().setTitle(R.string.about_us);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startLang = preferences.getString("lang", "");

        ImageView img = (ImageView) findViewById(R.id.thumbnail);
        img.setImageResource(R.drawable.about_image);
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(R.string.hkmoh_about_us_message);
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

