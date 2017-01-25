package com.example.chrisngok.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HKSpaceMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hkspace_main);

        Button button_about_us = (Button) findViewById(R.id.hkspacemuseum_about_us_default);
        button_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HKSpaceMainActivity.this, HKSpace_AboutUsActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
