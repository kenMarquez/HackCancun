package com.ken.hackcancun.util;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Ken on 20/06/16.
 */
public class Util {

    /**
     * @param context
     * @param key
     * @return
     */
    public static int getSharedPreferenceInt(Activity context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.PREFERENCES_NAME, context.MODE_PRIVATE);
        return preferences.getInt(key, Constants.USER_UNLOGGED);
    }

}
