package com.example.chrisngok.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intial_page);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ib = (ImageButton) findViewById(R.id.button_hkmoh);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent myIntent = new Intent(MainActivity.this, HKMOH_Page1Activity.class);
                startActivity(myIntent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

   /* public void goButtonClicked(View v) {
        tToast("Go button clicked!");
    }*/

    /*private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }/*

    /*public void goHKMOH_Page1(View vs) {
        Intent myIntent = new Intent(this, HKMOH_Page1Activity.class);
        startActivity(myIntent);
    }*/
}

