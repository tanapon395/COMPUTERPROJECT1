package com.example.tanapon.computerproject1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgocTri on 11/5/2016.
 */

public class MyAdapter_Product extends RecyclerView.Adapter<MyAdapter_Product.ViewHolder> {

    private List<RecyclerItem_Product> listItems;
    private Context mContext;

    public MyAdapter_Product(List<RecyclerItem_Product> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayout = inflater.inflate(R.layout.custom_dialog_product, null);
        final Spinner spNumber = (Spinner) alertLayout.findViewById(R.id.thai_club);


        final String[] CLUBS12 = {"หมูเเนื้อแดง", "หมูสามชั้น", "ทะเล", "รวมมิตร"};
        final String[] CLUBS35 = {"ขวดเล็ก", "ขวดใหญ่"};
        final String[] CLUBS4 = {"ถังเล็ก", "ถังใหญ่"};


        final RecyclerItem_Product itemList = listItems.get(position);
        holder.txtTitle.setText(itemList.getTitle());
        holder.txtDescription.setText(itemList.getDescription());
        holder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0) {
                    final ArrayList<Integer> mMultiSelected_menu12 = new ArrayList<Integer>();
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("เลือกวัตถุดิบ");

                    builder.setMultiChoiceItems(CLUBS12, null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked) {
                                mMultiSelected_menu12.add(which);
                            } else if (mMultiSelected_menu12.contains(which)) {
                                mMultiSelected_menu12.remove(Integer.valueOf(which));
                            }
                        }
                    });
                    builder.setView(alertLayout);


                    builder.setPositiveButton("ยืนยัน", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            StringBuffer buffer = new StringBuffer();
                            for (Integer team : mMultiSelected_menu12) {
                                buffer.append(" ");
                                buffer.append(CLUBS12[team]);
                            }
                            String sp = String.valueOf(spNumber.getSelectedItem());
                            Toast.makeText(mContext, "คุณเลือก " + buffer.toString() + "\nจำนวน " + sp + " ชุดใหญ่", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            Log.e("Check", "GotoScan");


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

                } else if (position == 1) {
                    final ArrayList<Integer> mMultiSelected_menu12 = new ArrayList<Integer>();
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("เลือกวัตถุดิบ");

                    builder.setMultiChoiceItems(CLUBS12, null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked) {
                                mMultiSelected_menu12.add(which);
                            } else if (mMultiSelected_menu12.contains(which)) {
                                mMultiSelected_menu12.remove(Integer.valueOf(which));
                            }
                        }
                    });
                    builder.setView(alertLayout);


                    builder.setPositiveButton("ยืนยัน", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            StringBuffer buffer = new StringBuffer();
                            for (Integer team : mMultiSelected_menu12) {
                                buffer.append(" ");
                                buffer.append(CLUBS12[team]);
                            }
                            String sp = String.valueOf(spNumber.getSelectedItem());
                            Toast.makeText(mContext, "คุณเลือก " + buffer.toString() + "\nจำนวน " + sp + " ชุดเล็ก", Toast.LENGTH_SHORT).show();
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

                } else if (position == 2) {
                    final ArrayList<Integer> mMultiSelected_menu35 = new ArrayList<Integer>();
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("เลือกวัตถุดิบ");

                    builder.setMultiChoiceItems(CLUBS35, null, new DialogInterface.OnMultiChoiceClickListener() {
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
                                buffer.append(CLUBS35[team]);
                            }
                            String sp = String.valueOf(spNumber.getSelectedItem());
                            Toast.makeText(mContext, "คุณเลือก น้ำอัดลม" + buffer.toString() + "\nจำนวน " + sp + " ขวด", Toast.LENGTH_SHORT).show();
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


                } else if (position == 3) {
                    final ArrayList<Integer> mMultiSelected_menu4 = new ArrayList<Integer>();
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("เลือกวัตถุดิบ");

                    builder.setMultiChoiceItems(CLUBS4, null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked) {
                                mMultiSelected_menu4.add(which);
                            } else if (mMultiSelected_menu4.contains(which)) {
                                mMultiSelected_menu4.remove(Integer.valueOf(which));
                            }
                        }
                    });
                    builder.setView(alertLayout);


                    builder.setPositiveButton("ยืนยัน", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            StringBuffer buffer = new StringBuffer();
                            for (Integer team : mMultiSelected_menu4) {
                                buffer.append(" ");
                                buffer.append(CLUBS4[team]);
                            }
                            String sp = String.valueOf(spNumber.getSelectedItem());
                            Toast.makeText(mContext, "คุณเลือก น้ำแข็ง" + buffer.toString() + "\nจำนวน " + sp + " ถัง", Toast.LENGTH_SHORT).show();
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


                } else if (position == 4) {
                    final ArrayList<Integer> mMultiSelected_menu35 = new ArrayList<Integer>();
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("เลือกวัตถุดิบ");

                    builder.setMultiChoiceItems(CLUBS35, null, new DialogInterface.OnMultiChoiceClickListener() {
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
                                buffer.append(CLUBS35[team]);
                            }
                            String sp = String.valueOf(spNumber.getSelectedItem());
                            Toast.makeText(mContext, "คุณเลือก น้ำเปล่า" + buffer.toString() + "\nจำนวน " + sp + " ขวด", Toast.LENGTH_SHORT).show();
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
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtDescription;
        public ImageButton txtOptionDigit;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtOptionDigit = (ImageButton) itemView.findViewById(R.id.txtOptionDigit);
        }
    }
}
