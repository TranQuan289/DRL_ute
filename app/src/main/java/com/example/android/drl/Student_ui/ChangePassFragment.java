package com.example.android.drl.Student_ui;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.drl.R;
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

import java.util.concurrent.Executor;

public class ChangePassFragment extends Fragment {
    private TextView txt_name, txt_email, txt_notify;
    private EditText edt_pass, edt_pass2, edt_curr_pass;
    private Button btn_change;
    String pass1, pass2;
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pass, container, false);
        txt_name = v.findViewById(R.id.txt_name);
        txt_email = v.findViewById(R.id.txt_email);
        txt_notify = v.findViewById(R.id.txt_notify);
        edt_pass = v.findViewById(R.id.edt_pass);
        edt_pass2 = v.findViewById(R.id.edt_pass2);
        edt_curr_pass = v.findViewById(R.id.edt_curr_pass);
        btn_change = v.findViewById(R.id.btn_change);
        showUser();
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNow();
            }
        });
        return v;
    }

    private void showUser() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        String[] emailCopy = email.split("@");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user/" + emailCopy[0] + "/name");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                txt_name.setText("Họ và Tên: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        txt_email.setText(email);
    }

    public void updateUI(FirebaseUser account) {
        if (account != null) {
            changePass();
        } else {
            txt_notify.setText("Mật khẩu cũ không đúng!");
            Toast.makeText(getActivity(), txt_email.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    protected void changeNow() {
        try {
            mAuth = FirebaseAuth.getInstance();
            String email = txt_email.getText().toString().trim();
            String password = edt_curr_pass.getText().toString().trim();
            LoginUser(email,password);
        } catch (Exception exception) {
            txt_notify.setText("Bạn cần nhập đầy đủ thông tin");
        }
    }

    private void changePass() {
        try {
            pass1 = String.valueOf(edt_pass.getText());
            pass2 = String.valueOf(edt_pass2.getText());
            if (pass1.length() < 6) {
                txt_notify.setText("Mật khẩu phải lớn hơn 6 kí tự!");
            } else if (pass1.equals(pass2)) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                user.updatePassword(pass1)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    txt_notify.setText("");
                                    openDialog(Gravity.CENTER);
                                }
                            }
                        });
            } else {
                txt_notify.setText("Mật khẩu không trùng nhau!");
            }
        } catch (Exception e) {
            txt_notify.setText("Bạn cần nhập đầy đủ thông tin");
        }
    }

    private void openDialog(int gravity) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_update_pass);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }
        Button btn_ok = dialog.findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void LoginUser(String mail,String pass){
        mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    updateUI(null);
                }
            }
        });
    }
}
