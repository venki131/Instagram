package com.example.instagram.home;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.instagram.R;
import com.example.instagram.databinding.ActivityHomeBinding;
import com.example.instagram.home.adapter.SectionsPagerAdapter;
import com.example.instagram.home.fragments.CameraFragment;
import com.example.instagram.home.fragments.IgTvFragment;
import com.example.instagram.home.fragments.HomeFragment;
import com.example.instagram.home.fragments.MessageFragment;
import com.example.instagram.utils.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener {
    private static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setUpNavigation();
        setViewPager();
    }

    private void setUpNavigation() {
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation_bar);
        BottomNavigationViewHelper.setOnNavigationItemSelected(navigationView, this);
        Menu menu = navigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void setViewPager() {
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragments(new CameraFragment());
        pagerAdapter.addFragments(new HomeFragment());
        pagerAdapter.addFragments(new MessageFragment());
        /*pagerAdapter.addFragments(CameraFragment.newInstance("",""));
        pagerAdapter.addFragments(HomeFragment.newInstance("",""));
        pagerAdapter.addFragments(IgTvFragment.newInstance("",""));
        pagerAdapter.addFragments(MessageFragment.newInstance("",""));*/
        ViewPager viewPager = findViewById(R.id.view_pager_container);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_photo_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_instagram_logo);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_telegram);


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
