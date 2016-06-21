package com.ken.hackcancun.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;


import com.ken.hackcancun.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EntryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        hideKeyboard();
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button_enter)
    public void enter() {
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * hide keyBoard from activity
     */
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);

    }


}
