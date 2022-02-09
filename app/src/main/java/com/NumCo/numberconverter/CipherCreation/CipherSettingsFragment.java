package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.example.numberconverter.R;

public class CipherSettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cipher_settings, container, true);
        ImageView imageView = view.findViewById(R.id.imageSettings);

        Painter painter = new Painter(500, 500, Bitmap.Config.ARGB_8888);

        painter
                .drawBorderedCircle(200, 10, Color.RED)
                .drawBorderedCircle(100, 5, Color.GREEN)
                .drawBorderedRectangle(100f, 150f, 400f,350f, 5, Color.YELLOW)
        .drawBorderedArc(100f,150f, 400f, 350f, 0, 180,false,5, Color.MAGENTA)
        .drawBorderedArc(100, 150, 400, 350, 180, 360,false,5,Color.MAGENTA)
        .drawLine(250,150,250,350,5,Color.BLUE)
        .drawLine(100,260,250,445,5,Color.CYAN)
        .drawLine(400,260,250,445,5,Color.CYAN)

        ;
        painter.scale(2f,2f);
        imageView.setImageBitmap(painter.getBitmap());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        requireView().requestLayout();
    }
}
