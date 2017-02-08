package com.tm.example.mymvptest.model;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.tm.example.mymvptest.R;

/**
 * Created by Tian on 2017/2/7.
 */

public class LoginOperate implements ILogin {
    private static final String TAG = "LoginOperate";

    private static final int EMAIL_EMPTY = 0;
    private static final int EMAIL_INVALID = 1;
    private static final int PASSWORD_EMPTY = 2;
    private static final int PASSWORD_INVALID = 3;
    private static final int DATA_VALID = 4;

    @Override
    public int checkLoginData(String email, String password) {
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            return EMAIL_EMPTY;
        } else if (!isEmailValid(email)) {
            return EMAIL_INVALID;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            return PASSWORD_EMPTY;
        } else if (!isPasswordValid(password)) {
            return PASSWORD_INVALID;
        }
        return DATA_VALID;
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


}
