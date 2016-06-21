package com.ken.hackcancun.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.ken.hackcancun.R;
import com.ken.hackcancun.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final Handler mDrawerActionHandler = new Handler();
    @BindView(R.id.drawer)
    public DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle mDrawerToggle;
    //start title drawer
    private int mNavItemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configureNavigationView(savedInstanceState);
    }

    private void configureNavigationView(Bundle savedInstanceState) {

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//            permissionLevel = Util.getSharedPreferenceInt(this, Constants.KEY_PREFERENCES_PERMISSION_LEVEL);

//        TextView tvEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.email);
//        TextView tvName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.username);
        CircleImageView imageProfile = (CircleImageView) navigationView.getHeaderView(0).findViewById(R.id.circle_image);
//        imageProfile.setOnClickListener((view) -> goToProfileActivity());


        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_account:
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.nav_escolar:
                startActivity(new Intent(this, EscolarActivity.class));
                break;
            case R.id.nav_monitoreo:
                startActivity(new Intent(this, ReportesActivity.class));
                break;

        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
