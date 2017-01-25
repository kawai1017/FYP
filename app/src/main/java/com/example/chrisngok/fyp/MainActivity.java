package com.example.chrisngok.fyp;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton hkmoh_button;
    ImageButton hkhm_button;
    ImageButton hksm_button;
    ImageButton hkspacemuseum_button;
    Button ble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intial_page);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ble = (Button) findViewById(R.id.button_ble) ;
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
        hkspacemuseum_button = (ImageButton) findViewById(R.id.button_hkspace);
        hkspacemuseum_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HKSpaceMuseum_MainActivity.class);
                startActivity(myIntent);
            }
        });


        ble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ble_scanner.class);
                startActivity(myIntent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:

                return true;
            case R.id.action_settings:
                Intent myIntent = new Intent(MainActivity.this, preferenceActivity.class);
                startActivity(myIntent);
                return true;
            case R.id.exit:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

