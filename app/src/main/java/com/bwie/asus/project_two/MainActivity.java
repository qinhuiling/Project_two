package com.bwie.asus.project_two;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int i = 3;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            int what = msg.what;
            if (what == 0){
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("a", MODE_PRIVATE);
        boolean falg = preferences.getBoolean("falg", false);
        if (falg){
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }else{
            initData();
            preferences.edit().putBoolean("falg",true).commit();
        }

    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i>0){
                    try {
                        Thread.sleep(1000);
                        i--;
                        handler.sendEmptyMessage(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
