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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cipher_settings, container, true);
        ImageView imageView = view.findViewById(R.id.imageSettings);
        Painter painter = new Painter(200, 200, Bitmap.Config.ARGB_8888);
        painter
                .drawBorderedRoundedRectangle(0, 0, 200, 200, 30, 30, 10, Color.BLACK)
                .drawTextAtCenter("DEC", Typeface.create(Typeface.SERIF, Typeface.BOLD), 60, Color.BLACK)
                .drawLine(15, 70, 15, 130, 10, Color.BLACK);
        imageView.setImageBitmap(painter.getBitmap());
        return view;
    }
}