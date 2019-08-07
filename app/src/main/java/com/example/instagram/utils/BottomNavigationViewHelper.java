package com.example.instagram.utils;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.instagram.R;
import com.example.instagram.favourites.FavouritesActivity;
import com.example.instagram.home.HomeActivity;
import com.example.instagram.profile.ProfileActivity;
import com.example.instagram.search.SearchActivity;
import com.example.instagram.share.ShareActivity;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationHelper";


    @BindingAdapter("onNavigationItemSelected")
    public static void setOnNavigationItemSelected(BottomNavigationView view, final Context context) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        Log.d("test", "test1");
                        intent = new Intent(context, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent);
                        return true;
                    case R.id.ic_search:
                        Log.d("test", "test2");
                        intent = new Intent(context, SearchActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent);
                        return true;
                    case R.id.ic_add:
                        Log.d("test", "test3");
                        intent = new Intent(context, ShareActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent);
                        return true;
                    case R.id.ic_fav:
                        Log.d("test", "test4");
                        intent = new Intent(context, FavouritesActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent);
                        return true;
                    case R.id.ic_profile:
                        Log.d("test", "test5");
                        intent = new Intent(context, ProfileActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent);
                        return true;
                }
                return false;
            }

        });

    }

}
