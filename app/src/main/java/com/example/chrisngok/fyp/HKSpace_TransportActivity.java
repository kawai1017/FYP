package com.example.chrisngok.fyp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class HKSpace_TransportActivity extends BaseActivity {
    String startLang;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museum_transport);
        getSupportActionBar().setTitle(R.string.transport_title);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startLang = preferences.getString("lang", "");

        ImageView imageView = (ImageView) findViewById(R.id.transMap);
        if (startLang.equals("en") ) {
            imageView.setImageResource(R.drawable.hkspace_map_eng);
        } else if (startLang.equals("zh") || startLang.equals("cn")) {
            imageView.setImageResource(R.drawable.hkspace_map_chi);
        }


        Button button_location = (Button) findViewById(R.id.location);
        button_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/?q=Hong Kong Space Museum";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    try {
                        Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        startActivity(unrestrictedIntent);
                    } catch (ActivityNotFoundException innerEx) {
                        Toast.makeText(getApplicationContext(), "Please install a maps application", Toast.LENGTH_LONG).show();
                    }
                }
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

