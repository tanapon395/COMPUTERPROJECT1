package com.example.tanapon.computerproject1;

/**
 * Created by Shade on 5/9/2016.
 */

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapterHome extends RecyclerView.Adapter<RecyclerAdapterHome.ViewHolder> {
    private Context mContext;

    public RecyclerAdapterHome(Context mContext) {
        this.mContext = mContext;
    }

    private String[] titles = {"กุ้งแม่น้ำเผาอร่อยสุดๆ",
            "ปูทะเลสดๆ",
            "ปลาหมึกสดๆ",
    };

    private String[] details = {"กุ้งเผา กิโลกรัมละ 200 บาท พร้อมบริการเผาฟรี",
            "ปูทะแล กิโลกรัมละ 250 บาท พร้อมบริการเผาฟรี", "ปลาหมึก กิโลกรัมล่ะ 200 บาท พร้อมบริการย่างฟรี",
    };

    private int[] images = {R.drawable.home2,
            R.drawable.home3,
            R.drawable.home1,
    };

    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;


        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemDetail = (TextView) itemView.findViewById(R.id.item_detail);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout_home, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);


    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}