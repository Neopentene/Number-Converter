package com.NumCo.numberconverter.CipherCreation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.NumCo.numberconverter.ConversionList;
import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.ObjectBitmapStatus;
import com.example.numberconverter.R;

import java.util.ArrayList;

public class CipherHelpFragment extends Fragment {
    private final ConversionList conversionList = new ConversionList();
    private final CipherObjectBitmaps cipherObjectBitmaps;

    public CipherHelpFragment(CipherObjectBitmaps cipherObjectBitmaps) {
        this.cipherObjectBitmaps = cipherObjectBitmaps;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cipher_help, container, false);
        ListView listView = view.findViewById(R.id.cipherHelpFirstListView);

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("saved-options", Context.MODE_PRIVATE);
        String selectedOutput = sharedPreferences.getString("output", "HEX");
        String selectedInput = sharedPreferences.getString("input", "DEC");

        ArrayList<BitmapObject> objects = new ArrayList<>();

        if (!selectedInput.equals(selectedOutput)) {
            objects.add(cipherObjectBitmaps.constantObjects.get(selectedInput));
            objects.get(0).setBitmapStatus(ObjectBitmapStatus.ACTIVE_INPUT);

            objects.add(cipherObjectBitmaps.constantObjects.get(selectedOutput));
            objects.get(1).setBitmapStatus(ObjectBitmapStatus.ACTIVE_OUTPUT);

        } else {
            objects.add(cipherObjectBitmaps.constantObjects.get(selectedOutput));
            objects.get(0).setBitmapStatus(ObjectBitmapStatus.ERROR);
        }

        for (String string : conversionList.allConversionOptions) {
            if (!string.equals(selectedOutput) && !string.equals(selectedInput))
                objects.add(cipherObjectBitmaps.constantObjects.get(string));
        }

        listView.setAdapter(new ConstantObjectAdapter(requireActivity(), objects));

        return view;
    }
}