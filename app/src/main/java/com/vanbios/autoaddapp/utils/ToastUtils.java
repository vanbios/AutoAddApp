package com.vanbios.autoaddapp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Ihor Bilous on 15.09.2015.
 */
public class ToastUtils {

    private static Toast staticToast;


    public static void showClosableToast(Context context, String text, int duration) {

        if (staticToast != null) {
            staticToast.cancel();
        }

        staticToast = new Toast(context);

        switch (duration) {
            case 1: {duration = Toast.LENGTH_SHORT; break;}
            case 2: {duration = Toast.LENGTH_LONG; break;}
        }

        staticToast = Toast.makeText(context, text, duration);
        staticToast.show();
    }

}