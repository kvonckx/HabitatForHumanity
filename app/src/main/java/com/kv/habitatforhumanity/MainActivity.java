package com.kv.habitatforhumanity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Called when MainActivity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create Navigation Menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        // Add listener on Navigation Menu
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Open Welcome Messenge
        Fragment welcome_fragment = new WelcomeFrag();
        FragmentTransaction welcome_transaction = getSupportFragmentManager().beginTransaction();
        welcome_transaction.replace(R.id.content_main, welcome_fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
            //// Opens Settings activity
            //startActivity(new Intent(getApplicationContext(), Settings.class));
        }
        else if(id == R.id.action_login) {
            Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();
            //// Opens Settings activity
            //startActivity(new Intent(getApplicationContext(), Login.class));

        }
        return super.onOptionsItemSelected(item);
    }

    // Called by onNavigationItemSelected to display the selected fragment
    private void displaySelectedScreen(int id){
        Fragment fragment = null;

        switch(id){
            case R.id.nav_about:
                fragment = new AboutUs();
                break;
            case R.id.nav_stock:
                fragment = new Stock();
                break;
            case R.id.nav_directions:
                //fragment = new Directions();
                break;
            case R.id.nav_contact:
                fragment = new Contact();
                break;
        }

        if (fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    //@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);

        return true;
    }
}


/*
 To do:
 Add content and scroll bar to about us
 create layout for contact info
 add office, hours, fax, email to contact
 add about applying for house
 manage fragments (see previous code and https://medium.com/@bherbst/managing-the-fragment-back-stack-373e87e4ff62)
 gimp some shit
 Decide howto go about Stock & Employee login
 Link stock to notifications in settings
*/