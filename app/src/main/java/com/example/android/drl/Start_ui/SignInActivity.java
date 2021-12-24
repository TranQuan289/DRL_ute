package com.example.android.drl.Start_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.drl.R;
import com.example.android.drl.Student_ui.MainStudentActivity;
import com.example.android.drl.Teacher_ui.MainTeacherActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {
    private EditText txt_email, txt_pass;
    private TextView txt_ps, txt_forgot;
    private Button btn_login;
    private FirebaseAuth mAuth;
    private String[] emailCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn_login = findViewById(R.id.btn_login);
        txt_email = findViewById(R.id.txt_email);
        txt_pass = findViewById(R.id.txt_pass);
        txt_ps = findViewById(R.id.txt_ps);
        txt_forgot = findViewById(R.id.txt_forgot);
        txt_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, ResetPassActivity.class));
                finish();
            }
        });
        mAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void updateUI(FirebaseUser account) {
        if (account != null) {
            checkUser();
        } else {
            txt_ps.setText("Tài Khoản Hoặc Mật Khẩu Không Đúng");
        }
    }

    protected void login() {
        try {
            String email = txt_email.getText().toString().trim();
            String password = txt_pass.getText().toString().trim();
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                emailCopy = email.split("@");
                                updateUI(user);
                            } else {
                                updateUI(null);
                            }
                        }
                    });
        } catch (Exception exception) {
            txt_ps.setText("Bạn cần nhập đầy đủ thông tin");
        }
    }

    private void checkUser() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user/" + emailCopy[0] + "/permission");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if (value.compareTo("student") == 0) {
                    txt_ps.setText("");
                    openDialog(Gravity.BOTTOM);
                    startActivity(new Intent(SignInActivity.this, MainStudentActivity.class));
                    finishAffinity();
                } else if (value.compareTo("teacher") == 0) {
                    txt_ps.setText("");
                    openDialog(Gravity.BOTTOM);
                    Intent intent = new Intent(SignInActivity.this, MainTeacherActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    txt_ps.setText("");
                    openDialog(Gravity.BOTTOM);
                    startActivity(new Intent(SignInActivity.this, MainStudentActivity.class));
                    finishAffinity();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
    private void openDialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_logon);
        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else {
            dialog.setCancelable(false);
        }
        dialog.show();
    }
}