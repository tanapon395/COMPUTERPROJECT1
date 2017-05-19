package com.example.tanapon.computerproject1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Tanapon on 29/3/2560.
 */

public class ServiceFragment extends Fragment {
    View myView;
    ArrayList<String> basicFields;
    gridAdapterService adapter;
    GridView gridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.service, container, false);

        basicFields = new ArrayList<>();
        gridView = (GridView) myView.findViewById(R.id.grid);
        basicFields.add("เปลี่ยนกระทะ");
        basicFields.add("เติมถ่าน");
        basicFields.add("เติมน้ำจิ้ม");
        basicFields.add("เติมกระดาษ");
        basicFields.add("เติมน้ำซุป");
        adapter = new gridAdapterService(getActivity(), basicFields);
        gridView.setAdapter(adapter);

        return myView;
    }


}

