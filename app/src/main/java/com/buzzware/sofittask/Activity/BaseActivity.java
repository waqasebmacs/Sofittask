package com.buzzware.sofittask.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.buzzware.sofittask.Fragment.HomeFragment;
import com.buzzware.sofittask.Fragment.ServicesFragment;
import com.buzzware.sofittask.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
public class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    DrawerLayout drawer;
    Toolbar toolbar;
    public static TextView toolbartitle_TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initialView();
    }

    private void initialView() {
        toolbar = findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar );
        drawer = findViewById ( R.id.drawer_layout );
        navigationView = findViewById ( R.id.nav_view );
        toolbartitle_TV=findViewById(R.id.toolbartitle_TV);
        toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener ( toggle );
        toggle.syncState ();
        navigationView.setNavigationItemSelectedListener ( this );
        toolbartitle_TV.setText("Home");
        loadFragment(new HomeFragment());
        toolbar.setTitleTextColor( Color.BLACK );
        navigationView.setItemIconTintList(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //todo for setting at right side of Drawer
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = findViewById ( R.id.drawer_layout );
        drawer.closeDrawer ( GravityCompat.START );
        switch (item.getItemId()){
            case R.id.nav_home:
                toolbartitle_TV.setText("Home");
                loadFragment(new HomeFragment());
                break;
            case R.id.nav_service :
                toolbartitle_TV.setText("Government Services");
                loadFragment(new ServicesFragment());
                break;
        }
        return true;
    }
    //todo function have to replace the fragment
    private boolean loadFragment(Fragment fragment)
    {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
            return true;
        }
        return false;
    }
}