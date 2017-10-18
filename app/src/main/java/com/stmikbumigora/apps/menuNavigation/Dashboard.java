package com.stmikbumigora.apps.menuNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.stmikbumigora.apps.R;
import com.stmikbumigora.apps.subMenu.subDataDosendanStaff;


public class Dashboard extends Fragment {

    FrameLayout btn1,btn2,btn3,btn4,btn5,btn6;

    public Dashboard() {
    }

    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dashboard, container, false);

        getActivity().setTitle("Dashboard");

        btn1 = (FrameLayout) rootView.findViewById(R.id.klik_sistemPendidikan);
        btn1.setClickable(true);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KalenderAkademik.class);
                startActivity(intent);
            }
        });

        btn2 = (FrameLayout) rootView.findViewById(R.id.klik_biayaPendidikan);
        btn2.setClickable(true);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KalenderAkademik.class);
                startActivity(intent);
            }
        });

        btn3 = (FrameLayout) rootView.findViewById(R.id.klik_Beasiswa);
        btn3.setClickable(true);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KalenderAkademik.class);
                startActivity(intent);
            }
        });

        btn4 = (FrameLayout) rootView.findViewById(R.id.klik_peraturanAkademik);
        btn4.setClickable(true);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KalenderAkademik.class);
                startActivity(intent);
            }
        });

        btn5 = (FrameLayout) rootView.findViewById(R.id.klik_kalenderAkademik);
        btn5.setClickable(true);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KalenderAkademik.class);
                startActivity(intent);
            }
        });

        btn6 = (FrameLayout) rootView.findViewById(R.id.klik_ukmDanSC);
        btn6.setClickable(true);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KalenderAkademik.class);
                startActivity(intent);
            }
        });


        return rootView;
    }
}
