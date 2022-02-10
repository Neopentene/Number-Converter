package com.NumCo.numberconverter.CipherCreation;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
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

import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.ObjectBitmapStatus;
import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.example.numberconverter.R;

import java.util.ArrayList;

public class ConstantObjectAdapter extends ArrayAdapter<BitmapObject> {

    private final FragmentActivity mContext;
    private final ArrayList<BitmapObject> constantObjects;

    public ConstantObjectAdapter(@NonNull FragmentActivity context, @NonNull ArrayList<BitmapObject> objects) {
        super(context, R.layout.help_input_output_layout, objects);
        mContext = context;
        constantObjects = objects;
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

        imageView.setImageBitmap(constantObjects.get(position).getBitmap());
        textView.setText(mContext.getResources().getIdentifier("help_" + constantObjects.get(position).getId(), "string", mContext.getPackageName()));

        ObjectBitmapStatus status = constantObjects.get(position).getBitmapStatus();

        if (status != ObjectBitmapStatus.DISABLED) {

            TextView statusTextView = new TextView(mContext);
            statusTextView.setTextColor(status.color);
            statusTextView.setGravity(Gravity.CENTER);

            imageView.setColorFilter(new PorterDuffColorFilter(status.color,
                    PorterDuff.Mode.SRC_IN));

            switch (status) {
                case ERROR:
                    statusTextView.setText("Input and Output");
                    linearLayout.addView(statusTextView, 0);
                    break;
                case ACTIVE_INPUT:
                    statusTextView.setText("Selected Input");
                    linearLayout.addView(statusTextView, 0);
                    break;
                case ACTIVE_OUTPUT:
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

        if (position == constantObjects.size() - 1)
            divider.setVisibility(View.INVISIBLE);

        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
