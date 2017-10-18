package com.stmikbumigora.apps.menuNavigation;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.stmikbumigora.apps.R;
import com.stmikbumigora.apps.adapterDataDosenStaff.CustomAdapter;

public class FasilitasKampus extends AppCompatActivity {
    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset, mDataset2;
    protected int[] mDataset3;

    int[] icon = {R.drawable.ruang_kelas, R.drawable.perpustakaan, R.drawable.lab_komputer1, R.drawable.lab_komputer2, R.drawable.lab_jaringan, R.drawable.lab_multimedia, R.drawable.lab_bahasa, R.drawable.lab_opensource, R.drawable.training_center,R.drawable.aula, R.drawable.koneksi_internet,R.drawable.video_conference};
    String[] judul = {"  Ruang Kelas", "  Perpustakaan", "  Lab. Komputer 1", "  Lab. Komputer 2", "  Lab. Jaringan", "  Lab. Multimedia", "  Lab. Bahasa", "  Lab. Open Source", "  Training Center","  Aula", "  Koneksi Internet","  Video Conference"};
    String[] deskripsi = {"STMIK Bumigora mempunyai 8 ruang kelas, dengan luas total 560 m2. Setiap ruang kelas dilengkapi dengan kursi kuliah yang nyaman, AC atau kipas angin, dan LCD proyektor.\n",
            "Perpustakaan STMIK Bumigora merupakan perpustakaan perguruan tinggi swasta terlengkap dan terbaik di NTB. Menyediakan 4000an judul buku dan jurnal. Pengelolaan menggunakan sistem informasi SLIMS dan katalog buku dapat diakses secara online melalui Digilib.\n",
            "Laboratorium Komputer 1 memiliki 40 unit computer. Dilengkapi dengan koneksi jaringan dan LCD proyektor, serta software yang lengkap untuk mendukung praktikum pemrograman dasar.\n",
            "Laboratorium Komputer 2 menyediakan 22 unit computer dengan. Seluruh computer terkoneksi dengan jaringan dan dilengkapi LCD proyektor. Digunakan untuk praktikum pemrograman lanjut.\n",
            "Laboratorium jaringan STMIK Bumigora memiliki 24 unit computer, 1 buah mounting rack, yang dilengkapi dengan perangkat router, switch, dan hub, wireless dan hotspot, serta perangkat pendukung lainnya.\n",
            "Laboratorium Multimedia memiliki 14 unit computer multimedia build up. Luas ruang 45 m2. Dilengkapi pula dengan peralatan Video Editing seperti Camcorder 3CCD, kamera, tripod, dan lampu.\n",
            "Laboratorium Bahasa dilengkapi dengan 20 perangkat peralatan bahasa, speaker, dan LCD monitor.\n",
            "Laboratorium Open source dilengkapi dengan perangkat computer built up sebanyak 14 unit. Dan dilengkapi dengan LCD Proyektor.\n",
            "Training Center merupakan tempat yang disediakan untuk pelaksanaan Training baik internal maupun eksternal. Terdiri dari 20 unit computer yang terkoneksi ke jaringan intranet dan internet.\n",
            "Aula STMIK Bumigora memiliki luas 240 m2 dan dapat menampung 200 orang untuk even seminar. Aula juga dipergunakan untuk perkuliahan.\n",
            "STMIK Bumigora menyediakan fasilitas 5 titik hotspot dengan kapasitas 15 MBps, sehingga Mahasiswa STMIK Bumigora dapat dengan mudah mengakses internet di lingkungan kampus.\n",
            "Dengan peralatan video conference, STMIK Bumigora secara berkala mengadakan kuliah, seminar atau meeting jarak jauh dengan perguruan tinggi lain seperti ITS, UGM, dan Universitas Gunadarma, serta DIKTI.\n"};

    public FasilitasKampus() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fasilitas_kampus);

        FasilitasKampus.this.setTitle("Fasilitas Kampus");
//        this.setTag(TAG);
        initDataset();
        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) FasilitasKampus.this.findViewById(R.id.recycle);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(FasilitasKampus.this);

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new CustomAdapter(mDataset, mDataset2, mDataset3);
        // Set CustomAdapterProgramStudi as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_satu_fasilitasKampus);
        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(FasilitasKampus.this, SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(FasilitasKampus.this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(FasilitasKampus.this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new String[judul.length];
        mDataset2 = new String[deskripsi.length];
        mDataset3 = new int[icon.length];
        for (int i = 0; i < judul.length; i++) {
            mDataset[i] = judul[i];
            mDataset2[i] = deskripsi[i];
            mDataset3[i] = icon[i];
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



