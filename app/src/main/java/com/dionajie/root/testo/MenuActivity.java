package com.dionajie.root.testo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

/**
 * Created by root on 25/02/15.
 */

@EActivity(R.layout.activity_menu)

public class MenuActivity extends ActionBarActivity {

    @ViewById
    TextView tvWelcome;

    @ViewById
    Button btnEvent;


    @ViewById
    Button btnGuest;

    private static final String PREFS = "prefs";
    private static final String PREFS_NAME = "nama";
    private static final String PREFS_EVENT = "event";
    private static final String PREFS_GUEST = "guest";
    SharedPreferences mSharePreferences;



    @AfterViews
    void tampilnama(){


        mSharePreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        String nama = mSharePreferences.getString(PREFS_NAME, "");
        String eventx = mSharePreferences.getString(PREFS_EVENT, "");
        String guestx = mSharePreferences.getString(PREFS_GUEST, "");



        if(nama.length() > 0) {
            tvWelcome.setText("Nama : " + nama + ".");
        }
/*
        Intent in = getIntent();
        String tombolEvent;
        String tombolGuest;

        tombolEvent = in.getStringExtra("tombolEvent");
        tombolGuest = in.getStringExtra("tombolGuest");
*/


        if(eventx.length() > 0) {
            btnEvent.setText(eventx);
        }

        if(guestx.length() > 0) {
            btnGuest.setText(guestx);
        }




    }

    @Click(R.id.btnEvent)
    void ClickEvent() {
        Intent EventAct = new Intent(this, EventActivity.class);
        startActivity(EventAct);
    }

    @Click(R.id.btnGuest)
    void ClickGuest() {
        Intent GuestAct = new Intent(this, GuestActivity_.class);
        startActivity(GuestAct);
    }

}
