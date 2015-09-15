package com.vanbios.autoaddapp.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vanbios.autoaddapp.R;

/**
 * Created by Ihor Bilous on 11.09.2015.
 */
public class FrgAutoItem extends Fragment {

    private View view;
    private static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    private int pageNumber;
    private TypedArray imageArray;
    private String[] titles;


    public static FrgAutoItem newInstance(int page) {
        FrgAutoItem pageFragment = new FrgAutoItem();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        imageArray = getResources().obtainTypedArray(R.array.auto_image_array);
        titles = getResources().getStringArray(R.array.auto_name_string_array);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_auto_item, container, false);

        ImageView ivAuto = (ImageView) view.findViewById(R.id.ivAutoItemImage);
        ivAuto.setImageDrawable(imageArray.getDrawable(pageNumber));
        TextView tvTitle = (TextView) view.findViewById(R.id.tvAutoItemName);
        tvTitle.setText(titles[pageNumber]);

        return view;
    }

}
