package com.example.tanapon.computerproject1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tvHeaderName;
    SharedPreferences sharedPref;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = 3;
                BillFragment billFragment = new BillFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame, billFragment).commit();
                Snackbar.make(view, "ท่านต้องการชำระเงิน", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int defaultValue = 0;
        long highScore = sharedPref.getInt("saved_high_score", defaultValue);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        tvHeaderName = (TextView) headerView.findViewById(R.id.text_table);
        tvHeaderName.setText("Table " + String.valueOf(highScore));

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_frame, homeFragment).commit();

//        View navHeaderView = navigationView.inflateHeaderView(R.layout.main_nav_header);
//        tvHeaderName = (TextView) navHeaderView.findViewById(R.id.text_table);
//        tvHeaderName.setText("Saly");
//        tvHeaderName.setText("Saly");

        //tabBar
        initCollapsingToolbar();

        try {
            Glide.with(this).load(R.drawable.logo_shop).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    if (x == 0) {
                        collapsingToolbar.setTitle(getString(R.string.home));
                        isShow = true;
                    } else if (x == 1) {
                        collapsingToolbar.setTitle(getString(R.string.product));
                        isShow = true;
                    } else if (x == 2) {
                        collapsingToolbar.setTitle(getString(R.string.service));
                        isShow = true;
                    } else if (x == 3) {
                        collapsingToolbar.setTitle(getString(R.string.bill));
                        isShow = true;
                    }
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {

            HomeFragment homeFragment = new HomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_frame, homeFragment).commit();
            x = 0;
            Toast.makeText(this, "หน้าหลัก", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.product) {
            ProductFragment productFragment = new ProductFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_frame, productFragment).commit();
            x = 1;
            Toast.makeText(this, "เมนูอาหาร", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.service) {
            ServiceFragment serviceFragment = new ServiceFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_frame, serviceFragment).commit();
            x = 2;
            Toast.makeText(this, "บริการ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.bill) {
            BillFragment billFragment = new BillFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_frame, billFragment).commit();
            x = 3;
            Toast.makeText(this, "ชำระเงิน", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.login) {
            startActivity(new Intent(this, Login.class));
            Toast.makeText(this, "ออกจากระบบ", Toast.LENGTH_SHORT).show();
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

