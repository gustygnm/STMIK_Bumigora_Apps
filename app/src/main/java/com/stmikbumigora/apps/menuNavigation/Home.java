package com.stmikbumigora.apps.menuNavigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stmikbumigora.apps.R;
import com.stmikbumigora.apps._sliders.FragmentSlider;
import com.stmikbumigora.apps._sliders.SliderIndicator;
import com.stmikbumigora.apps._sliders.SliderPagerAdapter;
import com.stmikbumigora.apps._sliders.SliderView;
import com.stmikbumigora.apps.adapterHome.GridAdapterHome;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter2;
    TextView textViewMarquee;
    Button btnWebsite, btnSiska;

    public Home() {
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);
        getActivity().setTitle("STMIK Bumigora Apps");
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewHome);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter2 = new GridAdapterHome();
        mRecyclerView.setAdapter(mAdapter2);
        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        setupSliderOffilne();

        btnWebsite=(Button)rootView.findViewById(R.id.btn_kunjungi_website);
        btnWebsite.setClickable(true);
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://website.stmikbumigora.ac.id"));
                startActivity(intent);
            }
        });
        btnSiska = (Button) rootView.findViewById(R.id.btn_kunjungi_siska);
        btnSiska.setClickable(true);
        btnSiska.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://siska.stmikbumigora.ac.id"));
                startActivity(intent);
            }
        });

        return rootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    //    private void setupSlider() {
//        sliderView.setDurationScroll(800);
//        List<FragmentSlider> fragments = new ArrayList<>();
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));
//
//        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
//        sliderView.setAdapter(mAdapter);
//        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
//        mIndicator.setPageCount(fragments.size());
//        mIndicator.show();
//    }

    private void setupSliderOffilne() {
        sliderView.setDurationScroll(800);
        List<FragmentSlider> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("stmikbg"));
        fragments.add(FragmentSlider.newInstance("image_slider_2"));
        fragments.add(FragmentSlider.newInstance("image_slider_3"));
        fragments.add(FragmentSlider.newInstance("image_slider_4"));
        fragments.add(FragmentSlider.newInstance("image_slider_5"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
