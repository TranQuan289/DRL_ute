package com.example.android.drl.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.drl.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private List<User> mUserList;

    public UserAdapter(List<User> mUserList) {
        this.mUserList = mUserList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mUserList.get(position);
        if(user == null)
            return;
        holder.txt_name.setText(user.getName());
        holder.txt_msv.setText(String.valueOf(user.getMsv()));
        holder.txt_point.setText(String.valueOf(user.getSum()));
        holder.txt_level.setText(user.getLevel());
    }

    @Override
    public int getItemCount() {
        if (mUserList != null){
            return mUserList.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView txt_name,txt_msv,txt_point,txt_level;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name_list);
            txt_msv = itemView.findViewById(R.id.txt_msv_list);
            txt_point = itemView.findViewById(R.id.txt_point_list);
            txt_level = itemView.findViewById(R.id.txt_level_list);

        }
    }
}
