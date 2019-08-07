package com.example.instagram.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.instagram.R;
import com.example.instagram.databinding.ActivityHomeBinding;
import com.example.instagram.utils.BottomNavigationViewHelper;

public class SearchActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        setUpNavigation();
    }

    private void setUpNavigation() {
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation_bar);
        BottomNavigationViewHelper.setOnNavigationItemSelected(navigationView, this);
        Menu menu = navigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
