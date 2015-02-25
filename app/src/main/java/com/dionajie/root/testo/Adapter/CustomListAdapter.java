package com.dionajie.root.testo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dionajie.root.testo.Model.Event;
import com.dionajie.root.testo.R;

import java.util.ArrayList;

/**
 * Created by root on 25/02/15.
 */
public class CustomListAdapter extends BaseAdapter {
    private ArrayList<Event> listData;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context aContext, ArrayList<Event> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_event, null);
            holder = new ViewHolder();
            holder.event= (TextView) convertView.findViewById(R.id.event);
            holder.tanggal = (TextView) convertView.findViewById(R.id.tanggal);
            holder.gambar = (ImageView) convertView.findViewById(R.id.gambar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.event.setText(listData.get(position).getEvent());
        holder.tanggal.setText(listData.get(position).getTanggal());
        holder.gambar.setImageResource(R.drawable.ic_launcher);


        return convertView;
    }

    static class ViewHolder {
        TextView event;
        TextView tanggal;
        ImageView gambar;
    }
}
