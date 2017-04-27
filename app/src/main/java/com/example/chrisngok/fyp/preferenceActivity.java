package com.example.chrisngok.fyp;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class preferenceActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        edit_preferences prefFragment = new edit_preferences();
        transaction.add(android.R.id.content, prefFragment);
        transaction.commit();
    }

    public void restartFragment() {
        edit_preferences fragment = new edit_preferences();
        getFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();

    }
}
