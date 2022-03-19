package com.NumCo.numberconverter.CipherCreation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class CipherDialogFragmentAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> cipherDialogFragments;

    public CipherDialogFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> cipherDialogFragments) {
        super(fragmentManager, lifecycle);
        this.cipherDialogFragments = cipherDialogFragments;
    }

    public CipherDialogFragmentAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> cipherDialogFragments) {
        super(fragmentActivity);
        this.cipherDialogFragments = cipherDialogFragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return cipherDialogFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return cipherDialogFragments.size();
    }

    public void addCipherDialogFragment(Fragment dialogFragment) {
        cipherDialogFragments.add(dialogFragment);
    }

    public void setCipherDialogFragments(ArrayList<Fragment> cipherDialogFragments) {
        this.cipherDialogFragments = cipherDialogFragments;
    }

    public ArrayList<Fragment> getCipherDialogFragments() {
        return cipherDialogFragments;
    }
}
