package com.vanbios.autoaddapp.fragments;

import android.content.Context;
import android.graphics.Typeface;
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
    private ImageView[] dotsArray, trianglesArray;
    private TextView[] tvTonnageArray, tvMetricArray;
    private String[] metricValArray;
    private static int activeDotPos = 0, pagePos = 0, tonnagePos = 0;
    private static final float MIN_SCALE = 0.8f, MIN_ALPHA = 0.7f;
    private static final int SDK_VER = android.os.Build.VERSION.SDK_INT;
    private static int tvPadding;
    private Typeface tfHelveticaLight, tfHelveticaMedium;

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
                        pager.setCurrentItem(4);
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
                        pager.setCurrentItem(8);
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

        dotsArray = new ImageView[] {ivDot1,ivDot2,ivDot3,ivDot4,ivDot5,ivDot6,ivDot7,ivDot8,ivDot9,ivDot10};

        TextView tvTonnage1 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage1);
        TextView tvTonnage2 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage2);
        TextView tvTonnage3 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage3);
        TextView tvTonnage4 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage4);
        TextView tvTonnage5 = (TextView) view.findViewById(R.id.tvAutoChooseTypeTonnage5);

        tvPadding = tvTonnage1.getPaddingTop();
        metricValArray = getResources().getStringArray(R.array.auto_types_metric_string_array);

        tvTonnageArray = new TextView[]{tvTonnage1, tvTonnage2, tvTonnage3, tvTonnage4, tvTonnage5};

        for (TextView tv : tvTonnageArray) {
            tv.setOnClickListener(this);
            tv.setTypeface(tfHelveticaMedium);
        }

        TextView tvMetric1 = (TextView) view.findViewById(R.id.tvAutoChooseTypeMetric1);
        TextView tvMetric2 = (TextView) view.findViewById(R.id.tvAutoChooseTypeMetric2);
        TextView tvMetric3 = (TextView) view.findViewById(R.id.tvAutoChooseTypeMetric3);

        tvMetricArray = new TextView[]{tvMetric1, tvMetric2, tvMetric3};

        for (TextView tv : tvMetricArray) {
            tv.setOnClickListener(this);
            tv.setTypeface(tfHelveticaLight);
        }

        TextView tvCancel = (TextView) view.findViewById(R.id.tvAutoChooseCancel);
        tvCancel.setOnClickListener(this);
        tvCancel.setTypeface(tfHelveticaLight);

        ImageView ivTriangle1 = (ImageView) view.findViewById(R.id.ivAutoChooseTriangle1);
        ImageView ivTriangle2 = (ImageView) view.findViewById(R.id.ivAutoChooseTriangle2);
        ImageView ivTriangle3 = (ImageView) view.findViewById(R.id.ivAutoChooseTriangle3);
        ImageView ivTriangle4 = (ImageView) view.findViewById(R.id.ivAutoChooseTriangle4);
        ImageView ivTriangle5 = (ImageView) view.findViewById(R.id.ivAutoChooseTriangle5);

        trianglesArray = new ImageView[]{ivTriangle1, ivTriangle2, ivTriangle3, ivTriangle4, ivTriangle5};
    }

    private void setViewPager() {
        pager = (ViewPager) view.findViewById(R.id.pagerAutoChoose);
        ViewPagerIntroductionAdapter pagerIntroductionAdapter = new ViewPagerIntroductionAdapter(getChildFragmentManager());
        pager.setAdapter(pagerIntroductionAdapter);

        setDotsArray(0);
        setTypeViews(0);

        pager.setClipToPadding(false);

        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                int pageWidth = view.getWidth();
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));

                if (position < 0) {     // [-Infinity, 0)

                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);

                    view.setAlpha(MIN_ALPHA +
                            (scaleFactor - MIN_SCALE) /
                                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));

                } else if (position >= 0 && position <= 1) {    // [0,1]

                    view.setScaleX(1);
                    view.setScaleY(1);
                    view.setAlpha(1);

                } else {     // (1,+Infinity]

                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);

                    view.setAlpha(MIN_ALPHA +
                            (scaleFactor - MIN_SCALE) /
                                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));
                }

                view.setTranslationX(pagePos == 25 ? -pageWidth / 12 : 0f);
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
                metPos = 1;
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
                metPos = 2;
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
                break;
            }
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
        setMetricTVValues(pos <= 13 ? 0 : 1);
    }

    private void setTonnageTVArray(int pos) {
        for (int i = 0; i < tvTonnageArray.length; i++) {
            setTonnageStatus(tvTonnageArray[i], i == pos);
            if (i == pos) setTrianglesArray(i);
        }
    }

    private void setMetricTVArray(int pos) {
        for (int i = 0; i < tvMetricArray.length; i++) {
            setMetricStatus(tvMetricArray[i], i == pos);
        }
    }

    private void setMetricTVValues(int type) {
        for (int i = 0; i < tvMetricArray.length; i++) {
            tvMetricArray[i].setText(type == 0 ? metricValArray[i] : metricValArray[i + 3]);
        }
    }

    private void setTonnageStatus(TextView tv, boolean active) {
        if (SDK_VER < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            tv.setBackgroundDrawable(getResources().getDrawable(active ? R.drawable.rounded_green : R.drawable.rounded_white));
        } else {
            tv.setBackground(ContextCompat.getDrawable(getContext(), active ? R.drawable.rounded_green : R.drawable.rounded_white));
        }
        tv.setTextColor(ContextCompat.getColor(getContext(), active ? R.color.white : R.color.text_gray));
        tv.setPadding(0, tvPadding, 0, tvPadding);
    }

    private void setMetricStatus(TextView tv, boolean active) {
        tv.setTextColor(ContextCompat.getColor(getContext(), active ? R.color.text_green : R.color.text_gray));
    }

    private void setTrianglesArray(int pos) {
        for (int i = 0; i < trianglesArray.length; i++) {
            setTrianglesImageStatus(trianglesArray[i], i == pos);
        }
    }

    private void setTrianglesImageStatus(ImageView imageView, boolean active) {
        imageView.setVisibility(active ? View.VISIBLE : View.INVISIBLE);
    }

    private void setDotsArray(int pos) {
        int act = pos == 0 ? 0 : (int) Math.round((pos + 1) / 2.6) - 1;

        if (act != activeDotPos) {
            activeDotPos = act;
            for (int i = 0; i < dotsArray.length; i++) {
                setDotImageStatus(dotsArray[i], i == act);
            }
        }
    }

    private void setDotImageStatus(ImageView imageView, boolean active) {
        imageView.setImageResource(active ? R.drawable.indicator_dot_white : R.drawable.indicator_dot_gray);
    }

    @Override
    public String getTitle() {
        return FrgAutoItem.class.getName();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        tfHelveticaLight = Typeface.createFromAsset(getActivity().getAssets(), "HelveticaNeueCyr_Light.ttf");
        tfHelveticaMedium = Typeface.createFromAsset(getActivity().getAssets(), "HelveticaNeueCyr_Medium.ttf");
    }
}
