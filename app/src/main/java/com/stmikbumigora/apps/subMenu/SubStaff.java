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
import com.stmikbumigora.apps.adapterDataDosenStaff.CustomAdapterDosen;
import com.stmikbumigora.apps.adapterDataDosenStaff.CustomAdapterStaff;


public class SubStaff extends Fragment {

    public SubStaff(){}
    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected SubStaff.LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected CustomAdapterStaff mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset, mDataset2, mDataset3;

    String[] NamaStaff = {"  I Made Arya Suwija, A.Ma.","  Martinah, S.E.","  Tirtonadi","  Sahrun","  Sulaiman","  Abdurrahman Daka","  Eldin","  Marlin, S.E.","  Endang Minarti","  Rr. Eny Kusumawardhany, S.E.",
    "  Erni Haryati, S.E.","  H. Suherman","  Wahyu Kamil S., S.Pd.","  Rahman Mulyadi","  Budi Santoso, A.Md.","  Lalu Anoar Hadi, A.Md.","  Khairan Marzuki, A.Ma.","  Pita Apsari, S.E.","  Zuriati, S.Pd.","  Ruri Yustiarini, A.Md.",
    "  Rahmi Komala Dewi, S.Sos.","  Ni Putu Nevy Hery Yani, S.Kom.","  Nurul Hafiah Laduni, S.E.","  Dian Sapta Rini, S.Kom.","  Septina Aryanti","  Jumirah, A.Md","  Yenny Faratih","  T. Findi Oktaviasari","  David Fernanda Pribadi, A.Md","Romi Chaerudin",
    "  Dian Aryani, S.Si","  Dwi Pusitaningrum","  Wildan","  Ari Rudiyan","  Blasius Jemat","  Muhammad Yani","  Annindyta Trikusuma Dewi","  Atikah Wyanet Araminta","  Muhammad Azwar","  Sofian Anshori",
    "  Mayadi","  Miftahul Madani","  Melati"};

    String[] Nik = {"90.4.21","92.5.29","96.3.52","97.0.112","98.3.102","97.3.113","97.3.59","98.3.102","98.3.101","99.5.102",
    "99.5.107","99.3.104","06.5.116","06.3.117","08.3.122","09.4.123","10.3.134","11.5.139","11.5.146","11.4.147",
    "11.5.144","12.5.167","13.5.172","13.5.175","14.3.191","14.3.192","11.5.137","13.3.203","13.3.202","13.3.204",
    "14.5.208","14.5.207","16.5.254","","","","","","","",
    "","",""};

    String[] Bagian = {"Rumah Tangga","YPEK","Akademik","Satpam ","Satpam","Satpam","Satpam","Akademik","Jurusan","BPM",
    "ADUM","Lab Komputer","Lab Bahasa","Satpam","Akademik","Perpustakaan","-","Jurusan","Akademik","Lab Komputer",
    "LSP","Administrasi","Keuangan","Akademik","Kerjasama","BPM","YPEK","Kemahasiswaan","PusTIK","Lab Komputer",
    "PusTIK","YPEK/ADUM","PusTIK","Promosi","Satpam","Lab Komputer","Keuangan","Keuangan","Devlopment","Devlopment",
    "Lab Komputer","Lab Komputer","Lab Komputer"};


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
        View rootView = inflater.inflate(R.layout.sub_staff, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycleStaff);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = SubStaff.LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (SubStaff.LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new CustomAdapterStaff(mDataset, mDataset2, mDataset3);
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
    public void setRecyclerViewLayoutManager(SubStaff.LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = SubStaff.LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = SubStaff.LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = SubStaff.LayoutManagerType.LINEAR_LAYOUT_MANAGER;
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
        mDataset = new String[NamaStaff.length];
        mDataset2 = new String[Nik.length];
        mDataset3 = new String[Bagian.length];
        for (int i = 0; i < NamaStaff.length; i++) {
            mDataset[i] = NamaStaff[i];
            mDataset2[i] = Nik[i];
            mDataset3[i] = Bagian[i];
        }
    }

}
