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
import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.example.numberconverter.R;

import java.util.ArrayList;

public class ConstantObjectAdapter extends ArrayAdapter<BitmapObject> {

    private FragmentActivity mContext;
    private ArrayList<BitmapObject> constantObjects = null;

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

        if (constantObjects.size() > 0 && position == 0) {
            imageView.setColorFilter(new PorterDuffColorFilter(mContext.getResources().getColor(R.color.dark_blue),
                    PorterDuff.Mode.SRC_IN));
            TextView status = new TextView(mContext);
            status.setText("Selected Output");
            status.setTextColor(mContext.getResources().getColor(R.color.dark_blue));
            status.setGravity(Gravity.CENTER);
            status.setPadding(0, (int) Math.ceil((double) 15 * mContext.getResources().getDisplayMetrics().scaledDensity), 0, 0);
            linearLayout.addView(status, 0);
        }

        if (constantObjects.size() > 1 && position == 1) {
            imageView.setColorFilter(new PorterDuffColorFilter(mContext.getResources().getColor(R.color.chrome_yellow),
                    PorterDuff.Mode.SRC_IN));
            TextView status = new TextView(mContext);
            status.setText("Selected Input");
            status.setTextColor(mContext.getResources().getColor(R.color.chrome_yellow));
            status.setGravity(Gravity.CENTER);
            linearLayout.addView(status, 0);
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
