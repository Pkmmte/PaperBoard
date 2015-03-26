package com.jahirfiquitiva.paperboard.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jahirfiquitiva.dashboardsample.R;
import com.jahirfiquitiva.paperboard.iconfragments.AllTheIcons;
import com.jahirfiquitiva.paperboard.iconfragments.GamesIcons;
import com.jahirfiquitiva.paperboard.iconfragments.GoogleAppsIcons;
import com.jahirfiquitiva.paperboard.iconfragments.LatestIcons;
import com.jahirfiquitiva.paperboard.iconfragments.SystemIcons;
import com.jahirfiquitiva.paperboard.tabs.SlidingTabLayout;

/**
 * Created by Jahir on 28/02/2015.
 */
public class Previews extends Fragment {

    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    private Context context;

    public static Fragment newInstance(Context context) {
        Previews f = new Previews();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.section_all_icons, null);

        context = getActivity();

        ActionBar toolbar = ((ActionBarActivity)context).getSupportActionBar();
        toolbar.setTitle(R.string.section_two);

        mPager = (ViewPager) root.findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) root.findViewById(R.id.tabs);
        mTabs.setViewPager(mPager);
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.accent);
            }
        });

        return root;
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] tabs;

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new Fragment();
            switch (position) {
                case 0:
                    f = new LatestIcons();
                    break;
                case 1:
                    f = new SystemIcons();
                    break;
                case 2:
                    f = new GoogleAppsIcons();
                    break;
                case 3:
                    f = new GamesIcons();
                    break;
                case 4:
                    f = new AllTheIcons();
                    break;
            }
            return f;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

}
