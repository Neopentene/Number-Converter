package com.NumCo.numberconverter.History;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.NumCo.numberconverter.Converter;
import com.NumCo.numberconverter.Database.Queries;
import com.NumCo.numberconverter.Notify;
import com.NumCo.numberconverter.ObjectPainter.Status;
import com.NumCo.numberconverter.Objects.HISTORY;
import com.NumCo.numberconverter.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class HistoryDialog extends Dialog implements LocalHistoryCommands {

    private final Context context;
    private final Activity activity;
    private final Notify notify;

    public HistoryDialog(@NonNull Context context, Activity activity) {
        super(context);
        this.context = context;
        this.activity = activity;
        this.notify = (Converter) activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_dialog_layout);
        getWindow().setBackgroundDrawableResource(R.drawable.transparent_dialog_inset_10_30);

        MaterialButton clearAll, back;

        clearAll = findViewById(R.id.historyClearAllButton);
        back = findViewById(R.id.historyBackButton);

        TextView title = findViewById(R.id.historyTitle);
        TextView noHistoryPrompt = findViewById(R.id.noHistoryPrompt);

        ListView listView = findViewById(R.id.Histories);

        ArrayList<HISTORY> histories = new Queries().getAllHistory(context);

        if (histories.size() > 0) {
            listView.setAdapter(new HistoryAdapter(context, histories, this, (Converter) activity));
            noHistoryPrompt.setVisibility(View.GONE);
            clearAll.setVisibility(View.VISIBLE);
        } else {
            listView.setVisibility(View.GONE);
            noHistoryPrompt.setVisibility(View.VISIBLE);
            noHistoryPrompt.setText(R.string.no_history);
            noHistoryPrompt.setTextColor(Status.PLACEHOLDER.color);
            clearAll.setVisibility(View.GONE);
        }

        title.setTextColor(Status.NORMAL.color);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextSize(20);

        clearAll.setOnClickListener(v -> {
            new Queries().deleteAllHistories(context);
            notify.makeSnackBar("Cleared History", Status.NORMAL.color,
                    R.string.ok, null);
            dismiss();
        });

        back.setOnClickListener(v -> dismiss());

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;

        getWindow().setAttributes(params);
    }

    @Override
    public void clearHistoryItem(long id, int size, boolean wasLast) {
        new Queries().deleteHistory(id, context);

        if (size <= 0) {
            TextView noHistoryPrompt = findViewById(R.id.noHistoryPrompt);
            ListView listView = findViewById(R.id.Histories);
            MaterialButton clearAll = findViewById(R.id.historyClearAllButton);

            noHistoryPrompt.setVisibility(View.VISIBLE);
            noHistoryPrompt.setText(R.string.no_history);
            noHistoryPrompt.setTextColor(Status.PLACEHOLDER.color);

            listView.setVisibility(View.GONE);
            clearAll.setVisibility(View.GONE);
        }

        if (wasLast){
            ListView listView = findViewById(R.id.Histories);
            listView.smoothScrollToPosition(listView.getAdapter().getCount() - 1);
        }
    }

    @Override
    public void makeToast(String msg, int color) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void dialogDismiss() {
        dismiss();
    }
}
