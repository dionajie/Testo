package com.dionajie.root.testo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorStateListRes;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)

public class MainActivity extends ActionBarActivity {
    private static final String PREFS = "prefs";
    private static final String PREFS_NAME = "nama";

    SharedPreferences mSharePreferences;

    @ViewById
    EditText etName;

    @ViewById
    Button btnNext;

    @Click(R.id.btnNext)
    void Next() {

        Intent MenuAct = new Intent(this,MenuActivity_.class);

        mSharePreferences = getSharedPreferences(PREFS, MODE_PRIVATE);

        String nama = mSharePreferences.getString(PREFS_NAME, "");
        String inputname = etName.getText().toString();

        SharedPreferences.Editor e = mSharePreferences.edit();
        e.putString(PREFS_NAME, inputname);
        e.commit();

        startActivity(MenuAct);
    }

}
