package com.naeem.campusfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.os.Bundle;
import android.sax.RootElement;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.naeem.campusfinal.ui.activity.ActivityFragment;
import com.naeem.campusfinal.ui.home.HomeFragment;
import com.naeem.campusfinal.ui.newproject.NewProjectFragment;
import com.naeem.campusfinal.ui.profile.ProfileFragment;
import com.naeem.campusfinal.ui.search.SearchFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
//Hello Naeem brother

    private NavigationView navigationView;
    private DrawerLayout drawerLayout ;
    private ActionBarDrawerToggle toggle;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.dashboard_item);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public void onBackPressed() {


        if (bottomNavigationView.getSelectedItemId() == R.id.navigation_home) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit?");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dashboard_share:
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dashboard_rate_us:
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dashboard_about_us:
                Toast.makeText(this, "newproject", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dashboard_privacy:
                Toast.makeText(this, "activity", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dashboard_term:
                Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}