package com.example.tanapon.computerproject1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tanapon on 29/3/2560.
 */

public class ProductFragment extends Fragment {
    View myView;

    private DatabaseReference mRoot;
    private ArrayList<HashMap<String, String>> list;
    public static final String FIRST_COLUMN = "Column 1";
    public static final String SECOND_COLUMN = "Column 2";
    listviewAdapterProject adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ProductFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.product, container, false);

        //MsgTxt = (TextView) myView.findViewById(R.id.msgTxt);

        mRoot = FirebaseDatabase.getInstance().getReference().child("menu");
        list = new ArrayList<HashMap<String, String>>();

        ListView lview = (ListView) myView.findViewById(R.id.product_list);
        populateList();
        adapter = new listviewAdapterProject(getActivity(), list, R.layout.product_list_item);
        lview.setAdapter(adapter);
        return myView;
    }

    private void populateList() {
        mRoot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()){
                    HashMap<String, String> temp = new HashMap<String, String>();
                    temp.put(FIRST_COLUMN, data.child("name_menu").getValue().toString());
                    temp.put(SECOND_COLUMN, data.child("price").getValue().toString());
                    list.add(temp);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
