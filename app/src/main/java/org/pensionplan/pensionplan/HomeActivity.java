package org.pensionplan.pensionplan;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import org.pensionplan.pensionplan.Fragments.FragMonthlyWithdraw;
import org.pensionplan.pensionplan.Fragments.FragmentDepRequired;
import org.pensionplan.pensionplan.Fragments.FragmentLumpsumReq;
import org.pensionplan.pensionplan.Fragments.FragmentLumpsumWithdrawal;
import org.pensionplan.pensionplan.Fragments.FragmentTrusteeList;

import io.realm.Realm;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_home, new FragmentDepRequired());
        fragmentTransaction.commit();

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_layout);
        navigationView.setNavigationItemSelectedListener(this);



        /*REALM DATABASE

        Realm realm = Realm.getDefaultInstance();
       // realm.where(User.class).findFirst();

        User user = realm.where(User.class).findFirst();
        User userpin = new User();
        //userpin.id ="" ;
        userpin.email = "editTextmail";
        userpin.name = "editTextname";


       realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.menu_monthly_dep) {

            fragmentManager.beginTransaction().replace(R.id.frame_home, new FragmentDepRequired()).commit();

        } else if (id == R.id.menu_lumpsum_dep) {

            fragmentManager.beginTransaction().replace(R.id.frame_home, new FragmentLumpsumReq()).commit();

        } else if (id == R.id.menu_lumpsum_withdrawal) {

            fragmentManager.beginTransaction().replace(R.id.frame_home, new FragmentLumpsumWithdrawal()).commit();

        } else if (id == R.id.menu_monthly_withdrawal) {

            fragmentManager.beginTransaction().replace(R.id.frame_home, new FragMonthlyWithdraw()).commit();

        } else if (id == R.id.menu_trustee_list) {

            fragmentManager.beginTransaction().replace(R.id.frame_home, new FragmentTrusteeList()).commit();
        }

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
