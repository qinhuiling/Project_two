package com.bwie.asus.project_two.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.asus.project_two.LoginRegister;
import com.bwie.asus.project_two.R;

/**
 * Created by ASUS on 2017/10/9.
 */

public class Fragment04 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04,container,false);

        SharedPreferences preferences = getActivity().getSharedPreferences("a", Context.MODE_PRIVATE);
        boolean falg = preferences.getBoolean("falg", false);
        if (falg){
            startActivity(new Intent(getActivity(), LoginRegister.class));
        }else{
            preferences.edit().putBoolean("falg",true).commit();
        }

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
