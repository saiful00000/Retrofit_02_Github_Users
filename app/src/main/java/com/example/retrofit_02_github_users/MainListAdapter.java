package com.example.retrofit_02_github_users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainViewHolder> {

    String[] userNames;
    String[] userIds;
    String[] userTypes;
    String[] userAdmins;

    public MainListAdapter(String[] userNames, String[] userIds, String[] userTypes, String[] userAdmins) {
        this.userNames = userNames;
        this.userIds = userIds;
        this.userTypes = userTypes;
        this.userAdmins = userAdmins;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.main_recycle_view_custom_layout, parent, false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        String name = userNames[position];
        String id = userIds[position];
        String type = userTypes[position];
        String admin = userAdmins[position];

        holder.nameTv.setText(name);
        holder.idTv.setText(id);
        holder.typeTv.setText(type);
        holder.adminTv.setText(admin);
    }

    @Override
    public int getItemCount() {
        return userAdmins.length;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView idTv;
        TextView typeTv;
        TextView adminTv;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_text_view_id);
            idTv = itemView.findViewById(R.id.id_text_view_id);
            typeTv = itemView.findViewById(R.id.type_text_view_id);
            adminTv = itemView.findViewById(R.id.admin_text_view_id);
        }
    }
}
