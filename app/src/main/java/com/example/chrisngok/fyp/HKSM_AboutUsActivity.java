package com.example.chrisngok.fyp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

public class HKSM_AboutUsActivity extends BaseActivity {
    String startLang;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        getSupportActionBar().setTitle(R.string.hksm);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startLang = preferences.getString("lang", "English");

        ImageView img = (ImageView) findViewById(R.id.imageView3);
        img.setImageResource(R.drawable.frontpage_hksm);
        TextView text = (TextView) findViewById(R.id.about_us_message_show);
        text.setText(R.string.hksm_about_us_message);

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

