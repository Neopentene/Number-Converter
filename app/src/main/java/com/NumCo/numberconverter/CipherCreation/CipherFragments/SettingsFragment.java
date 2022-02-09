package com.NumCo.numberconverter.CipherCreation.CipherFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.NumCo.numberconverter.CipherCreation.Commands;
import com.NumCo.numberconverter.ObjectPainter.Generator;
import com.NumCo.numberconverter.ObjectPainter.Status;
import com.NumCo.numberconverter.R;

public class SettingsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cipher_settings, container, true);
        ImageView imageView = view.findViewById(R.id.imageSettings);

        imageView.setImageBitmap(Generator.generate(Commands.getPlaceholder(Status.PLACEHOLDER.color)));
        return view;
    }
}