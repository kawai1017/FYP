package com.example.chrisngok.fyp;

import android.bluetooth.*;
import android.bluetooth.le.*;
import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;


public class ble_scanner extends AppCompatActivity {

    private int REQUEST_ENABLE_BT = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ble);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }
}

