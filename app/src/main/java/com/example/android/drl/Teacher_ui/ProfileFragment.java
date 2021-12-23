package com.example.android.drl.Teacher_ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.drl.R;
import com.example.android.drl.Start_ui.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {
    private TextView txt_name, txt_email;
    private TextView txt_notify;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
       TextView txt_logout = v.findViewById(R.id.txt_logout);
        txt_name = v.findViewById(R.id.txt_name);
        txt_email = v.findViewById(R.id.txt_email);
        txt_notify = v.findViewById(R.id.txt_notify);
        showUser();
       txt_logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FirebaseAuth.getInstance().signOut();
               logout();
           }
       });
       txt_notify.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               NotifyFragment fragment2 = new NotifyFragment();
               FragmentManager fragmentManager = getFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.replace(R.id.main, fragment2);
               fragmentTransaction.commit();
           }
       });
        return v;
    }
    public void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), SignInActivity.class);
        startActivity(intent);
        finishActivity();
    }
    private void finishActivity() {
        if(getActivity() != null) {
            getActivity().finish();
        }
    }
    private void showUser() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        String[] emailCopy = email.split("@");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user/"+emailCopy[0]+"/name");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                txt_name.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        txt_email.setText(email);
    }
}
