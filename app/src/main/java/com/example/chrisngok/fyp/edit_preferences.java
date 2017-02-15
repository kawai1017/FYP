package com.example.chrisngok.fyp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;


public class edit_preferences extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.editor_prefs);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if(key.equals("lang"))
        {
            Preference connectionPref = findPreference(key);
            changeLanguagePref(getContext(), sharedPreferences.getString(key, ""));
        }
    }
    private void changeLanguagePref(Context context, String lang) {
        Locale locale = null;
        if (lang.matches("Traditional Chinese|繁|繁")) {
            locale = new Locale("zh");//("zh_rTW");
        } else if (lang.matches("Simplified Chinese|簡|简")) {
            locale = new Locale("za");//("zh_rCN");
        } else if( lang.matches("English|英|英")){
            locale = new Locale("en");//("en");
        }
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, null);
        ((preferenceActivity) getActivity()).restartFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }
}
