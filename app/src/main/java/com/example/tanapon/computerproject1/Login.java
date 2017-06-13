package com.example.tanapon.computerproject1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class Login extends Activity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference().child("table");
    private DatabaseReference checkBill = FirebaseDatabase.getInstance().getReference().child("status");
    public String user_login, pass_login, user_check;
    public int i, check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void loginHome(View view) {
        final Intent intent = new Intent(this, MainActivity.class);

        EditText editPass = (EditText) findViewById(R.id.edit_pass);
        final String pass = editPass.getText().toString();

        EditText editUser = (EditText) findViewById(R.id.edit_user);
        final String user = editUser.getText().toString();

        mRootReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                i = 0;
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    pass_login = data.child("password_login").getValue().toString();
                    user_login = data.child("user_login").getValue().toString();
                    i++;
                    if (Objects.equals(user, user_login)) {
                        ProgressDialog progressDialog = new ProgressDialog(Login.this, R.style.AppTheme_Dark_Dialog);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setMessage("Authenticating...");
                        progressDialog.show();
                        if (Objects.equals(pass, pass_login)) {
                            check = i;
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "เข้าสู่ระบบ", Toast.LENGTH_SHORT).show();
                            finish();
                            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putInt("saved_high_score", i);
                            editor.commit();
                            if (check == 1) {
                                SharedPreferences sharedPref_bill = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                SharedPreferences.Editor editor_bill = sharedPref_bill.edit();
                                editor.putString("bill", "-KkMkfyYUWlCd3-dsB0v");
                                editor.commit();
                            } else if (check == 2){
                                SharedPreferences sharedPref_bill = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                SharedPreferences.Editor editor_bill = sharedPref_bill.edit();
                                editor.putString("bill", "-KkMlGsv_BLqMUUTgBmW");
                                editor.commit();
                            }else {
                                SharedPreferences sharedPref_bill = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                SharedPreferences.Editor editor_bill = sharedPref_bill.edit();
                                editor.putString("bill", "-KmX3ud-3ESMU_42lxxd");
                                editor.commit();
                            }

                            checkBill.child("table_" + String.valueOf(check)).setValue(1);
                        } else {
                            Toast.makeText(getApplicationContext(), "user name หรือ password ไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
