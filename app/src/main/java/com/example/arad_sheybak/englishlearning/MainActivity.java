package com.example.arad_sheybak.englishlearning;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.arad_sheybak.englishlearning.Fragment.Fragment_1;
import com.example.arad_sheybak.englishlearning.Fragment.Fragment_2;
import com.example.arad_sheybak.englishlearning.Fragment.Fragment_3;
import com.example.arad_sheybak.englishlearning.Fragment.PlayingVideo;

public class MainActivity extends AppCompatActivity implements Fragment_3.showMoview,Fragment_2.showMoview,Fragment_1.showMoview {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.nvView);
        View headerLayout=navigationView.getHeaderView(0);
        drawerToggle=setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);
        setupDrawerContent(navigationView);
    }
    private FragmentActivity getActivity() {
        return null;
    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem)
            {
                selectDrawerItem(menuItem);
                return true;
            }
            public void selectDrawerItem(MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.nav_first_fragment:
                        fragment = new Fragment_1();
                        break;
                    case R.id.nav_second_fragment:
                        fragment = new Fragment_2();
                        break;
                    case R.id.nav_third_fragment:
                        fragment = new Fragment_3();
                        break;
                    default:
                        fragment = new Fragment_1();
                }
                switchFragment(fragment);
                menuItem.setChecked(true);
                setTitle((menuItem.getTitle()));
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.flContent, fragment).commit();


    }

    @Override
    public void showMoviewByName(String name) {
        PlayingVideo playingVideo=PlayingVideo.newInstance(name);
        switchFragment(playingVideo);
    }

}

