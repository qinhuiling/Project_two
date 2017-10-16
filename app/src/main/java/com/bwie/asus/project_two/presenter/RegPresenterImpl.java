package com.bwie.asus.project_two.presenter;

import android.content.Context;

import com.bwie.asus.project_two.model.RegModelImpl;
import com.bwie.asus.project_two.port.RegFinishListener;
import com.bwie.asus.project_two.view.RegViewInterface;

/**
 * Created by ASUS on 2017/10/15.
 */

public class RegPresenterImpl implements RegPresenterInterface,RegFinishListener{
    private RegViewInterface regViewInterface;
    private final RegModelImpl regModel;

    public RegPresenterImpl(RegViewInterface regViewInterface) {
        this.regViewInterface = regViewInterface;
        regModel = new RegModelImpl(this);
    }

    @Override
    public void regGetData(Context context, String regName, String regPwd, String regAgainPwd, String regEmail) {
        if(regModel!=null){
            regModel.RegLogin(context,regName,regPwd,regAgainPwd,regEmail);
        }
    }

    @Override
    public void NameEmpty() {
        if(regViewInterface!=null){
            regViewInterface.onNameEmpty();
        }

    }

    @Override
    public void PwdEmpty() {
        if(regViewInterface!=null) {
            regViewInterface.onPwdEmpty();
        }
    }

    @Override
    public void AgainPwdEmpty() {
        if(regViewInterface!=null) {
            regViewInterface.onAgainPwdEmpty();
        }
    }

    @Override
    public void EmailEmpty() {
        if(regViewInterface!=null) {
            regViewInterface.onEmailEmpty();
        }
    }

    @Override
    public void RegSucceed() {
        if(regViewInterface!=null) {
            regViewInterface.onRegSucceed();
        }
    }

    @Override
    public void RegFailed() {
        if(regViewInterface!=null) {
            regViewInterface.onRegFailed();
        }
    }
}
