package com.example.chrisngok.fyp;

import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;


public abstract class BaseActivity extends AppCompatActivity {
    private Menu menu;


    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void  setContentView(int layoutResID){
        super.setContentView(layoutResID);
        setUpToolBar();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                AlertDialog alertDialog = new AlertDialog.Builder(BaseActivity.this).create();
                alertDialog.setTitle("About This APP:");
                alertDialog.setMessage("This is an app developed by ShareLabTrust Team");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                return true;
            case R.id.action_settings:
                Intent myIntent = new Intent(getBaseContext(), preferenceActivity.class);
                startActivity(myIntent);
                return true;
            case R.id.exit:
                onDestroy();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /*
    protected void onDestroy(){
        super.onDestroy();
        //Kill myself
        android.os.Process.killProcess(android.os.Process.myPid());
    } */
}
