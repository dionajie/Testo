package com.dionajie.root.testo;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.dionajie.root.testo.Model.Guest;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

/**
 * Created by root on 26/02/15.
 */
@EFragment
public class ListTitleFragment extends ListFragment {

    ArrayList<String> stringList = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,stringList);
        setListAdapter(adapter);
    }

    public void updateListData(ArrayList<Guest> listTracks){
        for (int i = 0 ; i < listTracks.size() ; i++){
            //adapter.add(content);
            stringList.add(listTracks.get(i).name);
        }
        adapter.notifyDataSetChanged();
    }

}
