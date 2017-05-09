package com.example.tanapon.computerproject1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tanapon on 16/4/2560.
 */

public class listviewAdapterProject extends BaseAdapter
{

    public static final String FIRST_COLUMN = "Column 1";
    public static final String SECOND_COLUMN = "Column 2";

    public ArrayList<HashMap<String,String>> list;
    Activity activity;
    private int layoutId;

    public listviewAdapterProject(Activity activity, ArrayList<HashMap<String,String>> list, int layoutId) {
        super();
        this.activity = activity;
        this.list = list;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //ViewHolder holder;
        LayoutInflater inflater =  activity.getLayoutInflater();
        view = inflater.inflate(layoutId, parent, false);

        TextView nameMenu = (TextView) view.findViewById(R.id.name_menu);
        TextView priceText = (TextView) view.findViewById(R.id.price);
        HashMap<String, String> map = list.get(position);
        nameMenu.setText(map.get(FIRST_COLUMN));
        priceText.setText(map.get(SECOND_COLUMN));

        return view;
    }

}