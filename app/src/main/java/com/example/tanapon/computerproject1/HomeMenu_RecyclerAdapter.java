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

public class HomeMenu_RecyclerAdapter extends RecyclerView.Adapter<HomeMenu_RecyclerAdapter.ViewHolder> {
    private Context mContext;

    public HomeMenu_RecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    private String[] titles = {"กุ้งเผา กิโลกรัมละ 200 บาท พร้อมบริการเผาฟรี", "ปูทะแล กิโลกรัมละ 250 บาท พร้อมบริการเผาฟรี", "ปลาหมึก กิโลกรัมล่ะ 200 บาท พร้อมบริการย่างฟรี"
    };
    private String[] name = {"กุ้งแม่น้ำเผาอร่อยสุดๆ",
            "ปูทะเลสดๆ",
            "ปลาหมึกสดๆ",
    };

    private int[] images = {R.drawable.home1menu,
            R.drawable.home2menu,
            R.drawable.home3menu,
    };

    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public ImageView cardImage;
        public TextView cardTitle;
        private TextView cardName;


        public ViewHolder(View itemView) {
            super(itemView);
            cardImage = (ImageView) itemView.findViewById(R.id.cardImage);
            cardTitle = (TextView) itemView.findViewById(R.id.cardTitle);
            cardName = (TextView) itemView.findViewById(R.id.menu_name_all);

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
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.home_menu_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.cardTitle.setText(titles[i]);
        viewHolder.cardName.setText(name[i]);
        viewHolder.cardImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}