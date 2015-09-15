package com.vanbios.autoaddapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vanbios.autoaddapp.R;

/**
 * Created by Ihor Bilous on 15.09.2015.
 */
public class FrgBackground extends CommonFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_background, container, false);
    }

    @Override
    public String getTitle() {
        return FrgBackground.class.getName();
    }
}
