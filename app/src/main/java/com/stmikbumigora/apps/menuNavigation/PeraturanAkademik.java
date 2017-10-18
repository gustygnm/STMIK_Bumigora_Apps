package com.stmikbumigora.apps.menuNavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.stmikbumigora.apps.R;

public class PeraturanAkademik extends Fragment {

    public PeraturanAkademik(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.peraturan_akademik, container, false);

        getActivity().setTitle("Peraturan Akademik");
        Log.e("PeraturanAkademik", "PeraturanAkademik");

        return view;
    }
}
