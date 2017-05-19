package com.example.tanapon.computerproject1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class gridAdapterService extends BaseAdapter {
    ArrayList names;
    public static Activity activity;

    private DatabaseReference mDatabase;

    public gridAdapterService(Activity activity, ArrayList names) {
        this.activity = activity;
        this.names = names;
    }


    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        //Firebase Database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(activity);
        int defaultValue = 0;
        long highScore = sharedPref.getInt("saved_high_score", defaultValue);
        final String user_log = "table_" + String.valueOf(highScore);


        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            v = vi.inflate(R.layout.service_grid_layout, null);
        }
        TextView textView = (TextView) v.findViewById(R.id.namePlacer);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageHolder);
        if (names.get(position).toString().equals("เปลี่ยนกระทะ")) {
            imageView.setImageResource(R.mipmap.ic_attendance);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("ท่านต้องการเปลี่ยนกระทะ");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(activity, "กรุณารอสักครู่", Toast.LENGTH_SHORT).show();
                            mDatabase.child("requirement").child(user_log).push().setValue("เปลี่ยนกระทะ");
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss();
                        }
                    });
                    builder.show();

                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        } else if (names.get(position).toString().equals("เติมถ่าน")) {
            imageView.setImageResource(R.mipmap.ic_schedule);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("ท่านต้องการเติมถ่าน");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(activity, "กรุณารอสักครู่", Toast.LENGTH_SHORT).show();
                            mDatabase.child("requirement").child(user_log).push().setValue("เติมถ่าน");
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss();
                        }
                    });
                    builder.show();

                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        } else if (names.get(position).toString().equals("เติมน้ำจิ้ม")) {
            imageView.setImageResource(R.mipmap.ic_notes);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("ท่านต้องการเติมน้ำจิ้ม");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(activity, "กรุณารอสักครู่", Toast.LENGTH_SHORT).show();
                            mDatabase.child("requirement").child(user_log).push().setValue("เติมน้ำจิ้ม");
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss();
                        }
                    });
                    builder.show();

                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        } else if (names.get(position).toString().equals("เติมกระดาษ")) {
            imageView.setImageResource(R.mipmap.ic_profile);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("ท่านต้องการเเติมกระดาษทิชชู่");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(activity, "กรุณารอสักครู่", Toast.LENGTH_SHORT).show();
                            mDatabase.child("requirement").child(user_log).push().setValue("เติมกระดาษ");
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss();
                        }
                    });
                    builder.show();

                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        } else if (names.get(position).toString().equals("เติมน้ำซุป")) {
            imageView.setImageResource(R.mipmap.ic_capa);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("ท่านต้องการเเติมน้ำซุป");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(activity, "กรุณารอสักครู่", Toast.LENGTH_SHORT).show();
                            mDatabase.child("requirement").child(user_log).push().setValue("เติมน้ำซุป");
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss();
                        }
                    });
                    builder.show();

                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }

        textView.setText(names.get(position).toString());
        return v;
    }

}

