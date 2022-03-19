package com.NumCo.numberconverter.History;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.NumCo.numberconverter.R;

public class HistoryDialog extends Dialog {
    
    public HistoryDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_dialog_layout);
        getWindow().setBackgroundDrawableResource(R.drawable.transparent_dialog_inset_10_30);

        ListView listView = findViewById(R.id.Histories);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;

        getWindow().setAttributes(params);
    }
}
