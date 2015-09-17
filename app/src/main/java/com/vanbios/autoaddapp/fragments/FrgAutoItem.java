package com.vanbios.autoaddapp.fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vanbios.autoaddapp.R;

import org.w3c.dom.Text;

/**
 * Created by Ihor Bilous on 11.09.2015.
 */
public class FrgAutoItem extends Fragment {

    private View view;
    private static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    private int pageNumber;
    private TypedArray imageArray;
    private String[] titles, priceMcad, priceOutMcad;
    private Typeface tfHelveticaBold, tfHelveticaLight, tfHelveticaMedium;


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
        priceMcad = getResources().getStringArray(R.array.auto_price_mcad_string_array);
        priceOutMcad = getResources().getStringArray(R.array.auto_price_out_mcad_string_array);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_auto_item, container, false);

        ImageView ivAuto = (ImageView) view.findViewById(R.id.ivAutoItemImage);
        ivAuto.setImageDrawable(imageArray.getDrawable(pageNumber));

        TextView tvTitle = (TextView) view.findViewById(R.id.tvAutoItemName);
        tvTitle.setText(titles[pageNumber]);
        tvTitle.setTypeface(tfHelveticaLight);

        TextView tvPriceMcad = (TextView) view.findViewById(R.id.tvAutoItemPriceMCAD);
        TextView tvPriceOutMcad = (TextView) view.findViewById(R.id.tvAutoItemPriceOutMCAD);
        tvPriceMcad.setText(priceMcad[pageNumber]);
        tvPriceOutMcad.setText(priceOutMcad[pageNumber]);
        tvPriceMcad.setTypeface(tfHelveticaMedium);
        tvPriceOutMcad.setTypeface(tfHelveticaMedium);

        TextView tvMcadName = (TextView) view.findViewById(R.id.tvAutoItemMCADName);
        TextView tvOutMcadName = (TextView) view.findViewById(R.id.tvAutoItemOutMCADName);
        TextView tvMcadPerHour = (TextView) view.findViewById(R.id.tvAutoItemMCADPerHour);
        TextView tvOutMcadPerHour = (TextView) view.findViewById(R.id.tvAutoItemOutMCADPerHour);
        tvMcadName.setTypeface(tfHelveticaLight);
        tvOutMcadName.setTypeface(tfHelveticaLight);
        tvMcadPerHour.setTypeface(tfHelveticaLight);
        tvOutMcadPerHour.setTypeface(tfHelveticaLight);

        TextView tvChoose = (TextView) view.findViewById(R.id.tvAutoItemChoose);
        tvChoose.setTypeface(tfHelveticaLight);

        return view;
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);

        tfHelveticaBold = Typeface.createFromAsset(getActivity().getAssets(), "HelveticaNeueCyr_Bold.ttf");
        tfHelveticaLight = Typeface.createFromAsset(getActivity().getAssets(), "HelveticaNeueCyr_Light.ttf");
        tfHelveticaMedium = Typeface.createFromAsset(getActivity().getAssets(), "HelveticaNeueCyr_Medium.ttf");
    }

}
