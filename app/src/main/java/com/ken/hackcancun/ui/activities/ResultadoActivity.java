package com.ken.hackcancun.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ken.hackcancun.R;
import com.ken.hackcancun.util.Constants;
import com.ken.hackcancun.util.Util;

public class ResultadoActivity extends AppCompatActivity {

    private int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        resultado = Util.getSharedPreferenceInt(this, Constants.KEY_PREFERENCES_COUNT);

    }

    public void log(String count) {
        Log.i("myLog", count);
    }


}
