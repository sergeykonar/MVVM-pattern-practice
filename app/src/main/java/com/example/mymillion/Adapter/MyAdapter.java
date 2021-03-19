package com.example.mymillion.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mymillion.Model.User;
import com.example.mymillion.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {


    private ArrayList<User> userList;
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setUsers(List<User> userList){
        this.userList = (ArrayList<User>) userList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {

        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        TextView tv = view.findViewById(R.id.textView2);
        User user = (User) getItem(position);
        tv.setText(user.getId() + ": " + user.getName() + " " + user.getSurname());
        return view;
    }
}