package com.NumCo.numberconverter.History;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.NumCo.numberconverter.Objects.HISTORY;
import com.NumCo.numberconverter.R;

import java.util.ArrayList;

public class HistoryAdapter extends ArrayAdapter<HISTORY> {
    private ArrayList<HISTORY> histories;
    private Context context;

    public HistoryAdapter(@NonNull Context context, ArrayList<HISTORY> histories) {
        super(context, R.layout.history_list_item_layout, histories);
        this.histories = histories;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = View.inflate(context, R.layout.history_list_item_layout, parent);

        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}
