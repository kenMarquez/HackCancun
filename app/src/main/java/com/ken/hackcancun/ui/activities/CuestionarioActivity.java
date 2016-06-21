package com.ken.hackcancun.ui.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ken.hackcancun.R;
import com.ken.hackcancun.util.Constants;
import com.ken.hackcancun.util.Util;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;


public class CuestionarioActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.pregunta_check_si)
    CheckBox checkBoxSi1;

    @BindView(R.id.pregunta_check_no)
    CheckBox checkBoxNo1;

    @BindView(R.id.pregunta_check_si1)
    CheckBox checkBoxSi2;

    @BindView(R.id.pregunta_check_no1)
    CheckBox checkBoxNo2;

    @BindView(R.id.pregunta_check_si3)
    CheckBox checkBoxSi3;

    @BindView(R.id.pregunta_check_no3)
    CheckBox checkBoxNo3;

    @BindView(R.id.pregunta_check_si4)
    CheckBox checkBoxSi4;

    @BindView(R.id.pregunta_check_no4)
    CheckBox checkBoxNo4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Aprendizaje");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        checkBoxNo1.setOnCheckedChangeListener(this);
        checkBoxSi1.setOnCheckedChangeListener(this);
        checkBoxNo2.setOnCheckedChangeListener(this);
        checkBoxSi2.setOnCheckedChangeListener(this);
        checkBoxNo3.setOnCheckedChangeListener(this);
        checkBoxSi3.setOnCheckedChangeListener(this);
        checkBoxNo4.setOnCheckedChangeListener(this);
        checkBoxSi4.setOnCheckedChangeListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            if (compoundButton.getId() == checkBoxNo1.getId() || compoundButton.getId() == checkBoxSi1.getId()) {
                if (compoundButton.getId() == checkBoxNo1.getId()) {
                    checkBoxSi1.setChecked(false);
                } else {
                    checkBoxNo1.setChecked(false);
                }
            }

            if (compoundButton.getId() == checkBoxNo2.getId() || compoundButton.getId() == checkBoxSi2.getId()) {
                if (compoundButton.getId() == checkBoxNo2.getId()) {
                    checkBoxSi2.setChecked(false);
                } else {
                    checkBoxNo2.setChecked(false);
                }
            }

            if (compoundButton.getId() == checkBoxNo3.getId() || compoundButton.getId() == checkBoxSi3.getId()) {
                if (compoundButton.getId() == checkBoxNo3.getId()) {
                    checkBoxSi3.setChecked(false);
                } else {
                    checkBoxNo3.setChecked(false);
                }
            }

            if (compoundButton.getId() == checkBoxNo4.getId() || compoundButton.getId() == checkBoxSi4.getId()) {
                if (compoundButton.getId() == checkBoxNo4.getId()) {
                    checkBoxSi4.setChecked(false);
                } else {
                    checkBoxNo4.setChecked(false);
                }
            }


        }
    }

    public void log(String content) {
        Log.i("myLog", content);
    }

    private void validate() {
        int count = 0;
        if (checkBoxSi1.isChecked()) {
            count++;
        }
        if (checkBoxSi2.isChecked()) {
            count++;
        }
        if (checkBoxSi3.isChecked()) {
            count++;
        }
        if (checkBoxSi4.isChecked()) {
            count++;
        }
        Util.setSharedPreferenceInt(this, Constants.KEY_PREFERENCES_COUNT, count);
    }

    @Override
    protected void onStop() {
        validate();
        super.onStop();
    }
}
