package com.NumCo.numberconverter.CipherCreation;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.NumCo.numberconverter.Numerals.ConversionList;
import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.example.numberconverter.R;

import java.util.ArrayList;
import java.util.Objects;

public class CipherHelpFragment extends Fragment {
    private final ConversionList conversionList = new ConversionList();
    private final CipherObjectBitmaps cipherObjectBitmaps = new CipherObjectBitmaps();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cipher_help, container, false);
        ListView listView = view.findViewById(R.id.cipherHelpFirstListView);

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("saved-options", Context.MODE_PRIVATE);
        String selectedOutput = sharedPreferences.getString("output", "HEX");

        ArrayList<BitmapObject> objects = new ArrayList<>();
        objects.add(cipherObjectBitmaps.constantObjects.get(selectedOutput));

        for (String string: conversionList.allConversionOptions) {
            if(!string.equals(selectedOutput))
                objects.add(cipherObjectBitmaps.constantObjects.get(string));
        }

        listView.setAdapter(new ConstantObjectAdapter(requireActivity(), objects));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        requireView().requestLayout();
    }
}