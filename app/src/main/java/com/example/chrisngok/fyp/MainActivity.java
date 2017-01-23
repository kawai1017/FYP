package com.example.chrisngok.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intial_page);


        ib = (ImageButton) findViewById(R.id.button_hkmoh);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent myIntent = new Intent(MainActivity.this, HKMOH_Page1Activity.class);
                startActivity(myIntent);
            }
        });
    }


}

