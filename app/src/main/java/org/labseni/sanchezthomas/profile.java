package org.labseni.sanchezthomas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.google.firebase.auth.FirebaseAuth;



public class profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private FirebaseAuth firebaseAuth;

    DrawerLayout drawer;
    NavigationView navigationView;
    //FragmentManager fragmentManager;
    //Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth= FirebaseAuth.getInstance();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.profil);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        //navigationView = (NavigationView) findViewById(R.id.profil);
       // navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

  /*  @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.profil);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*if (mToggle.onOptionsItemSelected(item)) {
            return true;

        }*/
        if (id == R.id.nav_logout) {
            Toast.makeText(getApplicationContext(), "Keluar Bro?", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==R.id.nav_logout)
        {
            //handel the item
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, daftar.class));

        }
        else if(id==R.id.nav_cek)
        {
            //cek

        }
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.profil);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
