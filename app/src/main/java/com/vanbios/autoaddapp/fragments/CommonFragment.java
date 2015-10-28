package com.vanbios.autoaddapp.fragments;

/**
 * Created by Ihor Bilous on 11.09.2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.vanbios.autoaddapp.MainActivity;

import java.util.LinkedList;

public abstract class CommonFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    protected void popFragment() {
        getFragmentManager().popBackStack();
    }

    public abstract String getTitle();

}