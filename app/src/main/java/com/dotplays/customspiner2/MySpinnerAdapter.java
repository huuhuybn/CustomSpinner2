package com.dotplays.customspiner2;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class MySpinnerAdapter implements SpinnerAdapter {

    private List<Student> studentList;

    private Context context;

    public MySpinnerAdapter(Context context,List<Student> studentList) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.drop_row, parent, false);
        TextView tvName = convertView.findViewById(R.id.tvName);
        tvName.setText(studentList.get(position).name);

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.seleted_row, parent, false);

        TextView tvName = convertView.findViewById(R.id.tvName);
        tvName.setText(studentList.get(position).name);
        return convertView;
    }


    @Override
    public int getViewTypeCount() {
        return 1;
    }


    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Student getItem(int position) {
        return studentList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }
}
