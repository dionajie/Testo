package com.dionajie.root.testo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.dionajie.root.testo.Model.Guest;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

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
    public static final int FRAME_ID = 1;

    ListTitleFragment listTitleFragment;

    @ViewById
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        updateScreen();
    }

    public void updateScreen(){

        listTitleFragment = new ListTitleFragment_();
        FragmentTransaction fs = getFragmentManager().beginTransaction();
        //fs.add(R.id.imageViewLayout,listTitleFragment).commit();
        getTracksData();
    }

    public void getTracksData(){
        RestAdapter adapter = ApiConnection.getRestAdapter(this);
        RestInterface restInterface = adapter.create(RestInterface.class);
        restInterface.getPeople(new Callback<List<Guest>>() {
            @Override
            public void success(List<Guest> trackses, Response response) {
                if (trackses.isEmpty()) {
                    Toast.makeText(GuestActivity.this, "haloha", Toast.LENGTH_LONG).show();
                }
                ArrayList<Guest> listTrack = new ArrayList<Guest>();
                int i = 0;
                for (Guest tracks : trackses) {
                    listTrack.add(tracks);
                    Log.i("track list ", listTrack.get(i).name);;
                    i++;
                }
                listTitleFragment.updateListData(listTrack);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(GuestActivity.this, "halohahaha", Toast.LENGTH_LONG).show();
            }
        });

    }
}
