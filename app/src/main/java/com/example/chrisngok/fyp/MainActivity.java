package com.example.chrisngok.fyp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HKMOH_Page1Activity.class);
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
    /*@Override
    public boolean onOptionsItemsSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.about:
                aboutMenuItem();
                break;
            case R.id.action_settings:
                settingsMenuItem();
                break;
            case R.id.exit:
                exitMenuItem();
                break;
        }
            return true;
    }
    private void aboutMenuItem(){
        new AlertDialog.Builder(this)
        .setTitle("About")
        .setMessage("This is about message dialog")
        .setNeutralButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int whcih){
            }
        }).show();
    }
    private void settingsMenuItem(){
        new AlertDialog.Builder(this)
                .setTitle("Setting")
                .setMessage("This is setting message dialog")
        .setNeutralButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int whcih){
            }
        }).show();
    }
    private void exitMenuItem(){
        new AlertDialog.Builder(this)
                .setTitle("exit")
                .setMessage("This is exit message dialog")
        .setNeutralButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int whcih){
            }
        }).show();
    }*/
}

