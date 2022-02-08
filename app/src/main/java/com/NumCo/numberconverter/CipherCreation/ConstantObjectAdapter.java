package com.NumCo.numberconverter.CipherCreation;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        ImageView imageView = view.findViewById(R.id.helpInputOutputImage);
        TextView textView = view.findViewById(R.id.helpInputOutputDescription);
        View divider = view.findViewById(R.id.helpInputOutputDescriptionDivider);

        imageView.setImageBitmap(constantObjects.get(position).getBitmap());
        textView.setText(mContext.getResources().getIdentifier("help_" + constantObjects.get(position).getId(), "string", mContext.getPackageName()));

        if (constantObjects.size() > 1 && position == 0) {
            imageView.setColorFilter(new PorterDuffColorFilter(mContext.getResources().getColor(R.color.dark_blue),
                    PorterDuff.Mode.SRC_IN));
            imageView.setPadding(0, (int) Math.ceil((double) 12 * mContext.getResources().getDisplayMetrics().scaledDensity), 0, 0);
            textView.append("\n\nCURRENT: Output");
        }

        if (constantObjects.size() > 2 && position == 1) {
            imageView.setColorFilter(new PorterDuffColorFilter(mContext.getResources().getColor(R.color.chrome_yellow),
                    PorterDuff.Mode.SRC_IN));
            textView.append("\n\nCURRENT: Input");
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
