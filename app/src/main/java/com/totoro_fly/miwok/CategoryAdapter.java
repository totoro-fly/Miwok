package com.totoro_fly.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by totoro-fly on 2016/12/29.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    Context mContext;

    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new NumberFragment();
        else if (position == 1)
            return new FamilyFragment();
        else if (position == 2)
            return new ColorFragment();
        else
            return new PhrasesFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.activity_main_numbers);
            case 1:
                return mContext.getString(R.string.activity_main_family);
            case 2:
                return mContext.getString(R.string.activity_main_colors);
            case 3:
                return mContext.getString(R.string.activity_main_phrases);
        }

        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
