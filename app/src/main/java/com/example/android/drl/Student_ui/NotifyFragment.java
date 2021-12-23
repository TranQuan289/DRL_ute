package com.example.android.drl.Student_ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.drl.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotifyFragment extends Fragment {

    private TextView txt_title, txt_content;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notify_student,container,false);
        txt_title= v.findViewById(R.id.txt_title);
        txt_content = v.findViewById(R.id.txt_content);
        readData();
        return v;
    }
    private void readData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference sendTitle = database.getReference("notify/title");
        DatabaseReference sendContent = database.getReference("notify/content");
        sendTitle.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                txt_title.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        sendContent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value1 = dataSnapshot.getValue(String.class);
                txt_content.setText(value1);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}