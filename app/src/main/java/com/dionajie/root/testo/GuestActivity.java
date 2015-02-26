package com.dionajie.root.testo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.dionajie.root.testo.Adapter.GuestAdapter;
import com.dionajie.root.testo.Model.Guest;
import com.dionajie.root.testo.res.ApiConnection;
import com.dionajie.root.testo.res.RestInterface;

import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by root on 25/02/15.
 */
@EActivity
public class GuestActivity extends Activity {

    private static final String PREFS = "prefs";
    private static final String PREFS_GUEST= "guest";
    SharedPreferences mSharePreferences;

    ArrayList<Guest> listGuest2 = new ArrayList<>();
    GuestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        getGuestData();
        adapter = new GuestAdapter(this, R.layout.row_guest, listGuest2);
        gridView.setAdapter(adapter);

        gridView.setClickable(true);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Guest guest = listGuest2.get(position);
                Intent MenuAct = new Intent(view.getContext(),com.dionajie.root.testo.MenuActivity_.class);
                    //MenuAct.putExtra("tombolGuest", guest.name);
                mSharePreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
                SharedPreferences.Editor e = mSharePreferences.edit();
                e.putString(PREFS_GUEST, guest.name);
                e.commit();

                int a = Integer.parseInt(guest.birthdate.substring(guest.birthdate.length() - 2, guest.birthdate.length()));

                String kembalikan = "";

                if(a%2 == 0) {
                    if(a%3 == 0) {
                        kembalikan = "iOS";
                    }
                    else {
                        kembalikan ="Blackberry";
                    }
                }
                else if (a%3 == 0) {
                    kembalikan = "Android";
                }

                Toast.makeText(getApplicationContext(), kembalikan, Toast.LENGTH_LONG).show();
                startActivity(MenuAct);

            }
        });
    }

    public void updateListData(ArrayList<Guest> listGuest){
        Guest mGuest = new Guest();
        for (int i = 0 ; i < listGuest.size() ; i++){
            //adapter.add(content);
            mGuest.setName(listGuest.get(i).name);
            mGuest.setBirthdate(listGuest.get(i).birthdate);
            listGuest2.add(mGuest);

            //listGuest2.add(new Guest(listGuest.get(i).name,listGuest.get(i).birthdate));

            //listGuest.add(listGuest.get(i).birthdate);
            //Toast.makeText(GuestActivity.this, listGuest.get(i).name, Toast.LENGTH_LONG).show();
        }
        adapter.notifyDataSetChanged();
    }

    public void getGuestData(){
        RestAdapter adapter = ApiConnection.getRestAdapter(this);
        RestInterface restInterface = adapter.create(RestInterface.class);
        restInterface.getPeople(new Callback<List<Guest>>() {

            @Override
            public void success(List<Guest> trackses, Response response) {
                if (trackses.isEmpty()) {
                    Toast.makeText(GuestActivity.this, "Data Kosong", Toast.LENGTH_LONG).show();
                }

                ArrayList<Guest> listGuest = new ArrayList<Guest>();

                for (Guest tracks : trackses) {
                    listGuest.add(tracks);
                }

                updateListData(listGuest);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(GuestActivity.this, "Ini Error", Toast.LENGTH_LONG).show();
            }
        });

    }
}
