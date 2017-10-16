package com.bwie.asus.project_two.model;

import android.content.Context;

/**
 * Created by ASUS on 2017/10/15.
 */

public interface RegModelInterface {
    void RegLogin(Context context, String regName, String regPwd, String regAgainPwd, String regEmail);
    void regRequest(Context context,String regName, String regPwd, String regAgainPwd, String regEmail);
}