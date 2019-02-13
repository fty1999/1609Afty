package com.bawei.com.yuekaofinal.fragment.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.com.yuekaofinal.R;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/18 19:05:41
 * @Description:
 */
public class F2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragone,container,false);
        return view;
    }
}
