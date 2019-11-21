package com.example.nasa;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.nasa.ui.dashboard.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        // I want there to be a Fragment in the slot from the start
        Fragment fragment = new DashboardFragment();
        swapFragment(fragment);
        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // menuItem = the item on the bottom nav view that was selected
                // The id's here belong to the items in the menu of the BottomnNavigationView
                // The menu is chunked out as bottom_nav_menu.xml in the res > menu folder
                if (menuItem.getItemId() == R.id.home) {
                    Fragment fragment = new DashboardFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.leaderBoard) {
                    Fragment fragment = new DashboardFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.profile) {
                    Fragment fragment = new DashboardFragment();
//
//                    // Here's just an example of passing information to the Fragment via Bundle
//                    Bundle bundle = new Bundle();
//                    bundle.putString("param1", "First Argument");
//                    bundle.putString("param2", "Second Argument");
//                    fragment.setArguments(bundle);
//                    // End bundle part

                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }

    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }
}
