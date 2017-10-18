package com.stmikbumigora.apps.menuNavigation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.stmikbumigora.apps.AboutMe;
import com.stmikbumigora.apps.IntroActivity;
import com.stmikbumigora.apps.Intromanager;
import com.stmikbumigora.apps.R;
import com.stmikbumigora.apps.SplashActivity;

public class Tentang extends AppCompatActivity {

    AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tentang);

        Tentang.this.setTitle("Tentang");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_satu_Tentang);
        setSupportActionBar(toolbar);

        alertDialogBuilder = new AlertDialog.Builder(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public void onBackPressed() {
//        startActivity(new Intent(AboutMe.this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_aboutme:
                startActivity(new Intent(Tentang.this, AboutMe.class));
                return true;
            case R.id.action_restartapps:
                alertDialogBuilder.setTitle("Restart Apps");
                alertDialogBuilder
                        .setMessage("Anda akan melakukan Restart Apps!\nTekan 'YA' untuk melanjutkan.")

                        .setCancelable(false)
                        .setPositiveButton("Ya",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        Intromanager intromanager = new Intromanager(Tentang.this);
                                        intromanager.setFirst(false);
                                        if (!intromanager.Check()) {
                                            intromanager.setFirst(true);
                                            Intent i = new Intent(Tentang.this, IntroActivity.class);
                                            startActivity(i);
                                        }
                                    }
                                })
                        .setNegativeButton("Tidak",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        dialogInterface.cancel();
                                    }
                                }).create().show();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}