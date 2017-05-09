package com.example.tanapon.computerproject1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import static android.content.ContentValues.TAG;


public class Login extends Activity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mCgildReference = mRootReference.child("table");
    private DatabaseReference mTable1 = mCgildReference.child("table_1");
    private DatabaseReference mTable2 = mCgildReference.child("table_2");
    private DatabaseReference passTable1 = mTable1.child("password_login");
    private DatabaseReference userTable1 = mTable1.child("user_login");
    private DatabaseReference passTable2 = mTable2.child("password_login");
    private DatabaseReference userTable2 = mTable2.child("user_login");
    private String userFire1, passFire1, userFire2, passFire2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        passTable1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                passFire1 = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        userTable1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                userFire1 = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        passTable2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                passFire2 = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        userTable2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                userFire2 = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void loginHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        EditText editPass = (EditText) findViewById(R.id.edit_pass);
        String pass = editPass.getText().toString();

        EditText editUser = (EditText) findViewById(R.id.edit_user);
        String user = editUser.getText().toString();

        switch (user) {
            case "table1":
                if (Objects.equals(pass, passFire1)) {
                    startActivity(intent);
                    Toast.makeText(this, "เข้าสู่ระบบ", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this, "user name หรือ password ไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                break;
            case "table2":
                if (Objects.equals(pass, passFire2)) {
                    startActivity(intent);
                    Toast.makeText(this, "เข้าสู่ระบบ", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this, "user name หรือ password ไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "user name หรือ password ไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
