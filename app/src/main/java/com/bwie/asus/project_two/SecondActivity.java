package com.bwie.asus.project_two;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.asus.project_two.fragment.Fragment01;
import com.bwie.asus.project_two.fragment.Fragment02;
import com.bwie.asus.project_two.fragment.Fragment03;
import com.bwie.asus.project_two.fragment.Fragment04;
import com.bwie.asus.project_two.fragment.Fragment05;

public class SecondActivity extends AppCompatActivity {

    private RadioGroup radio;
    private RadioButton bt1;
    private FragmentManager manager;
    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private Fragment04 fragment04;
    private Fragment05 fragment05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //查找控件
        radio = (RadioGroup) findViewById(R.id.radio);
        bt1 = (RadioButton) findViewById(R.id.bt1);

        manager = getSupportFragmentManager();
        if (bt1.isChecked()) {
            FragmentTransaction transaction1 = manager.beginTransaction();
            Fragment01 fragment01 = new Fragment01();
            transaction1.add(R.id.frame, fragment01);
            transaction1.commit();
            System.out.println("fragment01 = " + fragment01);
        }

//        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                switch (i) {
//                    case R.id.bt1:
//                        FragmentTransaction transaction1 = manager.beginTransaction();
//                        FragmentTransaction transaction2 = manager.beginTransaction();
//                        FragmentTransaction transaction3 = manager.beginTransaction();
//                        FragmentTransaction transaction4 = manager.beginTransaction();
//
//                        fragment01 = new Fragment01();
//                        transaction1.add(R.id.frame, fragment01);
//
//                        transaction1.show(fragment01);
//                        transaction2.hide(fragment02);
//                        transaction1.commit();
//                        break;
//                }
//            }
//        });

        initData();

//        //RadioGroup的监听事件
//        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//
//                //hideFragment();
//
//                switch (i){
//                    case R.id.bt1:
//                        FragmentTransaction transaction1 = manager.beginTransaction();
//                        if (fragment01 == null){
//                            fragment01 = new Fragment01();
//                            transaction1.add(R.id.frame, fragment01);
//                        }else{
//                            transaction1.show(fragment01);
//                        }
//                        transaction1.commit();
//                        break;
//                    case R.id.bt2:
//                        FragmentTransaction transaction2 = manager.beginTransaction();
//                        if (fragment02 == null) {
//                            fragment02 = new Fragment02();
//                            transaction2.add(R.id.frame, fragment02);
//                        }else {
//                            transaction2.show(fragment02);
//                        }
//                        transaction2.commit();
//                        break;
//                    case R.id.bt3:
//                        FragmentTransaction transaction3 = manager.beginTransaction();
//                        if (fragment03 == null) {
//                            fragment03 = new Fragment03();
//                            transaction3.add(R.id.frame, fragment03);
//                        }else{
//                            transaction3.show(fragment03);
//                        }
//                        transaction3.commit();
//                        break;
//                    case R.id.bt4:
//                        FragmentTransaction transaction4 = manager.beginTransaction();
//                        if (fragment04 == null) {
//                            fragment04 = new Fragment04();
//                            transaction4.add(R.id.frame, fragment04);
//                        }else{
//                            transaction4.show(fragment04);
//                        }
//                        transaction4.commit();
//                        break;
//                    case R.id.bt5:
//                        FragmentTransaction transaction5 = manager.beginTransaction();
//                        if (fragment05 == null) {
//                            fragment05 = new Fragment05();
//                            transaction5.add(R.id.frame, fragment05);
//                        }else{
//                            transaction5.show(fragment05);
//                        }
//                        transaction5.commit();
//                        break;
//                }
//            }
//        });

    }

    public void initData() {
        //RadioGroup的监听事件
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                //hideFragment();

                switch (i) {
                    case R.id.bt1:
                        FragmentTransaction transaction1 = manager.beginTransaction();

                        fragment01 = new Fragment01();
                        transaction1.replace(R.id.frame, fragment01);

                        transaction1.commit();
                        break;
                    case R.id.bt2:
                        FragmentTransaction transaction2 = manager.beginTransaction();

                        fragment02 = new Fragment02();
                        transaction2.replace(R.id.frame, fragment02);

                        transaction2.commit();
                        break;
                    case R.id.bt3:
                        FragmentTransaction transaction3 = manager.beginTransaction();

                        fragment03 = new Fragment03();
                        transaction3.replace(R.id.frame, fragment03);

                        transaction3.commit();
                        break;
                    case R.id.bt4:
                        FragmentTransaction transaction4 = manager.beginTransaction();

                        fragment04 = new Fragment04();
                        transaction4.replace(R.id.frame, fragment04);

                        transaction4.commit();
                        break;
                    case R.id.bt5:
                        FragmentTransaction transaction5 = manager.beginTransaction();

                        fragment05 = new Fragment05();
                        transaction5.replace(R.id.frame, fragment05);

                        transaction5.commit();
                        break;
                }
            }
        });
    }

//    public void hideFragment(){
//        FragmentTransaction transaction1 = manager.beginTransaction();
//        if (fragment01 != null){
//            transaction1.hide(fragment01);
//        }if (fragment02 != null){
//            transaction1.hide(fragment02);
//        }
//        if (fragment03 != null){
//            transaction1.hide(fragment03);
//        }if (fragment04 != null){
//            transaction1.hide(fragment04);
//        }
//        if (fragment05 != null){
//            transaction1.hide(fragment05);
//        }
//        transaction1.commit();
//    }

}
