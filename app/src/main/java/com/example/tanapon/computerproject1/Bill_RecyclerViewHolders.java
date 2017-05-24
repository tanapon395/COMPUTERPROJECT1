package com.example.tanapon.computerproject1;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Bill_RecyclerViewHolders extends RecyclerView.ViewHolder {

    public TextView txtTitle_Bill;
    public TextView txtDescription_Bill;
    public TextView txtOptionDigit_Bill;


    public Bill_RecyclerViewHolders(View itemView, final Context mContext, final ArrayList<String> myArrList_bill) {
        super(itemView);
        txtTitle_Bill = (TextView) itemView.findViewById(R.id.txtTitle_Bill);
        txtDescription_Bill = (TextView) itemView.findViewById(R.id.txtOptionDigit_Bill);
        txtOptionDigit_Bill = (TextView) itemView.findViewById(R.id.txtDescription_Bill);

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

    }


}
