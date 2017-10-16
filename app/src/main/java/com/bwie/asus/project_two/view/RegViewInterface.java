package com.bwie.asus.project_two.view;

/**
 * Created by ASUS on 2017/10/15.
 */

public interface RegViewInterface {
    void toBack();
    void onNameEmpty();
    void onPwdEmpty();
    void onAgainPwdEmpty();
    void onEmailEmpty();
    void onRegSucceed();
    void onRegFailed();
}
