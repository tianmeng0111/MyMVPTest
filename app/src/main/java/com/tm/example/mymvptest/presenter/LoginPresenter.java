package com.tm.example.mymvptest.presenter;

import android.os.AsyncTask;

import com.tm.example.mymvptest.model.ILogin;
import com.tm.example.mymvptest.model.LoginOperate;
import com.tm.example.mymvptest.view.ILoginView;

/**
 * Created by Tian on 2017/2/7.
 */

public class LoginPresenter {

    private ILogin iLogin;
    private ILoginView iLoginView;

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLogin = new LoginOperate();
        this.iLoginView = iLoginView;
    }

    public void handleInvalidData() {
        int checkLoginData = iLogin.checkLoginData(iLoginView.getEmail(), iLoginView.getPassword());
        switch (checkLoginData) {
            case 0:
                iLoginView.onEmailEmpty();
                break;
            case 1:
                iLoginView.onEmailInvalid();
                break;
            case 2:
                iLoginView.onPasswordEmpty();
                break;
            case 3:
                iLoginView.onPasswordInvalid();
                break;
            case 4:
                attempLogin(iLoginView.getEmail(), iLoginView.getPassword());
                //检查账号密码
                break;

        }
    }

    private boolean attempLogin(String email, String password) {
        if (mAuthTask != null) {
            mAuthTask = null;
        }
        mAuthTask = new UserLoginTask(email, password);
        mAuthTask.execute((Void) null);
        return false;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    private class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            iLoginView.showProgress();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            iLoginView.cancleProgress();
            if (success) {
                iLoginView.onLoginSuccess();
            } else {
                iLoginView.onLoginFail();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            iLoginView.onLoginFail();
        }
    }
}
