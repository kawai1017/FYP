package com.example.chrisngok.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class HKMOH_MainActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hkmoh_main);

        Button button_about_us = (Button) findViewById(R.id.hkmoh_about_us_default);
        button_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKMOH_MainActivity.this, HKMOH_AboutUsActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
