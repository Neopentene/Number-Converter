package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.example.numberconverter.R;

import java.util.Objects;

public class CipherSettingsFragment extends Fragment {

    private CipherObjectBitmaps cipherObjectBitmaps;

    public CipherSettingsFragment(CipherObjectBitmaps objectBitmaps){
        cipherObjectBitmaps = objectBitmaps;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cipher_settings, container, true);
        ImageView imageView = view.findViewById(R.id.imageSettings);

        Painter painter = new Painter(500, 500 * cipherObjectBitmaps.objects.size() + 1);

        int i = 0;
        for (String string: cipherObjectBitmaps.keyArray) {
            painter.drawBitmap(0, 500 * i, Objects.requireNonNull(cipherObjectBitmaps.objects.get(string)).getBitmap(), null);
            i++;
        }

        Painter.Parser parser = painter.new Parser(new String[] { "dBAB|10|" + Color.RED});


        if(parser.parse())
            Log.e("Here", "Done I guess: " + "dBAB|10|" + Color.RED);
        else
            Log.e("Here Error", "Error: " + "dBAB|10|" + Color.RED);

        painter
                .drawBorderedRoundedRectangle(20 * 3, 20 * 3, 180 * 3, 180 * 3, 10 * 3, 10 * 3, 5 * 3, Color.BLUE)
                .drawArc(40 * 3, 40 * 3, 160 * 3, 160 * 3, 30, 120, true, Color.GREEN)
                .drawBorderedArc(40 * 3, 40 * 3, 160 * 3, 160 * 3, -30, -120, false, 5 * 3, Color.GREEN)
                .drawBorderedCircle(100 * 3, 100 * 3, 25 * 3, 5 * 3, Color.MAGENTA);

        imageView.setImageBitmap(painter.getBitmap());
        return view;
    }
}