package com.stmikbumigora.apps.menuNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.stmikbumigora.apps.R;
import com.stmikbumigora.apps.adapterDataDosenStaff.GridAdapter;
import com.stmikbumigora.apps.adapterProgramStudi.GridAdapterProgramStudi;
import com.stmikbumigora.apps.subMenu.subDataDosendanStaff;
import com.stmikbumigora.apps.subMenu.subProgramStudi;

public class ProgramStudi extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_studi);

        ProgramStudi.this.setTitle("Program Studi");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_satu_menuProgramStudi);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewProgramStudi);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(ProgramStudi.this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapterProgramStudi();
        mRecyclerView.setAdapter(mAdapter);


        Button mButton = (Button) findViewById(R.id.btnDetailProgramStudi);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgramStudi.this, subProgramStudi.class);
                startActivity(intent);
            }
        });
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
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
        }
        return super.onOptionsItemSelected(item);
    }

}