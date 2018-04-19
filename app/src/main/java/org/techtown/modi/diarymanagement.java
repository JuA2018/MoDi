package org.techtown.modi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class diarymanagement extends FragmentPagerAdapter {

    private int PAGE_NUMBER = 2;

    public diarymanagement(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                writediary writediary = new writediary();
                return writediary;
            case 1:
                Listdiary listdiary = new Listdiary();
                return listdiary;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }
}
