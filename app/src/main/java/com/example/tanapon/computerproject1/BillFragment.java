package com.example.tanapon.computerproject1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tanapon on 29/3/2560.
 */

public class BillFragment extends Fragment {
    View myview;
    private ArrayList<HashMap<String, String>> list;
    public static final String FIRST_COLUMN = "Column 1";
    public static final String SECOND_COLUMN = "Column 2";
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.bill, container, false);
        ListView lview = (ListView)myview.findViewById(R.id.bill_list);
        populateList();
        listviewAdapterBill adapter = new listviewAdapterBill(getActivity(), list);
        lview.setAdapter(adapter);
        return myview;

    }



    private void populateList() {

        list = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> temp1 = new HashMap<String, String>();
        temp1.put(FIRST_COLUMN,"1");
        temp1.put(SECOND_COLUMN, "เนื้อย่างชุดเล็ก");
        list.add(temp1);

        HashMap<String, String> temp2 = new HashMap<String, String>();
        temp2.put(FIRST_COLUMN,"2");
        temp2.put(SECOND_COLUMN, "เนื้อย่างชุดใหญ่");
        list.add(temp2);
    }

}
