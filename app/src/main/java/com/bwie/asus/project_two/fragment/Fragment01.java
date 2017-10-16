package com.bwie.asus.project_two.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.asus.project_two.R;
import com.bwie.asus.project_two.SaoYiSao;
import com.bwie.asus.project_two.SearchActivity;
import com.bwie.asus.project_two.adapter.Fragment_adapter01;
import com.bwie.asus.project_two.bean.Bean01;
import com.bwie.asus.project_two.api.URLBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/10/9.
 */

public class Fragment01 extends Fragment {

    private ImageView sao;
    private RelativeLayout search;
    private TextView search_shoujike;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);

        sao = view.findViewById(R.id.sao);
        search = view.findViewById(R.id.search);
        search_shoujike = view.findViewById(R.id.search_shoujike);
        System.out.println("view = " + view);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initData();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), SaoYiSao.class), 100);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            String text = data.getStringExtra("text");
            Toast.makeText(getActivity(), "扫描成功", Toast.LENGTH_SHORT).show();
        }
    }


    private void initData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(URLBean.YNF).build();
        Call call = client.newCall(request);
        System.out.println("call = " + call);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                System.out.println("result = " + result);

                Gson gson = new Gson();
                Bean01 bean01 = gson.fromJson(result, Bean01.class);
                final Bean01.DataBean data = bean01.getData();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Fragment_adapter01 adapter01 = new Fragment_adapter01(getActivity(), data);
                        System.out.println("adapter01 = " + adapter01);
                        recyclerView.setAdapter(adapter01);
                    }
                });

            }
        });
    }

}
