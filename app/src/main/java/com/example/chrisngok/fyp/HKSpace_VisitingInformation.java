package com.example.chrisngok.fyp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

public class HKSpace_VisitingInformation extends BaseActivity {
    String startLang;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museum_visit);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        startLang = preferences.getString("lang", "");

        ImageView img = (ImageView) findViewById(R.id.imageView3);
        img.setImageResource(R.drawable.frontpage_hkspacemuseum);

        TextView address_title = (TextView) findViewById(R.id.addr_title);
        address_title.setText(R.string.address);
        TextView address = (TextView) findViewById(R.id.addr);
        address.setText(R.string.hkspace_addr);

        TextView tel_title = (TextView) findViewById(R.id.tel_title);
        tel_title.setText(R.string.telephone);
        TextView tel = (TextView) findViewById(R.id.tel);
        tel.setText(R.string.hkspace_tel);

        TextView fax_title = (TextView) findViewById(R.id.fax_title);
        fax_title.setText(R.string.fax);
        TextView fax = (TextView) findViewById(R.id.fax);
        fax.setText(R.string.hkspace_fax);

        TextView email_title = (TextView) findViewById(R.id.email_title);
        email_title.setText(R.string.email);
        TextView email = (TextView) findViewById(R.id.email);
        email.setText(R.string.hkspace_email);

        TextView website_title = (TextView) findViewById(R.id.website_title);
        website_title.setText(R.string.website);
        TextView website1 = (TextView) findViewById(R.id.website1);
        website1.setText(R.string.hkspace_website1);
    }

    @Override
    protected void onResume() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String currentLang = preferences.getString("lang", "");
        if (!startLang.matches(currentLang)) {
            recreate();
        }
        super.onResume();
    }
}
