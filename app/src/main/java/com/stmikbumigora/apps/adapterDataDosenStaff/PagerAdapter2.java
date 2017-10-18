package com.stmikbumigora.apps.adapterDataDosenStaff;

/**
 * Created by gusty on 8/14/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stmikbumigora.apps.subMenu.SubDosen;
import com.stmikbumigora.apps.subMenu.SubStaff;

public class PagerAdapter2 extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter2(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SubDosen tab1 = new SubDosen();
                return tab1;
            case 1:
                SubStaff tab2 = new SubStaff();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

