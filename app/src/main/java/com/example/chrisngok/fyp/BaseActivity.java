package com.example.chrisngok.fyp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public abstract class BaseActivity extends AppCompatActivity {
    private Menu menu;


    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setContentView(int layoutResID) {
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
                alertDialog.setTitle(R.string.about_title);
                alertDialog.setMessage(getResources().getString(R.string.about_des));
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
                killApp();
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    protected void killApp() {
        //Kill myself
        finish();
        moveTaskToBack(true);
    }
}
