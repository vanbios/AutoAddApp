package com.vanbios.autoaddapp.fragments;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vanbios.autoaddapp.R;
import com.vanbios.autoaddapp.adapters.ViewPagerIntroductionAdapter;

/**
 * Created by Ihor Bilous on 11.09.2015.
 */
public class FrgAutoChoose extends CommonFragment implements View.OnClickListener {

    private View view;
    private ViewPager pager;
    private ImageView[] dotsArray;
    private TextView[] tvTonnageArray, tvMetricArray;
    private String[] metricValArray;
    private static int activeDotPos = 0, pagePos = 0, tonnagePos = 0;
    private static final float MIN_SCALE = 0.8f;
    private static final float MIN_ALPHA = 0.7f;
    private static final int SDK_VER = android.os.Build.VERSION.SDK_INT;
    private static int tvPadding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_auto_choose, container, false);
        initViews();
        setViewPager();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvAutoChooseTypeTonnage1: {
                pager.setCurrentItem(0);
                break;
            }
            case R.id.tvAutoChooseTypeTonnage2: {
                pager.setCurrentItem(14);
                break;
            }
            case R.id.tvAutoChooseTypeTonnage3: {
                pager.setCurrentItem(17);
                break;
            }
            case R.id.tvAutoChooseTypeTonnage4: {
                pager.setCurrentItem(20);
                break;
            }
            case R.id.tvAutoChooseTypeTonnage5: {
                pager.setCurrentItem(23);
                break;
            }

            case R.id.tvAutoChooseTypeMetric1: {
                switch (tonnagePos) {
                    case 0: {
                        pager.setCurrentItem(0);
                        break;
                    }
                    case 1: {
                        pager.setCurrentItem(14);
                        break;
                    }
                    case 2: {
                        pager.setCurrentItem(17);
                        break;
                    }
                    case 3: {
                        pager.setCurrentItem(20);
                        break;
                    }
                    case 4: {
                        pager.setCurrentItem(23);
                        break;
                    }
                }
                break;
            }
            case R.id.tvAutoChooseTypeMetric2: {
                switch (tonnagePos) {
                    case 0: {
                        pager.setCurrentItem(5);
                        break;
                    }
                    case 1: {
                        pager.setCurrentItem(15);
                        break;
                    }
                    case 2: {
                        pager.setCurrentItem(18);
                        break;
                    }
                    case 3: {
                        pager.setCurrentItem(21);
                        break;
                    }
                    case 4: {
                        pager.setCurrentItem(24);
                        break;
                    }
                }
                break;
            }
            case R.id.tvAutoChooseTypeMetric3: {
                switch (tonnagePos) {
                    case 0: {
                        pager.setCurrentItem(10);
                        break;
                    }
                    case 1: {
                        pager.setCurrentItem(16);
                        break;
                    }
                    case 2: {
                        pager.setCurrentItem(19);
                        break;
                    }
                    case 3: {
                        pager.setCurrentItem(22);
                        break;
                    }
                    case 4: {
                        pager.setCurrentItem(25);
                        break;
                    }
                }
                break;
            }

            case R.id.tvAutoChooseCancel: {
                popFragment();
            }
        }
    }

    private void initViews() {
        ImageView ivDot1 = (ImageView) view.findViewById(R.id.ivAutoChooseDot1);
        ImageView ivDot2 = (ImageView) view.findViewById(R.id.ivAutoChooseDot2);
        ImageView ivDot3 = (ImageView) view.findViewById(R.id.ivAutoChooseDot3);
        ImageView ivDot4 = (ImageView) view.findViewById(R.id.ivAutoChooseDot4);
        ImageView ivDot5 = (ImageView) view.findViewById(R.id.ivAutoChooseDot5);
        ImageView ivDot6 = (ImageView) view.findViewById(R.id.ivAutoChooseDot6);
        ImageView ivDot7 = (ImageView) view.findViewById(R.id.ivAutoChooseDot7);
        ImageView ivDot8 = (ImageView) view.findViewById(R.id.ivAutoChooseDot8);
        ImageView ivDot9 = (ImageView) view.findViewById(R.id.ivAutoChooseDot9);
        ImageView ivDot10 = (ImageView) view.findViewById(R.id.ivAutoChooseDot10);

        dotsArray = new ImageView[10];
        dotsArray[0] = ivDot1;
        dotsArray[1] = ivDot2;
        dotsArray[2] = ivDot3;
        dotsArray[3] = ivDot4;
        dotsArray[4] = ivDot5;
        dotsArray[5] = ivDot6;
        dotsArray[6] = ivDot7;
        dotsArray[7] = ivDot8;
        dotsArray[8] = ivDot9;
        dotsArray[9] = ivDot10;

        TextView tvTonnage1 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage1);
        TextView tvTonnage2 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage2);
        TextView tvTonnage3 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage3);
        TextView tvTonnage4 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage4);
        TextView tvTonnage5 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage5);

        tvPadding = tvTonnage1.getPaddingTop();
        metricValArray = getResources().getStringArray(R.array.auto_types_metric_string_array);

        tvTonnageArray = new TextView[5];
        tvTonnageArray[0] = tvTonnage1;
        tvTonnageArray[1] = tvTonnage2;
        tvTonnageArray[2] = tvTonnage3;
        tvTonnageArray[3] = tvTonnage4;
        tvTonnageArray[4] = tvTonnage5;

        for (TextView tv : tvTonnageArray) {
            tv.setOnClickListener(this);
        }

        TextView tvMetric1 = (TextView) view.findViewById(R.id.tvAutoChooseTypeMetric1);
        TextView tvMetric2 = (TextView) view.findViewById(R.id.tvAutoChooseTypeMetric2);
        TextView tvMetric3 = (TextView) view.findViewById(R.id.tvAutoChooseTypeMetric3);

        tvMetricArray = new TextView[3];
        tvMetricArray[0] = tvMetric1;
        tvMetricArray[1] = tvMetric2;
        tvMetricArray[2] = tvMetric3;

        for (TextView tv : tvMetricArray) {
            tv.setOnClickListener(this);
        }

        TextView tvCancel = (TextView) view.findViewById(R.id.tvAutoChooseCancel);
        tvCancel.setOnClickListener(this);
    }

    private void setViewPager() {
        pager = (ViewPager) view.findViewById(R.id.pagerAutoChoose);
        ViewPagerIntroductionAdapter pagerIntroductionAdapter = new ViewPagerIntroductionAdapter(getFragmentManager());
        pager.setAdapter(pagerIntroductionAdapter);

        setDotsArray(0);
        setTypeViews(0);

        pager.setClipToPadding(false);
        //pager.setPageMargin(4);

        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                //int pageWidth = view.getWidth();
                //int pageHeight = view.getHeight();
                //float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                //float horzMargin = pageWidth * (1 - scaleFactor) / 2;

                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));

                if (position <= 1 && position > 0) { // (0,1]
                    // Modify the default slide transition to shrink the page as well

                    /*if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }*/

                    view.setScaleX(1);
                    view.setScaleY(1);
                    view.setAlpha(1);

                } else { // [-Infinity, 0] && (1,+Infinity]
                    // This page is way off-screen to the left and right.
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);

                    view.setAlpha(MIN_ALPHA +
                            (scaleFactor - MIN_SCALE) /
                                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));
                }
            }
        });

        pager.setOffscreenPageLimit(3);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setDotsArray(position);
                setTypeViews(position);
                pagePos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setTypeViews(int pos) {
        int tonPos = 0, metPos = 0;
        switch (pos + 1) {
            case 1: {
                tonPos = 0;
                metPos = 0;
                break;
            }
            case 2: {
                tonPos = 0;
                metPos = 0;
                break;
            }
            case 3: {
                tonPos = 0;
                metPos = 0;
                break;
            }
            case 4: {
                tonPos = 0;
                metPos = 0;
                break;
            }
            case 5: {
                tonPos = 0;
                metPos = 2;
                break;
            }
            case 6: {
                tonPos = 0;
                metPos = 1;
                break;
            }
            case 7: {
                tonPos = 0;
                metPos = 1;
                break;
            }
            case 8: {
                tonPos = 0;
                metPos = 1;
                break;
            }
            case 9: {
                tonPos = 0;
                metPos = 1;
                break;
            }
            case 10: {
                tonPos = 0;
                metPos = 2;
                break;
            }
            case 11: {
                tonPos = 0;
                metPos = 2;
                break;
            }
            case 12: {
                tonPos = 0;
                metPos = 2;
                break;
            }
            case 13: {
                tonPos = 0;
                metPos = 2;
                break;
            }
            case 14: {
                tonPos = 0;
                metPos = 2;
                break;
            }
            case 15: {
                tonPos = 1;
                metPos = 0;
                break;}
            case 16: {
                tonPos = 1;
                metPos = 1;
                break;
            }
            case 17: {
                tonPos = 1;
                metPos = 2;
                break;
            }
            case 18: {
                tonPos = 2;
                metPos = 0;
                break;
            }
            case 19: {
                tonPos = 2;
                metPos = 1;
                break;
            }
            case 20: {
                tonPos = 2;
                metPos = 2;
                break;
            }
            case 21: {
                tonPos = 3;
                metPos = 0;
                break;
            }
            case 22: {
                tonPos = 3;
                metPos = 1;
                break;
            }
            case 23: {
                tonPos = 3;
                metPos = 2;
                break;
            }
            case 24: {
                tonPos = 4;
                metPos = 0;
                break;
            }
            case 25: {
                tonPos = 4;
                metPos = 1;
                break;
            }
            case 26: {
                tonPos = 4;
                metPos = 2;
                break;
            }
        }

        setTonnageTVArray(tonPos);
        setMetricTVArray(metPos);
        tonnagePos = tonPos;
        if (pos <= 13) {
            setMetricTVValues(0);
        }
        else {
            setMetricTVValues(1);
        }
    }

    private void setTonnageTVArray(int pos) {
        for (int i = 0; i < tvTonnageArray.length; i++) {
            if (i == pos) {
                setTonnageStatus(tvTonnageArray[i], true);
            }
            else {
                setTonnageStatus(tvTonnageArray[i], false);
            }
        }
    }

    private void setMetricTVArray(int pos) {
        for (int i = 0; i < tvMetricArray.length; i++) {
            if (i == pos) {
                setMetricStatus(tvMetricArray[i], true);
            }
            else {
                setMetricStatus(tvMetricArray[i], false);
            }
        }
    }

    private void setMetricTVValues(int type) {
        if (type == 0) {
            for (int i = 0; i < tvMetricArray.length; i++) {
                tvMetricArray[i].setText(metricValArray[i]);
            }
        }
        else {
            for (int i = 0; i < tvMetricArray.length; i++) {
                tvMetricArray[i].setText(metricValArray[i+3]);
            }
        }
    }

    private void setTonnageStatus(TextView tv, boolean active) {
        if (active) {
            if (SDK_VER < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                tv.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_green));
            }
            else {
                tv.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.rounded_green));
            }
            tv.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        }
        else {
            if (SDK_VER < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                tv.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_white));
            }
            else {
                tv.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.rounded_white));
            }
            tv.setTextColor(ContextCompat.getColor(getContext(), R.color.custom_text_gray));
        }
        tv.setPadding(0, tvPadding, 0, tvPadding);
    }

    private void setMetricStatus(TextView tv, boolean active) {
        if (active) {
            tv.setTextColor(ContextCompat.getColor(getContext(), R.color.custom_text_green));
        }
        else {
            tv.setTextColor(ContextCompat.getColor(getContext(), R.color.custom_text_gray));
        }
    }

    private void setDotsArray(int pos) {
        int act;
        if (pos == 0) {
            act = 0;
        }
        else {
            act = (int) Math.round((pos + 1) / 2.6) - 1;
        }

        if (act != activeDotPos) {
            activeDotPos = act;

            for (int i = 0; i < dotsArray.length; i++) {
                if (i == act) {
                    setDotImageStatus(dotsArray[i], true);
                }
                else {
                    setDotImageStatus(dotsArray[i], false);
                }
            }
        }
    }

    private void setDotImageStatus(ImageView imageView, boolean active) {
        if (active) {
            imageView.setImageResource(R.drawable.indicator_dot_white);
        }
        else {
            imageView.setImageResource(R.drawable.indicator_dot_gray);
        }
    }

    @Override
    public String getTitle() {
        return FrgAutoItem.class.getName();
    }
}
