package com.bwie.asus.project_two.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bwie.asus.project_two.R;
import com.bwie.asus.project_two.adapter.Fragment_adapter02_left;
import com.bwie.asus.project_two.api.URLBean;
import com.bwie.asus.project_two.bean.Bean02;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/10/9.
 */

public class Fragment02 extends Fragment {

    private ProgressBar progressBar;
    private RecyclerView recycler_left;
    private RecyclerView recycler_right;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02,container,false);

        progressBar = view.findViewById(R.id.progressbar);
        recycler_left = view.findViewById(R.id.recycler_left);
        recycler_right = view.findViewById(R.id.recycler_right);

        initData();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        //得到WindowManager
        WindowManager windowManager = getActivity().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //得到屏幕宽
        int width = display.getWidth();
        //将RecyclerView宽设置为屏幕宽的1/5
        params.width = width * 1 / 5;
        recycler_left.setLayoutParams(params);

        //得到RecyclerView布局管理器
        LinearLayoutManager leftLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        recycler_left.setLayoutManager(leftLayoutManager);

        //得到RecyclerView布局管理器
        LinearLayoutManager rightLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        recycler_right.setLayoutManager(rightLayoutManager);

    }

    private void initData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(URLBean.ER_ONE).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getActivity(),"服务器飞走了",Toast.LENGTH_SHORT).show();
                        return;
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        Gson gson = new Gson();
                        Bean02 bean02 = gson.fromJson(string, Bean02.class);

                        List<Bean02.DatasBean.ClassListBean> class_list = bean02.getDatas().getClass_list();
                        //创建适配器
                        Fragment_adapter02_left leftAdapter = new Fragment_adapter02_left(getActivity(),class_list);
                        recycler_left.setAdapter(leftAdapter);

                    }
                });
            }
        });

    }

}
