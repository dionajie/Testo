package com.dionajie.root.testo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.dionajie.root.testo.Adapter.CustomListAdapter;
import com.dionajie.root.testo.Model.Event;

import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

/**
 * Created by root on 25/02/15.
 */


public class EventActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ArrayList image_details = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.custom_list);
        lv1.setAdapter(new CustomListAdapter(this, image_details));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object getItem = lv1.getItemAtPosition(position);
                Event mEvent = (Event) getItem;
                Toast.makeText(EventActivity.this, mEvent.getEvent(), Toast.LENGTH_LONG).show();

                Intent Back = new Intent(getBaseContext(), MenuActivity_.class);
                Back.putExtra("tombolEvent",mEvent.getEvent());
                startActivity(Back);


            }
        });

    }

    private ArrayList getListData() {
        ArrayList<Event> results = new ArrayList<Event>();
        Event mEvent = new Event();
        mEvent.setEvent("Dinamik 10");
        mEvent.setTanggal("31 Mei 2015");

        Event mEvent2 = new Event();
        mEvent2.setEvent("Pasar Seni ITB 2015");
        mEvent2.setTanggal("01 Mei 2015");

        Event mEvent3 = new Event();
        mEvent3.setEvent("Kampoeng Jazz");
        mEvent3.setTanggal("02 Februari 2015");

        Event mEvent4 = new Event();
        mEvent4.setEvent("Donor Darah");
        mEvent4.setTanggal("23 Januari 2015");

        results.add(mEvent);
        results.add(mEvent2);
        results.add(mEvent3);
        results.add(mEvent4);

        // Add some more dummy data for testing
        return results;
    }
}
