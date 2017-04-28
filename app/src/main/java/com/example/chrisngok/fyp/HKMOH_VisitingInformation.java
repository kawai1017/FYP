package com.example.chrisngok.fyp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class HKMOH_VisitingInformation extends BaseActivity {
    String startlang;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hkmoh_visitinginformation);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startlang = preferences.getString("lang", "");
    }

    @Override
    protected void onResume() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String currentlang = preferences.getString("lang","");
        if(!startlang.matches(currentlang)){
            recreate();
        }
        super.onResume();
    }
}
