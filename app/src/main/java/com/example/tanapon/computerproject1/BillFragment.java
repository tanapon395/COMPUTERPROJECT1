package com.example.tanapon.computerproject1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

public class BillFragment extends Fragment {
    View myview;
    SharedPreferences sharedPref;
    private DatabaseReference mRoot, mCheck, mDatabase;
    private LinearLayoutManager lLayout;
    private Bill_RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    ArrayList<String> myArrList_bill;
    long highScore;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("orders").child("table_3");
//        mDatabase.child("-KkMSPC97aadtyTy3F8N").child("sum_menu").setValue("1");
//        mDatabase.child("-KkMSSNFs7FtSocVqGFS").child("sum_menu").setValue("1");
//        mDatabase.child("-KkMTcMe8UfA9d4zCmmB").child("sum_menu").setValue("1");
//        mDatabase.child("-KkMTcePY8knva3GO8BP").child("sum_menu").setValue("1");
//        mDatabase.child("-KkMTctHCbZ9OVl8jqZa").child("sum_menu").setValue("1");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.bill, container, false);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        int defaultValue = 0;
        long highScore = sharedPref.getInt("saved_high_score", defaultValue);

        mRoot = FirebaseDatabase.getInstance().getReference().child("orders");
        mCheck = mRoot.child("table_1");
        recyclerView = (RecyclerView) myview.findViewById(R.id.recyclerView_bill);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        myArrList_bill = new ArrayList<>();

        List<Bill_ItemObject> rowListItem = getAllItemList();

        lLayout = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(lLayout);
        adapter = new Bill_RecyclerViewAdapter(getActivity(), rowListItem, myArrList_bill);

        recyclerView.setAdapter(adapter);
        return myview;
    }

    private List<Bill_ItemObject> getAllItemList() {

        final List<Bill_ItemObject> allItems = new ArrayList<Bill_ItemObject>();
        mCheck.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myArrList_bill.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    allItems.add(new Bill_ItemObject(data.child("name_menu").getValue().toString(), data.child("sum_menu").getValue().toString(), data.child("price").getValue().toString()));
                    myArrList_bill.add(data.getKey());
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
