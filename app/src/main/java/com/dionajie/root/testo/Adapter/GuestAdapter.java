package com.dionajie.root.testo.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dionajie.root.testo.Model.Guest;
import com.dionajie.root.testo.R;

import java.util.ArrayList;

/**
 * Created by root on 26/02/15.
 */
public class GuestAdapter extends ArrayAdapter<Guest> {
    private ArrayList<Guest> listGuest;

    public GuestAdapter(Context aContext, int resource, ArrayList listGuest) {
        super(aContext, resource, listGuest);
        this.listGuest = listGuest;
    }

    public View getView(int pos, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null) {
            LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.row_guest,null);
        }

        Guest g = listGuest.get(pos);


        if(g != null) {
            ImageView gambar = (ImageView) v.findViewById(R.id.gambar2);
            TextView name = (TextView) v.findViewById(R.id.tvname);
            TextView birthdate = (TextView) v.findViewById(R.id.tvbirthdate);

            gambar.setImageResource(R.drawable.ic_launcher);
            name.setText(g.name);
            birthdate.setText("");

        }


        return v;
    }

}
