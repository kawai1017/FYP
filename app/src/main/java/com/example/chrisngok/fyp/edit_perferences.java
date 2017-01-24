package com.example.chrisngok.fyp;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;



public class edit_perferences extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.editor_prefs);
    }
}
