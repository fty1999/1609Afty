package com.bawei.com.yuekaofinal.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.com.yuekaofinal.R;
import com.bawei.com.yuekaofinal.fragment.frag.F1;
import com.bawei.com.yuekaofinal.fragment.frag.F2;

import java.util.ArrayList;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/18 16:51:15
 * @Description:
 */
public class FragOne extends Fragment {

    private TabLayout tabLayout;
    private ViewPager pager;
    private ArrayList<Fragment> list;
    private ArrayList<String> strings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_one,container,false);
        tabLayout = view.findViewById(R.id.tablayout);
        pager = view.findViewById(R.id.viewpager);
        list = new ArrayList<>();
        strings = new ArrayList<>();
        list.add(new F1());
        list.add(new F2());
        strings.add("关注");
        strings.add("知乎");
        pager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return strings.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        tabLayout.setupWithViewPager(pager);
        return view;

    }
}
