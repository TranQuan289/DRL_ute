package com.example.android.drl.Start_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.android.drl.R;
import com.example.android.drl.Student_ui.MainStudentActivity;
import com.example.android.drl.Teacher_ui.MainTeacherActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        }, 1000);
    }

    private void nextActivity() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();
        } else {
            checkUser();
        }
    }
    private void checkUser() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        String[] emailCopy = email.split("@");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user/"+emailCopy[0]+"/permission");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if(value.compareTo("student") == 0){
                    startActivity(new Intent(SplashActivity.this, MainStudentActivity.class));
                    finishAffinity();
                }else if(value.compareTo("teacher") == 0){
                    Intent intent = new Intent(SplashActivity.this, MainTeacherActivity.class);
                    startActivity(intent);
                    finishAffinity();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
}
