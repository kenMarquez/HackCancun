package com.ken.hackcancun.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ken.hackcancun.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecomendacionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendaciones);
        ButterKnife.bind(this);
    }


}
