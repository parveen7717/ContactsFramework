package com.example.contactsframework.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.contactsframework.R;
import com.example.contactsframework.model.ContactModel;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    public Context context;
    List<ContactModel> list;

    public ContactsAdapter(Context context, List<ContactModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_item,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).name);
        holder.number.setText(list.get(position).mobileNumber);
    }

    @Override
    public int getItemCount() {
        System.out.println("sizeeeeeeeeee"+String.valueOf(list.size()));
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
        }
    }
}
