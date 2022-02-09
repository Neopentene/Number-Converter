package com.NumCo.numberconverter.CipherCreation;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.example.numberconverter.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class CipherPreferencesDialog extends DialogFragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private MaterialButton backButton;
    private CipherDialogFragmentAdapter cipherDialogFragmentAdapter;
    private boolean isFirst = true;
    private View root;

    private CipherObjectBitmaps cipherObjectBitmaps;

    public CipherPreferencesDialog(CipherObjectBitmaps cipherObjectBitmaps){
        this.cipherObjectBitmaps = cipherObjectBitmaps;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.cipher_dialog_layout, container, false);
        cipherDialogFragmentAdapter = new CipherDialogFragmentAdapter(requireActivity(), new ArrayList<>());

        cipherDialogFragmentAdapter.addCipherDialogFragment(new CipherHelpFragment(cipherObjectBitmaps));
        cipherDialogFragmentAdapter.addCipherDialogFragment(new CipherSettingsFragment());

        tabLayout = root.findViewById(R.id.tabLayout);
        viewPager = root.findViewById(R.id.viewPager);

        backButton = root.findViewById(R.id.closeCipherPreferencesDialog);
        backButton.setText(R.string.back);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.help));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.settings));

        viewPager.setAdapter(cipherDialogFragmentAdapter);
        viewPager.setOffscreenPageLimit(cipherDialogFragmentAdapter.getCipherDialogFragments().size());

        Objects.requireNonNull(getDialog()).getWindow().setBackgroundDrawableResource(R.drawable.transparent_dialog_inset_15_35);

        if (isFirst)
            root.setAlpha(0f);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Dialog dialog = getDialog();

        if (dialog != null) {
            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;

            dialog.getWindow().setAttributes(params);
        }

        setTabOnSelectedListener();
        registerPagerOnPageChangeCallback();

        backButton.setOnClickListener(v -> {
            dismiss();
        });
    }

    public void setTabOnSelectedListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void registerPagerOnPageChangeCallback() {
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                if (isFirst) {
                    int maxMeasuredHeight = viewPager.getMeasuredHeight();

                    for (Fragment fragment : cipherDialogFragmentAdapter.getCipherDialogFragments()) {
                        if (fragment.getView() != null) {
                            fragment.requireView().measure(fragment.requireView().getWidth(), fragment.requireView().getHeight());
                            maxMeasuredHeight = Math.max(maxMeasuredHeight, fragment.requireView().getMeasuredHeight());
                            fragment.requireView().requestLayout();
                        }
                    }

                    int finalMaxMeasuredHeight = maxMeasuredHeight;
                    viewPager.post(() -> {
                        viewPager.setMinimumHeight(finalMaxMeasuredHeight);
                        ObjectAnimator.ofFloat(root, View.ALPHA, 0f, 1f).setDuration(150).start();
                    });

                    isFirst = false;
                }

                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}
