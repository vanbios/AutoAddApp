package com.vanbios.autoaddapp.adapters;

/**
 * Created by Ihor Bilous on 11.09.2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vanbios.autoaddapp.fragments.FrgAutoItem;

public class ViewPagerIntroductionAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 26;

    public ViewPagerIntroductionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FrgAutoItem.newInstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.93f;
    }

}