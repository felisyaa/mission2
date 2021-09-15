package com.example.mission2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.listm;

public class rvadapter extends RecyclerView.Adapter<rvadapter.UserViewHolder> {

    private ArrayList<listm> list;
    public rvadapter(ArrayList<listm> list){
        this.list= list;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_cardview, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.nama.setText(list.get(position).getNama());
        holder.why.setText(list.get(position).getWhy());
        holder.when.setText(String.valueOf(list.get(position).getWhen()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView nama, why, when;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.editnama);
            why = itemView.findViewById(R.id.editwhy);
            when = itemView.findViewById(R.id.editwhen);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),MainActivity.class);
                    intent.putExtra("nama", nama.getText());
                    intent.putExtra("why", why.getText());
                    intent.putExtra("when", when.getText());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
