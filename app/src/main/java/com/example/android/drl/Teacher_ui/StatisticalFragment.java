package com.example.android.drl.Teacher_ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.drl.R;
import com.example.android.drl.User.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatisticalFragment extends Fragment {
    private TextView txt_count, txt_count1, txt_count2, txt_count3, txt_count_mark, txt_count_mark_xs, txt_count_mark_g, txt_count_mark_t;
    private int count, count1, count2, count3, count4 = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_statistical, container, false);
        txt_count = v.findViewById(R.id.txt_count);
        txt_count1 = v.findViewById(R.id.txt_count1);
        txt_count2 = v.findViewById(R.id.txt_count2);
        txt_count3 = v.findViewById(R.id.txt_count3);
        txt_count_mark = v.findViewById(R.id.txt_count_mark);
        txt_count_mark_xs = v.findViewById(R.id.txt_count_mark_xs);
        txt_count_mark_g = v.findViewById(R.id.txt_count_mark_g);
        txt_count_mark_t = v.findViewById(R.id.txt_count_mark_t);
        getCount();
        return v;
    }

    private void getCount() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                User user = snapshot.getValue(User.class);
                if (user != null && user.getPermission().compareTo("student") == 0) {
                    if (user != null) {
                        count++;
                    }
                    if (user.getSum() > 0) {
                        count1++;
                    }
                    if (user.getSum() >= 90) {
                        count2++;
                    } else if (user.getSum() >= 80) {
                        count3++;
                    } else if (user.getSum() >= 65) {
                        count4++;
                    }
                }
                txt_count.setText("/" + String.valueOf(count));
                txt_count1.setText("/" + String.valueOf(count));
                txt_count2.setText("/" + String.valueOf(count));
                txt_count3.setText("/" + String.valueOf(count));
                txt_count_mark.setText(String.valueOf(count1));
                txt_count_mark_xs.setText(String.valueOf(count2));
                txt_count_mark_g.setText(String.valueOf(count3));
                txt_count_mark_t.setText(String.valueOf(count4));


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
