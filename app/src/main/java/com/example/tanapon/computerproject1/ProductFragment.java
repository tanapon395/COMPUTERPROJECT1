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
    private LinearLayoutManager lLayout;
    private RecyclerViewAdapter_Product adapter;
    private RecyclerView recyclerView;
    ArrayList<String> myArrList;


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

        myArrList = new ArrayList<>();

        List<ItemObject_Product> rowListItem = getAllItemList();

        lLayout = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(lLayout);
        adapter = new RecyclerViewAdapter_Product(getActivity(), rowListItem, myArrList);

        recyclerView.setAdapter(adapter);
        return myView;
    }

    private List<ItemObject_Product> getAllItemList() {

        final List<ItemObject_Product> allItems = new ArrayList<>();
        mRoot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myArrList.clear();
                int[] covers = new int[]{
                        R.mipmap.ic_barbecue,
                        R.mipmap.ic_steak,
                        R.mipmap.ic_sparkling,
                        R.mipmap.ic_ice,
                        R.mipmap.ic_water
                };
                int count = 0;
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    ItemObject_Product a = new ItemObject_Product(data.child("name_menu").getValue().toString(), "ราคา " + data.child("price").getValue().toString() + " บาท", covers[count]);
                    allItems.add(a);
//                    allItems.add(new ItemObject_Product(data.child("name_menu").getValue().toString(), "ราคา " + data.child("price").getValue().toString() + " บาท"), R.drawable.ic_menu_camera);
                    myArrList.add(data.getKey());
                    count++;
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return allItems;
    }


}
