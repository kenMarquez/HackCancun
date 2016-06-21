package com.ken.hackcancun.ui.activities;

import android.content.Intent;
import android.net.Uri;
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

    @OnClick(R.id.games)
    public void games() {
        String url = "http://www.aventurasmax.com.mx/?gclid=CjwKEAjwy6O7BRDzm-Tdub6ZiSASJADPNzYrUaWBwu2t0tOqHveNEjsEqAkunlGETsMKxZ_pkL9knhoCL-_w_wcB&gclsrc=aw.ds";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


}
