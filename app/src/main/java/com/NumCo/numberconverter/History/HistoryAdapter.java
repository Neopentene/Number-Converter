package com.NumCo.numberconverter.History;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.NumCo.numberconverter.Converter;
import com.NumCo.numberconverter.ObjectPainter.Status;
import com.NumCo.numberconverter.Objects.HISTORY;
import com.NumCo.numberconverter.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class HistoryAdapter extends ArrayAdapter<HISTORY> {
    private final ArrayList<HISTORY> histories;
    private final Activity activity;
    private final HistoryCommands historyCommands;
    private final LocalHistoryCommands localHistoryCommands;
    private volatile int clearOnce = 0;

    public HistoryAdapter(@NonNull Context context, ArrayList<HISTORY> histories, HistoryDialog caller, Converter parent) {
        super(context, R.layout.history_list_item_layout, histories);
        this.histories = histories;
        this.activity = parent;
        this.localHistoryCommands = caller;
        this.historyCommands = parent;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = activity.getLayoutInflater().inflate(R.layout.history_list_item_layout, parent, false);
        TextView input, inputType, output, outputType;
        View divider = view.findViewById(R.id.historyDivider);
        ImageView imageView = view.findViewById(R.id.pointer);
        MaterialButton set, clear;

        HISTORY history = histories.get(position);

        input = view.findViewById(R.id.input);
        inputType = view.findViewById(R.id.inputType);
        output = view.findViewById(R.id.output);
        outputType = view.findViewById(R.id.outputType);

        set = view.findViewById(R.id.setHistorySelection);
        clear = view.findViewById(R.id.clearHistory);

        set.setOnClickListener(v -> {
            historyCommands.setHistoryValue(history);
            localHistoryCommands.dialogDismiss();
        });

        clear.setOnClickListener(v -> {
            increaseClearCount();
            if (clearOnce == 1) {
                ObjectAnimator.ofFloat(input, View.ALPHA, 1f, 0f).setDuration(1000).start();
                ObjectAnimator.ofFloat(inputType, View.ALPHA, 1f, 0f).setDuration(1000).start();
                ObjectAnimator.ofFloat(output, View.ALPHA, 1f, 0f).setDuration(1000).start();
                ObjectAnimator.ofFloat(outputType, View.ALPHA, 1f, 0f).setDuration(1000).start();
                ObjectAnimator.ofFloat(set, View.ALPHA, 1f, 0f).setDuration(1000).start();
                ObjectAnimator.ofFloat(clear, View.ALPHA, 1f, 0f).setDuration(1000).start();
                ObjectAnimator.ofFloat(divider, View.ALPHA, 1f, 0f).setDuration(1000).start();
                ObjectAnimator.ofFloat(imageView, View.ALPHA, 1f, 0f).setDuration(1000).start();


                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(() -> {
                    input.setVisibility(View.GONE);
                    inputType.setVisibility(View.GONE);
                    output.setVisibility(View.GONE);
                    outputType.setVisibility(View.GONE);
                    set.setVisibility(View.GONE);
                    clear.setVisibility(View.GONE);
                    divider.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);

                    Handler post = new Handler(Looper.getMainLooper());
                    post.postDelayed(() -> {
                        histories.remove(position);
                        notifyDataSetChanged();
                        localHistoryCommands.clearHistoryItem(history.ID, histories.size(), position == histories.size());
                        localHistoryCommands.makeToast("Erased", Status.PLACEHOLDER.color);
                        clearOnce = 0;
                    }, 200);

                }, 1000);
            }
        });

        inputType.setText("Input: " + history.INPUT_TYPE);
        inputType.setTextColor(Status.INPUT.color);
        input.setText(history.INPUT);
        input.setTextColor(Status.NORMAL.color);

        outputType.setText("Output: " + history.OUTPUT_TYPE);
        outputType.setTextColor(Status.OUTPUT.color);
        output.setText(history.OUTPUT);
        output.setTextColor(Status.NORMAL.color);

        if (position == histories.size() - 1) {
            divider.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    private synchronized void increaseClearCount() {
        clearOnce++;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}
