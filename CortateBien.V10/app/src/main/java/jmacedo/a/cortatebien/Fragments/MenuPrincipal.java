package jmacedo.a.cortatebien.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Adaptadores.TabbAdapter;

public class MenuPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView navNombreUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout =(TabLayout) findViewById(R.id.tabs);
        ViewPager pager =(ViewPager) findViewById(R.id.viewpager);

        TabbAdapter tabbsAdapter = new TabbAdapter(getSupportFragmentManager());
        pager.setAdapter(tabbsAdapter);
        tabLayout.setupWithViewPager(pager);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View navHeader = navigationView.getHeaderView(0);
        navNombreUsuario = navHeader.findViewById(R.id.nombreUsuarioNav);
        cargarNombreUsuario();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        /*cargarUsuarioShared();*/
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menuPrincipal) {
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        } else if (id == R.id.nav_menuPerfil) {
            Intent intent = new Intent(this, Mi_perfil.class);
            startActivity(intent);
        } else if (id == R.id.nav_menuReserva) {
            Intent intent = new Intent(this, Mis_reservas.class);
            startActivity(intent);
        } else if (id == R.id.nav_menuLogout) {
            SharedPreferences preferences = getSharedPreferences("credencialesIdUsuario", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("idUsuarioReserva");
            editor.commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void cargarNombreUsuario(){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String user = preferences.getString("user", "no existe");
        navNombreUsuario.setText(user);
    }
}

