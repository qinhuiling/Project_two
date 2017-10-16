package com.bwie.asus.project_two.port;

/**
 * Created by ASUS on 2017/10/15.
 */

public interface RegFinishListener {
    void NameEmpty();
    void PwdEmpty();
    void AgainPwdEmpty();
    void EmailEmpty();
    void RegSucceed();
    void RegFailed();
}
