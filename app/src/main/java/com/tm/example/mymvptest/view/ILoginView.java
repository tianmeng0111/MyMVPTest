package com.tm.example.mymvptest.view;

/**
 * Created by Tian on 2017/2/7.
 */

public interface ILoginView {

    public String getEmail();
    public String getPassword();

    public void onEmailEmpty();
    public void onEmailInvalid();
    public void onPasswordEmpty();
    public void onPasswordInvalid();

    public void onLoginSuccess();
    public void onLoginFail();

    public void showProgress();
    public void cancleProgress();
}
