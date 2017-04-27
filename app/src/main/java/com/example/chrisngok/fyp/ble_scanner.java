package com.example.chrisngok.fyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ble_scanner extends AppCompatActivity {

    private static final Map<String, List<String>> ITEM_BY_BEACONS;

    // TODO: replace "<major>:<minor>" strings to match your own beacons.
    static {
        Map<String, List<String>> placesByBeacons = new HashMap<>();
        placesByBeacons.put("58317:30163", new ArrayList<String>() {{
            add("You are now in (Zone A)");
            add("item1");
            add("item2");
            add("item3");
        }});
        placesByBeacons.put("15083:17427", new ArrayList<String>() {{
            add("You are now in (Zone B)");
            add("item4");
            add("item5");
            add("item6");
        }});
        placesByBeacons.put("5937:37851", new ArrayList<String>() {{
            add("You are now in (Zone C)");
            add("item7");
            add("item8");
            add("item9");
        }});
        ITEM_BY_BEACONS = Collections.unmodifiableMap(placesByBeacons);
    }

    private BeaconManager beaconManager;
    private Region region;

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
        final TextView zone = (TextView) findViewById(R.id.zone);
        ListView listView = (ListView) findViewById(R.id.sampleListView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                String value = (String) adapter.getItemAtPosition(position);
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
            }
        });
        beaconManager = new BeaconManager(this);
        beaconManager.setRangingListener(new BeaconManager.RangingListener() {
            @Override
            public void onBeaconsDiscovered(Region region, List<Beacon> list) {
                if (!list.isEmpty()) {

                    Beacon nearestBeacon = list.get(0);
                    List<String> str = placesNearBeacon(nearestBeacon);
                    // TODO: update the UI here
                    zone.setText(str.get(0));
                    adapter.clear();
                    for (int i = 1; i < str.size(); i++) {
                        adapter.add(str.get(i));
                    }
                    ;
                }
            }
        });
        region = new Region("ranged region",
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

        super.onPause();
    }
}
