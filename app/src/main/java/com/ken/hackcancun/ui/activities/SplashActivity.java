package com.ken.hackcancun.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ken.hackcancun.R;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.ken.hackcancun.util.Constants;
import com.ken.hackcancun.util.Util;

public class SplashActivity extends AppCompatActivity {


    public static final String TAG = SplashActivity.class.toString();

    /**
     * seconds duration of the visible splash
     */
    private int mSeconds = 3;

    /**
     * the second in milliseconds
     */
    private int mMilliseconds = mSeconds * 800;

    /**
     * parameter that will tell if the user is already logged
     */
    private int isUserLogged;


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Set window flags to get full screen
         */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**
         * Enable full screen params
         */
        fullScreenMode();

        setContentView(R.layout.activity_splash);

        /**
         *obtained if the user is logged
         */
        isUserLogged = Util.getSharedPreferenceInt(this, Constants.KEY_PREFERENCES_USER_LOGGED);
//        isUserLogged = 0; //
        /**
         * create countdown to switch activity
         */
        startCount();
    }


    /*
     * Establis default configurations because to reopena application dont apply efects to fullscreen mode
     */
    @Override
    protected void onPause() {
        super.onPause();
        fullScreenMode();
    }

    /**
     * Use immersiveMode for fullscreen
     */
    public void fullScreenMode() {

        /**
         * Get the currrent params
         */
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;


        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }


        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }


        /**
         * Set the new options params for the current screen
         */
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
    }

    /**
     * Method for reduce LogCat jus for information
     *
     * @param content
     */
    public void log(String content) {
        Log.i(TAG, content);
    }


    /**
     * start countdown to change activities
     */
    private void startCount() {
        /**
         * time to dure transition
         */
        new CountDownTimer(mMilliseconds, 800) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            /**
             * Call when count down timer finalice countdown
             */
            @Override
            public void onFinish() {
                if (isUserLogged == Constants.USER_UNLOGGED) {
                    startActivity(new Intent(SplashActivity.this, EntryActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        }.start();
    }


}
