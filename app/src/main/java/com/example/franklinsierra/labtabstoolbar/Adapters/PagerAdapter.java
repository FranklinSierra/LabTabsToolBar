package com.example.franklinsierra.labtabstoolbar.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.franklinsierra.labtabstoolbar.Fragments.FormFragment;
import com.example.franklinsierra.labtabstoolbar.Fragments.ListFragment;

import static com.example.franklinsierra.labtabstoolbar.Activities.MainActivity.formFragment;
import static com.example.franklinsierra.labtabstoolbar.Activities.MainActivity.listFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    //atributos
    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case formFragment:
                return new FormFragment();
            case listFragment:
                return new ListFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
