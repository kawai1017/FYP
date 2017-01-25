package com.example.chrisngok.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends BaseActivity {
    ImageButton hkmoh_button;
    ImageButton hkhm_button;
    ImageButton hksm_button;
    ImageButton hkspace_button;
    Button ble;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intial_page);

       ble = (Button) findViewById(R.id.button_ble);
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


        ble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ble_scanner.class);
                startActivity(myIntent);
            }
        });

    }

}


    /*public boolean onCreateOptionsMenu(Menu menu) {
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
    }*/



