package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myfinalproject.fragment.lastFragment;
import com.example.myfinalproject.fragment.nextFragment;
import com.example.myfinalproject.fragment.onbordingF;

import java.util.List;

public class ViewAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public ViewAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
        super(fm);

        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragments.get(position) ;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
