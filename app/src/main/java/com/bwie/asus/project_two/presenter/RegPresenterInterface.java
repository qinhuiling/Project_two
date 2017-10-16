package com.bwie.asus.project_two.presenter;

import android.content.Context;

/**
 * Created by ASUS on 2017/10/15.
 */

public interface RegPresenterInterface {
    void regGetData(Context context, String regName, String regPwd, String regAgainPwd, String regEmail);
}