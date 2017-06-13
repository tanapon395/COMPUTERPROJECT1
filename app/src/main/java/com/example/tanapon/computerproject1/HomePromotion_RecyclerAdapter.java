package com.example.tanapon.computerproject1;

/**
 * Created by Shade on 5/9/2016.
 */

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePromotion_RecyclerAdapter extends RecyclerView.Adapter<HomePromotion_RecyclerAdapter.ViewHolder> {

    private String[] titles = {"กุ้งเผาลดราคา 10% จากราคาขาย พร้อมบริการย่างฟรี ตั้งแต่วันนี้ - 30/06/60","เพียง check in โต๊ะละหนึ่งท่าน ฟรี น้ำอัดลมขวดใหญ่ จำกัดโต๊ะละ 1 ขวด","สั่งเนื้อย่าง 2 ชุดใหญ่ แถมฟรี ชุดเล็ก 1 ชุด ตั้งแต่วันนี้ - 31/12/60","มากิน 4 ท่านขึ้นไป จ่ายเพียง 3 ท่าน ที่เหลือกินพรี (คุยกันเอาเอง)",
    };
    private String[] name = {"ลดราคา 10%",
            "check in Free 1",
            "ซื้อ 2 แถม 1","มา 4 จ่าย 3",
    };
    private int[] images = {R.drawable.im1,
            R.drawable.im2,
            R.drawable.im3,
            R.drawable.im4,
    };

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView cardImagePro;
        public TextView cardTitlePro;
        private TextView cardName;

        public ViewHolder(View itemView) {
            super(itemView);
            cardImagePro = (ImageView) itemView.findViewById(R.id.cardImagePro);
            cardTitlePro = (TextView) itemView.findViewById(R.id.cardTitlePro);
            cardName = (TextView) itemView.findViewById(R.id.promotion_name_all);

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
                .inflate(R.layout.home_promotion_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.cardTitlePro.setText(titles[i]);
        viewHolder.cardName.setText(name[i]);
        viewHolder.cardImagePro.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}