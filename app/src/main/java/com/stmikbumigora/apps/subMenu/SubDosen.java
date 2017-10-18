package com.stmikbumigora.apps.subMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.stmikbumigora.apps.R;
import com.stmikbumigora.apps.adapterDataDosenStaff.CustomAdapter;
import com.stmikbumigora.apps.adapterDataDosenStaff.CustomAdapterDosen;
import com.stmikbumigora.apps.menuNavigation.FasilitasKampus;


public class SubDosen extends Fragment {

    public SubDosen() {
    }

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected SubDosen.LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected CustomAdapterDosen mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset, mDataset2, mDataset3, mDataset4;

    String[] NamaDosen = {"  Ir. Anthony Anggrawan, M.T., Ph.D", "  Ir. Bambang Krismono T., M.Kom", "  Dyah Susilowati, M.Kom", "  Ahmat Adil, M.Sc", "  Heroe Santoso, M.Kom", "  Raisul Azhar, M.T", "  Dian Syafitri C. S., MDig.MMedia", "  Agus Pribadi, S.T., M.Sc", "  Helna Wardhana, M.Kom", "  Dadang Priyanto, M.Kom",
    "  Khasnur Hidjah, M.Cs","  I Putu Hariyadi, M.Kom., CCNA CCAI","  Husain, S.Kom","  Andris Faisal, S.Kom","  Ni Gusti Ayu Dasriani, S.Kom, M.Kom","  Kartarina, S.Kom","  M. Yunus, M.Kom","  Junanda Patihullah, S.Kom","  Ahmad Ashril Rizal, S.Si","  M. Nur, S.Pd., M.Hum",
    "  Dr. H. M. Tajuddin, M.Si","  Ni Ketut Sriwinarti, S.E., AK., MSA","  Suriyati, M.Kom","   Ria Rosmalasari Sapitri, S.E., M.M","  Komariyuli Anwariyah, S.T., M.Kom","  Apriani, S.Kom","  Danang Tejo Kumoro, M.Kom","  Zaenal Abidin, S.Kom","  Ria Rismayati, S.Kom","  Galih Hendro Martono, M.Eng",
    "  Anggreni, S.T., M.T","  Neny Sulistianingsih, M.Kom","  Uswatun Hasanah, M.Si","  Dwi Ratnasari, M.T","  Syahroni Hidayat, M.Eng","  Ni Wayan Sri Ekanawati, S.E., M.Ak","  Ismarmiaty, S.T., MMSI","  Wahyul Wahidah, S.T., M.Eng","  Ahmad, S.Pd., M.Pd","  Budiman Sani, S.Pd., M.Pd",
    "  Habib Ratu Perwira Negara, S.Pd., M.Pd","  Raden Fanny Printi Ardi, S.Sn., M.Sn","  Adam Bachtiar, S.Kom., M.MT","  Pahrul Irfan, S.Kom., M.Kom","  Sunardy Kasim, S.Pd., M.Sn","  Pyhta Rahima, S.E., M.M","  Sandi Justitia Putra S.I.Kom., M.A","  Restu Fahdiansyah, S.E., M.S.A","  Syarifah Fitriana, S.Sn., M.Sn","  Jihadil Qudsi S., M.Si",
    "  A. A. Ngr Gde Damatta Amitabha, S.Sn.,M.Sn","  Desventri Etmy, S.Si., M.Pd","  Erwin Suhendra, M.Pd","  Abdurahim, S.Si.,M.Sc","  Baiq Candra Herawati, S.T., M.M","  Andi Sofyan Anas, S.T.,M.Kom","  Siti Soraya, S.Si.,M.Si","  Nurhidayati, M.T.","  Muhammad Rizkillah, S.T., M.Eng","  Dedy Febry Rachman",
    "  Ahmad Sehabuddin","  Puspita Dewi","  Yuda Januar Pratama","  Lalu Zazuli Azhar","  Jian Budiarto"};

    String[] NikNip = {"196112261994031001", "93.6.06", "196804262005012001", "96.6.63", "96.6.64", "98.6.87", "98.6.92", "98.6.64", "98.6.99", "99.6.108",
    "197202072005012001","09.6.124","10.5.127","10.5.123","10.5.133/10.6.133","10.5.235","10.6.135","11.5.243","11.5.242","97.6.82",
    "196011221995011001","10.6.131","96.6.62","11.6.151","13.6.171","12.5.166/12.6.166","13.6.176","12.5.162","12.5.165","14.6.194",
    "14.6.198","15.6.211","15.6.212","15.6.213","13.6.177","15.6.216","15.6.215","12.6.152","15.6.224","15.6.225",
    "15.6.226","15.6.229","15.6.231","15.6.232","15.6.233","16.6.235","16.6.240","16.6.237","16.6.239","16.6.238",
    "16.6.243","16.6.245","16.6.251","16.6.250","16.6.249","16.6.248","16.6.244","07.5.188","","",
    "","","","",""};

