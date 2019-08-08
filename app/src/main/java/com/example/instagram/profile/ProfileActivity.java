package com.example.instagram.profile;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.instagram.R;
import com.example.instagram.databinding.ActivityProfileBinding;
import com.example.instagram.utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {

    private MyHandlers handlers;
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        setUpNavigation();
        setUpToolBar();
        handlers = new MyHandlers();
        binding.topProfile.setMyHandlers(handlers);
    }

    private void setUpNavigation() {
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation_bar);
        BottomNavigationViewHelper.setOnNavigationItemSelected(navigationView, this);
        Menu menu = navigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile_menu:
                        Log.d(TAG, "onMenuItemClick: clicked");
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    public class MyHandlers {
        public void onClickEditProfile(View view) {
            Log.d(TAG, "onClickEditProfile: clicked");
            EditProfileFragment editProfileFragment = new EditProfileFragment();
        }
        
        public void onFabClicked(View view) {
            Log.d(TAG, "onFabClicked: clicked");
        }
    }
}
