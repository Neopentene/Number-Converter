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
                /*.drawBorderedCircle(200, 5, Color.RED)//outer-circle

                .drawBorderedCircle(100, 5, Color.GREEN)//inner-circle

                .drawBorderedRectangle(100f, 150f, 400f,350f, 5, Color.YELLOW)//horizontal-rectangle

                .drawBorderedArc(100f,150f, 400f, 350f, 0, 180,false,5, Color.MAGENTA)//lower-arc-of-ellipse
                .drawBorderedArc(100, 150, 400, 350, 180, 360,false,5,Color.MAGENTA)//upper-arc-of-ellipse

                .drawLine(250,150,250,350,5,Color.BLUE)//center-vertical-line

                .drawLine(100,260,250,445,5,Color.CYAN)//left-bottom
                .drawLine(400,260,250,445,5,Color.CYAN)//right-bottom
                .drawLine(250,55,400,260,5,Color.CYAN)//right-top
                .drawLine(250,55,100,260,5,Color.CYAN)//left-top

                .drawLine(250,150,100,260,5,Color.DKGRAY)//left-top
                .drawLine(100,260,250,350,5,Color.DKGRAY)//left-bottom
                .drawLine(400,260,250,350,5,Color.DKGRAY)//right-bottom
                .drawLine(250,150,400,260,5,Color.DKGRAY)//right-top */

                .drawLine(99f,147f,417f,366f,7,Color.BLUE) //backslash line coordinates hourglass
                .drawLine(91f,374f,415f,155f,7,Color.BLUE) //forwardslash line coordinates hourglass
                //.drawBorderedArc(80f,215f,420f,445f,18,146,false,5,Color.BLUE)
                .drawBorderedArc(91f,345f,420f,395f,207,324,false,5,Color.BLUE) //lower-ellipse hourglass
                .drawBorderedArc(100f,125f,420f,175f,185,324,false,5,Color.BLUE) //upper-ellipse hourglass





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
