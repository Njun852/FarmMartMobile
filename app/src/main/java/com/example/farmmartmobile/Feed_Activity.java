package com.example.farmmartmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.farmmartmobile.viewmodel.UserViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Feed_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_feed);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, user ->{
            if(user != null) {
            }else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true).add(R.id.fragment_contaienr, HomeFragment.class, null)
                    .commit();
        }
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if(item.getItemId() == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            }else if(item.getItemId() == R.id.nav_settings) {
                selectedFragment = new SettingsFragment();
            }
            if(selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_contaienr, selectedFragment)
                        .commit();
            }
            return true;
        });

    }
}