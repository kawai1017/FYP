package com.example.chrisngok.fyp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.estimote.coresdk.observation.region.beacon.BeaconRegion;
import com.estimote.coresdk.recognition.packets.Beacon;
import com.estimote.coresdk.service.BeaconManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ble_scanner extends AppCompatActivity {
    private static final Map<String, List<String>> ITEM_BY_BEACONS;

    static {
        Map<String, List<String>> placesByBeacons = new HashMap<>();
        placesByBeacons.put("58317:30163", new ArrayList<String>() {{
            //add("You are now in (Zone A)");
            add("zonea");
            add("apple");
            add("kiwi");
            add("cherry");
        }});
        placesByBeacons.put("15083:17427", new ArrayList<String>() {{
            //add("You are now in (Zone B)");
            add("zoneb");
            add("orange");
            add("lemon");
            add("pear");
        }});
        placesByBeacons.put("5937:37851", new ArrayList<String>() {{
            //add("You are now in (Zone C)");
            add("zonec");
            add("mango");
            add("strawberry");
            add("banana");
        }});
        ITEM_BY_BEACONS = Collections.unmodifiableMap(placesByBeacons);
    }

    String startlang;
    private BeaconManager beaconManager;
    private BeaconRegion region;
    private MediaPlayer mp = null;

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    private List<String> placesNearBeacon(Beacon beacon) {
        String beaconKey = String.format("%d:%d", beacon.getMajor(), beacon.getMinor());
        if (ITEM_BY_BEACONS.containsKey(beaconKey)) {
            return ITEM_BY_BEACONS.get(beaconKey);
        }
        return Collections.emptyList();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ble);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle(getString(R.string.ble_title));
        final TextView zone = (TextView) findViewById(R.id.zone);
        final ImageView map = (ImageView) findViewById(R.id.map);
        ListView listView = (ListView) findViewById(R.id.sampleListView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.textview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                final String value = (String) adapter.getItemAtPosition(position);
                final Dialog dialog = new Dialog(ble_scanner.this);
                dialog.setContentView(R.layout.item_dialog);
                TextView title = (TextView) dialog.findViewById(R.id.textTitle);
                TextView des = (TextView) dialog.findViewById(R.id.des);
                ImageView image = (ImageView) dialog.findViewById(R.id.exhitbi_image);
                Button audio_zh = (Button) dialog.findViewById(R.id.zh);
                Button audio_za = (Button) dialog.findViewById(R.id.za);
                Button audio_en = (Button) dialog.findViewById(R.id.en);
                title.setText(getFruitByName(getApplicationContext(), value));
                des.setText(getDesByName(getApplicationContext(), value));
                image.setImageResource(getImageId(getApplicationContext(), value));
                dialog.show();
                audio_zh.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        try {
                            //String filename = "android.resource://" + this.getPackageName() + "/raw/test0";
                            if (mp != null) {
                                mp.reset();
                                mp = null;
                            } else {
                                mp = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(value + "_zh", "raw", getPackageName()));
                                mp.start();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                audio_za.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        try {
                            if (mp != null) {
                                mp.reset();
                                mp = null;
                            } else {
                                //String filename = "android.resource://" + this.getPackageName() + "/raw/test0";
                                mp = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(value + "_za", "raw", getPackageName()));
                                mp.start();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                audio_en.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        try {
                            if (mp != null) {
                                mp.reset();
                                mp = null;
                            } else {
                                //String filename = "android.resource://" + this.getPackageName() + "/raw/test0";
                                mp = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(value + "_en", "raw", getPackageName()));
                                mp.start();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
        beaconManager = new BeaconManager(this);
        beaconManager.setRangingListener(new BeaconManager.BeaconRangingListener() {
            @Override
            public void onBeaconsDiscovered(BeaconRegion region, List<Beacon> list) {
                if (!list.isEmpty()) {
                    Beacon nearestBeacon = list.get(0);
                    List<String> str = placesNearBeacon(nearestBeacon);
                    // TODO: update the UI here
                    zone.setText(getResources().getIdentifier(str.get(0), "string", getPackageName()));
                    map.setImageResource(getImageId(getApplicationContext(), str.get(0)));
                    adapter.clear();
                    for (int i = 1; i < str.size(); i++) {
                        adapter.add(str.get(i));
                    }

                }
            }
        });
        region = new BeaconRegion("ranged region",
                UUID.fromString("B9407F30-F5F8-466E-AFF9-25556B57FE6D"), null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
            }
        });
    }

    @Override
    protected void onPause() {
        beaconManager.stopRanging(region);
        //stop mediaplayer:
        if (mp != null && mp.isPlaying()) {
            mp.stop();
        }
        super.onPause();
    }


    public String getDesByName(Context context, String aString) {
        int resId = getResources().getIdentifier(aString + "_des", "string", context.getPackageName());
        return getString(resId);
    }

    public String getFruitByName(Context context, String aString) {
        int resId = getResources().getIdentifier(aString, "string", context.getPackageName());
        return getString(resId);
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
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
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

}
