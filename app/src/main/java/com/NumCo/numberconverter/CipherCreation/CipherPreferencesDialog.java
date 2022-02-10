package com.NumCo.numberconverter.CipherCreation;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;

import com.example.numberconverter.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class CipherPreferencesDialog extends Dialog {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private MaterialButton saveButton;
    private CipherDialogFragmentAdapter cipherDialogFragmentAdapter;
    private volatile boolean isFirst = true;

    protected CipherObjectBitmaps cipherObjectBitmaps;

    private final FragmentManager fragmentManager;
    private final Lifecycle lifecycle;

    public CipherPreferencesDialog(CipherObjectBitmaps cipherObjectBitmaps, Context context, FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(context);
        this.cipherObjectBitmaps = cipherObjectBitmaps;
        this.fragmentManager = fragmentManager;
        this.lifecycle = lifecycle;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.cipher_dialog_layout);

        cipherDialogFragmentAdapter = new CipherDialogFragmentAdapter(fragmentManager, lifecycle, new ArrayList<>());

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.help));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.settings));

        MaterialButton backButton = findViewById(R.id.closeCipherPreferencesDialog);
        backButton.setText(R.string.back);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setText(R.string.save);

        cipherDialogFragmentAdapter.addCipherDialogFragment(new CipherHelpFragment(cipherObjectBitmaps));
        cipherDialogFragmentAdapter.addCipherDialogFragment(new CipherSettingsFragment());

        viewPager.setAdapter(cipherDialogFragmentAdapter);

        getWindow().setBackgroundDrawableResource(R.drawable.transparent_dialog_inset_10_30);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;

        getWindow().setAttributes(params);

        if (isFirst)
            getWindow().getDecorView().setAlpha(0f);

        backButton.setOnClickListener(v -> dismiss());
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
                    viewPager.post(() -> {
                        int maxMeasuredHeight = viewPager.getMeasuredHeight();

                        for (int i = 1; i < cipherDialogFragmentAdapter.getItemCount(); i++) {
                            Fragment fragment = cipherDialogFragmentAdapter.getCipherDialogFragments().get(i);
                            if (fragment.getView() != null) {
                                fragment.requireView().measure(fragment.requireView().getWidth(), fragment.requireView().getHeight());
                                maxMeasuredHeight = Math.max(maxMeasuredHeight, fragment.requireView().getMeasuredHeight());
                                fragment.requireView().requestLayout();
                            }
                        }

                        viewPager.setMinimumHeight(maxMeasuredHeight);
                        ObjectAnimator.ofFloat(getWindow().getDecorView(), View.ALPHA, 0f, 1f).setDuration(250).start();

                        isFirst = false;
                    });
                }

                tabLayout.selectTab(tabLayout.getTabAt(position));

                if (position == 1) {
                    saveButton.setVisibility(View.VISIBLE);
                } else {
                    saveButton.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        setTabOnSelectedListener();
        registerPagerOnPageChangeCallback();
    }
}
