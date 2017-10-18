package com.stmikbumigora.apps.adapterProgramStudi;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stmikbumigora.apps.subMenu.SubD3MI;
import com.stmikbumigora.apps.subMenu.SubD3TI;
import com.stmikbumigora.apps.subMenu.SubS1DKV;
import com.stmikbumigora.apps.subMenu.SubS1TI;

public class PagerAdapterProgramStudi extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterProgramStudi(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SubS1TI tab1 = new SubS1TI();
                return tab1;
            case 1:
                SubD3TI tab2 = new SubD3TI();
                return tab2;
            case 2:
                SubD3MI tab3 = new SubD3MI();
                return tab3;
            case 3:
                SubS1DKV tab4 = new SubS1DKV();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

