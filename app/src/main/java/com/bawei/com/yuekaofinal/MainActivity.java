package com.bawei.com.yuekaofinal;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.com.yuekaofinal.base.BaseActivity;
import com.bawei.com.yuekaofinal.fragment.FragOne;
import com.bawei.com.yuekaofinal.fragment.FragTwo;

public class MainActivity extends BaseActivity {

    private FrameLayout frameLayout;
    private RadioGroup radioGroup;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        manager = getSupportFragmentManager();
        final FragOne one = new FragOne();
        final FragTwo two = new FragTwo();
        manager.beginTransaction()
                .add(R.id.framelayout,one)
                .add(R.id.framelayout,two)
                .commit();
        manager.beginTransaction().hide(two).show(one).commit();
        radioGroup.check(radioGroup.getChildAt(0).getId());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio0:
                        manager.beginTransaction().hide(two).show(one).commit();
                        break;
                    case R.id.radio1:
                        manager.beginTransaction().hide(one).show(two).commit();
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {
        frameLayout = findViewById(R.id.framelayout);
        radioGroup = findViewById(R.id.radioGroup);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }
}
