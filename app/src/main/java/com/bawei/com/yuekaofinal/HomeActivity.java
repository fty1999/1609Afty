package com.bawei.com.yuekaofinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/18 18:38:12
 * @Description:
 */
public class HomeActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = findViewById(R.id.textView);
        handler.sendEmptyMessage(100);
    }
    int time = 3;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (time>0){
                textView.setText(time-- + "S");
                handler.sendEmptyMessageDelayed(100,1000);
            }else {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
            }
        }
    };
}
