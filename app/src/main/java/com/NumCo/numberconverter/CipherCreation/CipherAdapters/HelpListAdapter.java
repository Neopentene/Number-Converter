package com.NumCo.numberconverter.CipherCreation.CipherAdapters;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.NumCo.numberconverter.CipherCreation.Store;
import com.NumCo.numberconverter.ObjectPainter.Generator;
import com.NumCo.numberconverter.ObjectPainter.Status;
import com.NumCo.numberconverter.R;

import java.util.ArrayList;

public class HelpListAdapter extends ArrayAdapter<Store.ImageGenerator> {

    private final FragmentActivity mContext;
    private final ArrayList<Store.ImageGenerator> imageData;

    public HelpListAdapter(@NonNull FragmentActivity context, @NonNull ArrayList<Store.ImageGenerator> imageData) {
        super(context, R.layout.help_input_output_layout, imageData);
        mContext = context;
        this.imageData = imageData;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = mContext.getLayoutInflater().inflate(R.layout.help_input_output_layout, parent, false);

        LinearLayout linearLayout = view.findViewById(R.id.helpInputOutputLayout);
        ImageView imageView = view.findViewById(R.id.helpInputOutputImage);
        TextView textView = view.findViewById(R.id.helpInputOutputDescription);
        View divider = view.findViewById(R.id.helpInputOutputDescriptionDivider);

        imageView.setImageBitmap(Generator.generate(imageData.get(position).commands));
        textView.setText(mContext.getResources().getIdentifier("help_" + imageData.get(position).id, "string", mContext.getPackageName()));

        Status status = imageData.get(position).status;

        if (status != Status.DISABLED) {

            TextView statusTextView = new TextView(mContext);
            statusTextView.setTextColor(status.color);
            statusTextView.setGravity(Gravity.CENTER);

            switch (status) {

                case ERROR:
                    statusTextView.setText("Input and Output");
                    linearLayout.addView(statusTextView, 0);
                    break;
                case INPUT:
                    statusTextView.setText("Selected Input");
                    linearLayout.addView(statusTextView, 0);
                    break;
                case OUTPUT:
                    statusTextView.setText("Selected Output");
                    linearLayout.addView(statusTextView, 0);
                    break;
            }

            if (position == 0)
                statusTextView.setPadding(0,
                        (int) Math.ceil((double) 15 * mContext.getResources().getDisplayMetrics().scaledDensity),
                        0,
                        0);
        }

        if (position == imageData.size() - 1)
            divider.setVisibility(View.INVISIBLE);

        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
