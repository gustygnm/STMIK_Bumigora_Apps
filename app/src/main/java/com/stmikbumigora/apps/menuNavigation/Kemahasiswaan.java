package com.stmikbumigora.apps.menuNavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.stmikbumigora.apps.R;


public class Kemahasiswaan extends Fragment {

    public Kemahasiswaan(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.kemahasiswaan, container, false);

        getActivity().setTitle("Kemahasiswaan");
        Log.e("Kemahasiswaan", "Kemahasiswaan");

        return view;
    }
}
