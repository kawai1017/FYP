package com.example.chrisngok.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    Button ble;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intial_page);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        ble = (Button) findViewById(R.id.button_ble) ;
        ib = (ImageButton) findViewById(R.id.button_hkmoh);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HKMOH_Page1Activity.class);
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
}

