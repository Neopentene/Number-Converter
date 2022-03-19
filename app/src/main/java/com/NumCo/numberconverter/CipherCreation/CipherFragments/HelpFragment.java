package com.NumCo.numberconverter.CipherCreation.CipherFragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.NumCo.numberconverter.CipherCreation.CipherAdapters.HelpListAdapter;
import com.NumCo.numberconverter.CipherCreation.Commands;
import com.NumCo.numberconverter.CipherCreation.Store;
import com.NumCo.numberconverter.ObjectPainter.Status;
import com.NumCo.numberconverter.R;

import java.util.ArrayList;

public class HelpFragment extends Fragment {
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cipher_help, container, false);
        listView = view.findViewById(R.id.cipherHelpFirstListView);

        listView.setAdapter(getAdapter(requireActivity()));

        return view;
    }

    private HelpListAdapter getAdapter(FragmentActivity activity) {

        SharedPreferences sharedPreferences = activity.getSharedPreferences("saved-options", Context.MODE_PRIVATE);
        String selectedOutput = sharedPreferences.getString("output", "HEX");
        String selectedInput = sharedPreferences.getString("input", "DEC");

        ArrayList<Store.ImageGenerator> imageData = new ArrayList<>();

        if (!selectedInput.equals(selectedOutput)) {
            imageData.add(new Store.ImageGenerator(selectedInput,
                    Commands.getHelpImageCommands(selectedInput, Status.INPUT.color), Status.INPUT));

            imageData.add(new Store.ImageGenerator(selectedOutput,
                    Commands.getHelpImageCommands(selectedOutput, Status.OUTPUT.color), Status.OUTPUT));

        } else {
            imageData.add(new Store.ImageGenerator(selectedInput,
                    Commands.getHelpImageCommands(selectedInput, Status.ERROR.color), Status.ERROR));
        }

        for (String id : Commands.helpImageIds) {
            if (!id.equals(selectedOutput) && !id.equals(selectedInput)) {
                Status status = id.equals("CIPHER") ? Status.NORMAL : Status.DISABLED;

                imageData.add(new Store.ImageGenerator(id,
                        Commands.getHelpImageCommands(id, status.color), status));
            }
        }

        return new HelpListAdapter(activity, imageData);
    }
}