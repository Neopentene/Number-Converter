package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.example.numberconverter.R;

public class CipherHelpFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cipher_help, container, false);
        ImageView imageView = view.findViewById(R.id.image);
        Painter painter = new Painter(200, 200, Bitmap.Config.ARGB_8888);
        painter
                .drawBorderedRoundedRectangle(20, 20, 180, 180, 10, 10, 5, Color.BLUE)
                .drawBorderedArc(40, 40, 160, 160, 30, 120, true, 5, Color.GREEN)
                .drawBorderedArc(40, 40, 160, 160, -30, -120, true, 5, Color.GREEN)
                .drawBorderedCircle(100, 100, 25, 5, Color.MAGENTA);
        imageView.setImageBitmap(painter.getBitmap());
        return view;
    }
}