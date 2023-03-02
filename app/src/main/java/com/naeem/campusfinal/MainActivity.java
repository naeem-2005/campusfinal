package com.naeem.campusfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

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
    private NavigationView navigationView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         drawerLayout=findViewById(R.id.drawer_layout);
         navigationView2=findViewById(R.id.dashboard_item);
         toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
         drawerLayout.addDrawerListener(toggle);
         toggle.syncState();
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         navigationView2.setNavigationItemSelectedListener(this);

        bottomNavigationView=findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                if (id==R.id.navigation_home)
                {
                   loadFrag(new HomeFragment(),false);
                }
                else if(id==R.id.navigation_search)
                {
                    loadFrag(new SearchFragment(),false);
                }
                else if (id==R.id.navigation_activity)
                {
                    loadFrag(new ActivityFragment(),false);
                }
                else if(id==R.id.navigation_profile)
                {
                    loadFrag(new ProfileFragment(),false);
                }
                else
                {
                    loadFrag(new NewProjectFragment(),false);
                }
                return true;

            }


        });

        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

    }

    public void loadFrag(Fragment fragment,boolean flag){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();

        if (flag) {

            ft.add(R.id.frame_layout, fragment);
//            String ROOT_FRAGMENT_TAG = null;
//            fragmentManager.popBackStack(ROOT_FRAGMENT_TAG, fragmentManager.POP_BACK_STACK_INCLUSIVE);
//            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        }
       else {
            ft.replace(R.id.frame_layout, fragment);
//            ft.addToBackStack(null);
        }
        ft.commit();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
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

    @Override
    public void onBackPressed() {

        if (bottomNavigationView.getSelectedItemId() == R.id.navigation_home){
            super.onBackPressed();
            finish();
        }
        else {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
    }
}