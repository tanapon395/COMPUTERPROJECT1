package com.example.tanapon.computerproject1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
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

import static com.example.tanapon.computerproject1.listviewAdapterBill.FOURTH_COLUMN;
import static com.example.tanapon.computerproject1.listviewAdapterBill.THIRD_COLUMN;

/**
 * Created by Tanapon on 29/3/2560.
 */

public class BillFragment extends Fragment {
    View myview;
    private ArrayList<HashMap<String, String>> list;
    public static final String FIRST_COLUMN = "Column 1";
    public static final String SECOND_COLUMN = "Column 2";
    private DatabaseReference mDatabase;
    ArrayList<String> sumNumber;
    private String backSum = "";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Check", "check1");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.bill, container, false);
        ListView lview = (ListView) myview.findViewById(R.id.bill_list);
        sumNumber = new ArrayList<>();
        Log.e("Check", "check2");
        populateList();
        listviewAdapterBill adapter = new listviewAdapterBill(getActivity(), list);
        lview.setAdapter(adapter);

//        mDatabase = FirebaseDatabase.getInstance().getReference().child("orders").child("table_1");
//        mDatabase.child("-KkMSPC97aadtyTy3F8N").setValue("");
//        mDatabase.child("-KkMSSNFs7FtSocVqGFS").setValue("");
//        mDatabase.child("-KkMTcMe8UfA9d4zCmmB").setValue("");
//        mDatabase.child("-KkMTcePY8knva3GO8BP").setValue("");
//        mDatabase.child("-KkMTctHCbZ9OVl8jqZa").setValue("");
//
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot data : dataSnapshot.getChildren()) {
//                String a = data.getKey();
//                    mDatabase.child(a).setValue("1");
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        return myview;
    }

    private void populateList() {

        list = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> temp1 = new HashMap<String, String>();
        temp1.put(FIRST_COLUMN, "ลำดับ");
        temp1.put(SECOND_COLUMN, "รายการ");
        temp1.put(THIRD_COLUMN, "จำนวน");
        temp1.put(FOURTH_COLUMN, "ราคา");
        list.add(temp1);

        HashMap<String, String> temp2 = new HashMap<String, String>();
        temp2.put(FIRST_COLUMN, "1");
        temp2.put(SECOND_COLUMN, "เนื้อย่างชุดใหญ่");
        temp2.put(THIRD_COLUMN, "3");
        temp2.put(FOURTH_COLUMN, "600");
        list.add(temp2);
    }

    public void SumNumber(String s) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        int defaultValue = 0;
        long highScore = sharedPref.getInt("saved_high_score", defaultValue);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("orders").child("table_" + String.valueOf(highScore)).child(s);
        list = new ArrayList<HashMap<String, String>>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    sumNumber.add(data.child("number").getValue().toString());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
