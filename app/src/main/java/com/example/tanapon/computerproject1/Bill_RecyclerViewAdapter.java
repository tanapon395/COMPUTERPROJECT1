package com.example.tanapon.computerproject1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Bill_RecyclerViewAdapter extends RecyclerView.Adapter<Bill_RecyclerViewHolders> {


    private List<Bill_ItemObject> itemList;
    private Context context;
    private ArrayList<String> myArrList_bill;

    public Bill_RecyclerViewAdapter(Context context, List<Bill_ItemObject> itemList, ArrayList<String> myArrList_bill) {
        this.itemList = itemList;
        this.context = context;
        this.myArrList_bill = myArrList_bill;

    }


    @Override
    public Bill_RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_bill, null);
        Bill_RecyclerViewHolders rcv = new Bill_RecyclerViewHolders(layoutView, context, myArrList_bill);
        return rcv;
    }

    @Override
    public void onBindViewHolder(Bill_RecyclerViewHolders holder, int position) {
        holder.txtTitle_Bill.setText(itemList.get(position).getTitle_Bill());
        holder.txtDescription_Bill.setText(itemList.get(position).getDescription_Bill());
        holder.txtOptionDigit_Bill.setText(itemList.get(position).getSum_menu_Bill());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
