package com.example.chrisngok.fyp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import java.util.Locale;


public class edit_preferences extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.editor_prefs);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if (key.equals("lang")) {
            Preference connectionPref = findPreference(key);
            changeLanguagePref(getContext(), sharedPreferences.getString(key, ""));
        }
    }

    private void changeLanguagePref(Context context, String lang) {
        Locale locale = null;
        if (lang.matches("zh")) {
            locale = new Locale("zh");//("zh");
        } else if (lang.matches("cn")) {
            locale = new Locale("za");//("za);
        } else if (lang.matches("en")) {
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
