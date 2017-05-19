package com.example.tanapon.computerproject1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanapon on 29/3/2560.
 */

public class ProductFragment extends Fragment {
    View myView;


    private DatabaseReference mRoot;
    private RecyclerView recyclerView;
    private MyAdapter_Product adapter;
    private List<RecyclerItem_Product> listItems;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ProductFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.product, container, false);

        mRoot = FirebaseDatabase.getInstance().getReference().child("menu");
        recyclerView = (RecyclerView) myView.findViewById(R.id.recyclerView_product);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems = new ArrayList<>();

        //Generate sample data
        populateList();

        //Set adapter
        adapter = new MyAdapter_Product(listItems, getActivity());
        recyclerView.setAdapter(adapter);

        return myView;
    }

    private void populateList() {
        mRoot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listItems.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    listItems.add(new RecyclerItem_Product(data.child("name_menu").getValue().toString(), "ราคา " + data.child("price").getValue().toString()+" บาท"));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
