package com.ken.hackcancun.ui.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.ken.hackcancun.R;
import com.ken.hackcancun.util.Constants;
import com.ken.hackcancun.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultadoActivity extends AppCompatActivity {

    private int resultado;

    @BindView(R.id.cuadro1)
    View cuadro1;

    @BindView(R.id.cuadro2)
    View cuadro2;

    @BindView(R.id.cuadro3)
    View cuadro3;

    @BindView(R.id.recomendaciones)
    View recomendaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        ButterKnife.bind(this);
        resultado = Util.getSharedPreferenceInt(this, Constants.KEY_PREFERENCES_COUNT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Salud");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (resultado == 0 || resultado == 1) {
            cuadro1.setBackgroundResource(R.color.colorAccent);
        } else if (resultado == 2) {
            cuadro2.setBackgroundResource(R.color.colorAccent);
        } else {
            cuadro3.setBackgroundResource(R.color.colorPrimaryDark);
            recomendaciones.setVisibility(View.GONE);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    public void log(String count) {
        Log.i("myLog", count);
    }


}