    String[] Pendidikan = {"S3 Doctor of Philosophy (Accounting)", "S2 Teknik Informatika", "S2 Teknik Informatika", "S2 Teknologi Informasi", "S2 Ilmu Komputer", "S2 Teknik Elektro", "S2 Multimedia", "S2 Teknologi Informasi", "S2 Ilmu Komputer", "S2 Ilmu Komputer",
    "S2 Ilmu Komputer","S2 Teknologi Informasi","S1 Teknik Informatika","S1 Teknik Informatika","S2 Teknik Informatika","S1 Sistem Informasi","S2 Teknologi Informasi","S1 Teknik Informatika","S1 Matematika","S2 Ilmu Linguistik",
    "S3 Ilmu Administrasi","S2 Akuntansi","S2 Teknologi Informasi","S2 Manajemen","S2 Teknik Informatika","S1 Teknik Informatika","S2 Teknik Informatika","S1 Teknik Informatika","S1 Teknik Informatika","S2 Teknik Elektro",
    "S2 Teknik Elektro","S2 Teknik Informatika","S2 Matematika","S2 Teknik Elektro","S2 Teknik Elektro","S2 Akuntansi","S2 Manajemen Sistem Informasi","S2 Teknik Elektro","S2 Pendidikan Matematika","S2 Pendidikan Matematika",
    "S2 Pendidikan Matematika","S2 Desain Komunikasi Visual","S2 Manajemen Teknologi","S2 Teknik Informatika","S2 Penciptaan dan Pengkajian Seni","S2 Manajemen","S2 Kajian Budaya dan Media","S2 Akuntansi","S2 Penciptaan dan Pengkajian Seni","S2 Statistik",
    "S2 Penciptaan dan Pengkajian Seni","S2 Pendidikan Matematika","S2 Bahasa Inggris","S2 Matematika","S2 Manajemen","S2 Teknik Informatika","S2 Statistika","S2 Teknik Elektro","","",
    "","","","",""};

    String[] PerguruanTinggi = {"Universiti Utara Malaysia", "Institut Teknologi Sepuluh November", "STTIBI (Sekolah Tinggi Teknologi Informasi Benarif Indonesia)", "Institut Pertanian Bogor", "Universitas Gadjah Mada", "Universitas Gadjah Mada", "University of Wollongong", "Institut Pertanian Bogor", "Universitas Gadjah Mada", "Universitas Gadjah Mada",
    "Universitas Gadjah Mada","STTS Surabaya","STMIK Bumigora Mataram","STMIK Bumigora Mataram","STMIK Bumigora Mataram","Universitas Bina Nusantara","STTS Surabaya","Universitas Trunojoyo","Universitas Mataram","Universitas Udayana",
    "Universitas Brawijaya","Universitas Brawijaya","Sekolah Tinggi Teknik Surabaya","Universitas Mataram","Universitas Islam Indonesia","STMIK Bumigora Mataram","STMIK AMIKOM Yogyakarta","STMIK Bumigora Mataram","STMIK Bumigora Mataram","Universitas Gadjah Mada",
    "Universitas Brawijaya","Universitas Islam Indonesia","Institut Teknologi Sepuluh November","Institut Teknologi Sepuluh November","Universitas Gadjah Mada","Universitas Mataram","Universitas Gunadarma","Universitas Gadjah Mada","Universitas Sebelas Maret Surakarta","Universitas Negeri Yogyakarta",
    "Universitas Sebelas Maret Surakarta","Institut Seni Indonesia Yogyakarta","Institut Teknologi Sepuluh November","Universitas Islam Indonesia","Institut Seni Indonesia Denpasar","Universitas Mataram","Universitas Gadjah Mada","Universitas Brawijaya","Institut Seni Indonesia Yogyakarta","Institut Teknologi Sepuluh November",
    "Institut Seni Indonesia Denpasar","Universitas Negeri Malang","Universitas Negeri Malang","Universitas Gadjah Mada","Universitas Mataram","STMIK AMIKOM Yogyakarta","Institut Teknologi Sepuluh November","Institut Teknologi Bandung","","",
    "","","","",""};

    RelativeLayout view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        view = (RelativeLayout) inflater.inflate(R.layout.fasilitas_kampus, container, false);
//
//        getActivity().setTitle("Fasilitas Kampus");
//        Log.e("FasilitasKampus", "FasilitasKampus");
//
//        return view;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sub_dosen, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycleDosen);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = SubDosen.LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (SubDosen.LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new CustomAdapterDosen(mDataset, mDataset2, mDataset3, mDataset4);
        // Set CustomAdapterProgramStudi as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)
        return rootView;
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(SubDosen.LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = SubDosen.LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = SubDosen.LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = SubDosen.LayoutManagerType.LINEAR_LAYOUT_MANAGER;
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
        mDataset = new String[NamaDosen.length];
        mDataset2 = new String[NikNip.length];
        mDataset3 = new String[Pendidikan.length];
        mDataset4 = new String[PerguruanTinggi.length];
        for (int i = 0; i < NamaDosen.length; i++) {
            mDataset[i] = NamaDosen[i];
            mDataset2[i] = NikNip[i];
            mDataset3[i] = Pendidikan[i];
            mDataset4[i] = PerguruanTinggi[i];
        }
    }

}
