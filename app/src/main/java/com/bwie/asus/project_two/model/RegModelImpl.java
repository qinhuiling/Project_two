package com.bwie.asus.project_two.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.bwie.asus.project_two.api.URLBean;
import com.bwie.asus.project_two.bean.Register;
import com.bwie.asus.project_two.port.RegFinishListener;
import com.bwie.asus.project_two.utlis.GsonObjectCallback;
import com.bwie.asus.project_two.utlis.OKHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by ASUS on 2017/10/15.
 */

public class RegModelImpl implements RegModelInterface {
    private RegFinishListener listener;

    public RegModelImpl(RegFinishListener listener) {
        this.listener = listener;
    }

    @Override
    public void RegLogin(Context context, String regName, String regPwd, String regAgainPwd, String regEmail) {
        //注册用户名为空时
        if(TextUtils.isEmpty(regName)){
            //调用方法
            listener.NameEmpty();
            return;
        }
        //注册密码为空时
        if(TextUtils.isEmpty(regPwd)){
            //调用方法
            listener.PwdEmpty();
            return;
        }
        //注册确认密码为空时
        if(TextUtils.isEmpty(regAgainPwd)){
            //调用方法
            listener.AgainPwdEmpty();
            return;
        }
        //注册邮箱为空时
        if(TextUtils.isEmpty(regEmail)){
            //调用方法
            listener.EmailEmpty();
            return;
        }
        regRequest(context, regName, regPwd, regAgainPwd, regEmail);


    }

    @Override
    public void regRequest(final Context context, String regName, String regPwd, final String regAgainPwd, String regEmail) {
        //定义一个Map集合将参数进行封装
        Map<String, String> regParams = new HashMap<String, String>();
        //将参数添加到集合
        regParams.put("username", regName);
        regParams.put("password", regPwd);
        regParams.put("password_confirm", regAgainPwd);
        regParams.put("email", regEmail);
        regParams.put("client", URLBean.REGISTERM);
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url(URLBean.REGISTERM).build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String string = response.body().string();
//                System.out.println("string = " + string);
//                Gson gson = new Gson();
//                Register register = gson.fromJson(string, Register.class);
//                Register.DatasBean datas = register.getDatas();
//
//            }
//
//        });

        OKHttp3Utils.doPost(URLBean.REGISTERM, regParams, new GsonObjectCallback<Register>() {
            @Override
            public void onUi(Register regBean) {
                Log.i("内容",regBean.toString());
                if(regBean.getCode()==200){
                    listener.RegSucceed();
                }else if(regBean.getCode()==400){
                    listener.RegFailed();
                }
            }
            @Override
            public void onFailed(Call call, IOException e) {
            }
        });

    }
}
