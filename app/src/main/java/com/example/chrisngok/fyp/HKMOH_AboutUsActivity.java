package com.example.chrisngok.fyp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

public class HKMOH_AboutUsActivity extends BaseActivity {
    String startlang;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        getSupportActionBar().setTitle(R.string.hkmoh);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startlang = preferences.getString("lang", "");

        ImageView img = (ImageView) findViewById(R.id.imageView3);
        img.setImageResource(R.drawable.about_image);
        TextView text = (TextView) findViewById(R.id.about_us_message_show);
        text.setText(R.string.hkmoh_about_us_message);
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

