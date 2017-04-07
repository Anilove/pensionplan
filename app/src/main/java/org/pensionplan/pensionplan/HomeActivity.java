package org.pensionplan.pensionplan;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import org.pensionplan.pensionplan.Fragments.FragmentDepRequired;
import org.pensionplan.pensionplan.Fragments.FragmentLumpsumReq;
import org.pensionplan.pensionplan.Fragments.FragmentLumpsumWithdrawal;
import org.pensionplan.pensionplan.Fragments.FragmentTrusteeList;

import io.realm.Realm;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_layout);
        setSupportActionBar(toolbar);


        //REALM DATABASE
/*
        Realm realm = Realm.getDefaultInstance();
       // realm.where(User.class).findFirst();

        User user = realm.where(User.class).findFirst();
        User userpin = new User();
        userpin.id = ;
        userpin.email = "editTextmail";
        userpin.name = "editTextname";*/


      /* realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();*/



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();

                if (item.getItemId() == R.id.menu_monthly_dep) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_home, new FragmentDepRequired());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menu_lumpsum_dep) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_home, new FragmentLumpsumReq());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menu_lumpsum_withdrawal) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_home, new FragmentLumpsumWithdrawal());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menu_lumpsum_withdrawal) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_home, new FragmentLumpsumWithdrawal());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menu_trustee_list) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_home, new FragmentTrusteeList());
                    fragmentTransaction.commit();
                }
                else {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_home, new FragmentDepRequired());
                    fragmentTransaction.commit();
                }

                return false;
            }

        });

        // Initializing Drawer Layout and ActionBarToggle
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.getMenu().performIdentifierAction(R.id.menu_monthly_withdrawal, 0);
    }
}
