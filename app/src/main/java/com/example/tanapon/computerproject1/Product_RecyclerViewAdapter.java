package com.example.tanapon.computerproject1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Product_RecyclerViewAdapter extends RecyclerView.Adapter<Product_RecyclerViewHolders> {


    private List<Product_ItemObject> itemList;
    private Context context;
    private ArrayList<String> myArrList;

    public Product_RecyclerViewAdapter(Context context, List<Product_ItemObject> itemList, ArrayList<String> myArrList) {
        this.itemList = itemList;
        this.context = context;
        this.myArrList = myArrList;

    }


    @Override
    public Product_RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_recycler_item, null);
        Product_RecyclerViewHolders rcv = new Product_RecyclerViewHolders(layoutView, context, myArrList);
        return rcv;
    }

    @Override
    public void onBindViewHolder(Product_RecyclerViewHolders holder, int position) {
        holder.txtTitle.setText(itemList.get(position).getTitle());
        holder.txtDescription.setText(itemList.get(position).getDescription());
        holder.txtOptionDigit.setBackgroundResource(itemList.get(position).getOptionDigit());
//        holder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
