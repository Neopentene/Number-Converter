package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
        Painter painter = new Painter(200, 1800, Bitmap.Config.ARGB_8888);
        painter.drawBorderedCircle(100, 10, Color.RED);
        painter.drawCircle(painter.getBitmapCenterX(), painter.getBitmapCenterY() + 200, 100, Color.DKGRAY);
        painter.drawBorderedCircle(painter.getBitmapCenterX(), painter.getBitmapCenterY() + 200, 100, 10, Color.MAGENTA);
        painter.drawCircle(10, Color.BLUE);
        painter.drawText(painter.getBitmapCenterX() + ", " + painter.getBitmapCenterY(), 0, painter.getBitmapCenterY() + 400, 30, Color.BLACK);
        imageView.setImageBitmap(painter.getBitmap());
        return view;
    }
}