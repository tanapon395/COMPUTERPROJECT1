package com.example.tanapon.computerproject1;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.R.attr.defaultValue;

public class RecyclerViewHolders_Product extends RecyclerView.ViewHolder {

    public TextView txtTitle;
    public TextView txtDescription;
    public ImageButton txtOptionDigit;
    private DatabaseReference mRoot, mRoot_Bill, mCheck, mSumNumber, mSumPrice;
    SharedPreferences sharedPref, sharedPref_bill;
    String list = "";
    int sumPrice = 0, sumNumber = 0;


    public RecyclerViewHolders_Product(View itemView, final Context mContext, final ArrayList<String> myArrList) {
        super(itemView);
        txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
        txtOptionDigit = (ImageButton) itemView.findViewById(R.id.txtOptionDigit);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(mContext);
        int defaultValue = 0;

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View alertLayout = inflater.inflate(R.layout.custom_dialog_product, null);
                final Spinner spNumber = (Spinner) alertLayout.findViewById(R.id.thai_club);

                final String[] CLUBS12 = {"หมูเเนื้อแดง", "หมูสามชั้น", "ทะเล", "รวมมิตร"};
                final String[] CLUBS35 = {"ขวดเล็ก", "ขวดใหญ่"};
                final String[] CLUBS4 = {"ถังเล็ก", "ถังใหญ่"};

                final int position = getAdapterPosition();

                if (position == 0) {
//                    for (int i = 0; i < myArrList.size(); i++) {
//                        list = list + myArrList.get(i) + ",";
//                    }
                    AlertDialog(CLUBS12, mContext, spNumber, alertLayout, "-KkMSPC97aadtyTy3F8N", 200);
                } else if (position == 1) {
                    AlertDialog(CLUBS12, mContext, spNumber, alertLayout, "-KkMSSNFs7FtSocVqGFS", 150);
                } else if (position == 2) {
                    AlertDialog(CLUBS35, mContext, spNumber, alertLayout, "-KkMTcMe8UfA9d4zCmmB", 50);
                } else if (position == 3) {
                    AlertDialog(CLUBS4, mContext, spNumber, alertLayout, "-KkMTcePY8knva3GO8BP", 10);
                } else if (position == 4) {
                    AlertDialog(CLUBS35, mContext, spNumber, alertLayout, "-KkMTctHCbZ9OVl8jqZa", 15);
                }
            }
        });

    }

    public void AlertDialog(final String[] list, final Context mContext, final Spinner spNumber, View alertLayout, final String check, final int price) {
        final ArrayList<Integer> mMultiSelected_menu35 = new ArrayList<Integer>();

        //sharedPref_bill
        sharedPref_bill = PreferenceManager.getDefaultSharedPreferences(mContext);
        String bill_get = "";
        String bill = sharedPref.getString("bill", bill_get);
        //sharedPref_table
        final long highScore = sharedPref.getInt("saved_high_score", defaultValue);

        mRoot = FirebaseDatabase.getInstance().getReference().child("orders");
        mCheck = mRoot.child("table_" + String.valueOf(highScore)).child(check).push();
        mSumNumber = mRoot.child("table_" + String.valueOf(highScore)).child(check).child("sum_menu");
        mSumPrice = mRoot.child("table_" + String.valueOf(highScore)).child(check).child("price");

        mRoot_Bill = FirebaseDatabase.getInstance().getReference().child("bill").child(bill).child("table_" + String.valueOf(highScore));

        mSumNumber.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                sumNumber = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        mSumPrice.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                sumPrice = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("เลือกวัตถุดิบ");

//        final String[] parts = list.split(",");
        builder.setMultiChoiceItems(list, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    mMultiSelected_menu35.add(which);
                } else if (mMultiSelected_menu35.contains(which)) {
                    mMultiSelected_menu35.remove(Integer.valueOf(which));
                }
            }
        });
        builder.setView(alertLayout);

        builder.setPositiveButton("ยืนยัน", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer buffer = new StringBuffer();
                for (Integer team : mMultiSelected_menu35) {
                    buffer.append(" ");
                    buffer.append(list[team]);
                }
                String sp = String.valueOf(spNumber.getSelectedItem());

                mCheck.child("list").setValue(buffer.toString());
                mCheck.child("number").setValue(sp);

                sumNumber = (sumNumber + Integer.parseInt(sp));
                mSumNumber.setValue(sumNumber);

                mRoot_Bill.child(check).setValue(sumNumber);

                sumPrice = (sumNumber * price);
                mSumPrice.setValue(sumPrice);

                Toast.makeText(mContext, "คุณเลือก " + buffer.toString() + "\nจำนวน " + sp, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mContext, "ยกเลิกการทำรายการ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();


    }

}
