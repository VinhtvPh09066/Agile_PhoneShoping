package com.example.agile_phoneshoping.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.fragment.CartFragment;
import com.example.agile_phoneshoping.fragment.HomeFragment;
import com.example.agile_phoneshoping.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    int badgeCount = 16;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNAV);

        // Bind icon badge with icon cart
        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(1); // number of menu from left
        new QBadgeView(this)
                .bindTarget(v) // bind to view
                .setBadgeGravity(Gravity.START | Gravity.CENTER) // gravity of badge
                .setGravityOffset(30, true)
                .setShowShadow(true)
                .setBadgeNumber(badgeCount); // number count

        // set default is Home fragment
        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new HomeFragment())
                    .commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.cart:
                        fragment = new CartFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit();

                return true;
            }
        });



    }

}
