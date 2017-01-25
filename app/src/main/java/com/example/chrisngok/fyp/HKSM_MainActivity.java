package com.example.chrisngok.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class HKSM_MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hksm_main);
        Button button_about_us = (Button) findViewById(R.id.hksm_about_us_default);
        button_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKSM_MainActivity.this, HKSM_AboutUsActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
