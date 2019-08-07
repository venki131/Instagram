package com.example.instagram.profile;

import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.instagram.R;
import com.example.instagram.databinding.ActivityHomeBinding;
import com.example.instagram.utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_profile);
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
