package com.stmikbumigora.apps;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.stmikbumigora.apps.menuNavigation.BantuanMasukan;
import com.stmikbumigora.apps.menuNavigation.Dashboard;
import com.stmikbumigora.apps.menuNavigation.DataDosenStaff;
import com.stmikbumigora.apps.menuNavigation.FasilitasKampus;
import com.stmikbumigora.apps.menuNavigation.Home;
import com.stmikbumigora.apps.menuNavigation.KalenderAkademik;
import com.stmikbumigora.apps.menuNavigation.Nav_Sejarah;
import com.stmikbumigora.apps.menuNavigation.ProgramStudi;
import com.stmikbumigora.apps.menuNavigation.Sejarah;
import com.stmikbumigora.apps.menuNavigation.StrukturOrganisasi;
import com.stmikbumigora.apps.menuNavigation.Tentang;
import com.stmikbumigora.apps.menuNavigation.VisiMisi;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment = null;
    Activity activity = null;
    private AlertDialog.Builder alertDialogBuilder;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Home home = new Home();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container, home);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    Dashboard dashboard = new Dashboard();
                    FragmentTransaction fragmentTransactionD = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionD.replace(R.id.frame_container, dashboard);
                    fragmentTransactionD.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        alertDialogBuilder = new AlertDialog.Builder(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // tampilan default awal ketika aplikasii dijalankan
        if (savedInstanceState == null) {
            Home home = new Home();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, home);
            fragmentTransaction.commit();
        }

    }

    boolean doubleBackToExit = false;

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (doubleBackToExit) {
                alertDialogBuilder.setTitle("Tutup Aplikasi");
                alertDialogBuilder
                        .setMessage("Apakah Anda yakin ingin menutup aplikasi ini?")

                        .setCancelable(false)
                        .setPositiveButton("Ya",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        Intent exit = new Intent(Intent.ACTION_MAIN);
                                        exit.addCategory(Intent.CATEGORY_HOME);
                                        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(exit);
                                    }
                                })
                        .setNegativeButton("Tidak",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        dialogInterface.cancel();
                                    }
                                }).create().show();
            } else {
//                Home home = new Home();
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.frame_container, home);
//                fragmentTransaction.commit();
                Toast.makeText(this, "Tekan tombol kembali lagi untuk keluar", Toast.LENGTH_SHORT).show();
            }
            int timee=2000;
            this.doubleBackToExit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExit = false;
                }
            },timee );
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Untuk memanggil layout dari menu yang dipilih
//        if (id == R.id.nav_home) {
//            Home home = new Home();
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.frame_container, home);
//            fragmentTransaction.commit();
//        } else
        if (id == R.id.sub_sejarah) {
            startActivity(new Intent(MainActivity.this, Nav_Sejarah.class));
//            Sejarah sejarah = new Sejarah();
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.frame_container, sejarah);
//            fragmentTransaction.commit();
        } else if (id == R.id.sub_visiMisi) {
            startActivity(new Intent(MainActivity.this, VisiMisi.class));
        } else if (id == R.id.sub_strukturOrganisasi) {
            startActivity(new Intent(MainActivity.this, StrukturOrganisasi.class));
        } else if (id == R.id.sub_dataDosenStaff) {
            startActivity(new Intent(MainActivity.this, DataDosenStaff.class));
        } else if (id == R.id.sub_fasilitasKampus) {
            startActivity(new Intent(MainActivity.this, FasilitasKampus.class));
        } else if (id == R.id.sub_programStudi) {
            startActivity(new Intent(MainActivity.this, ProgramStudi.class));
//        } else if (id == R.id.sub_peraturanAkademik) {
//            fragment = new PeraturanAkademik();
//            callFragment(fragment);
        } else if (id == R.id.sub_kalenderAkademik) {
            startActivity(new Intent(MainActivity.this, KalenderAkademik.class));
//        } else if (id == R.id.sub_kemahasiswaan) {
//            fragment = new Kemahasiswaan();
//            callFragment(fragment);
        } else if (id == R.id.sub_bantuanMasukan) {
            startActivity(new Intent(MainActivity.this, BantuanMasukan.class));
        } else if (id == R.id.sub_tentang) {
            startActivity(new Intent(MainActivity.this, Tentang.class));
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // untuk mengganti isi kontainer menu yang dipiih
    private void callFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }


}
