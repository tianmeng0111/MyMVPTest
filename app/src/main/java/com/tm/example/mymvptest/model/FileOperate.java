package com.tm.example.mymvptest.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.tm.example.mymvptest.activity.MainActivity;

/**
 * Created by Tian on 2017/2/6.
 */

public class FileOperate implements IGetString {
    private static final String TAG = "FileOperate";

    @Override
    public String getName() {
        String name;
        SharedPreferences sharedPreferences = MainActivity.getContext()
                .getSharedPreferences("tmData", Context.MODE_PRIVATE);
        name = sharedPreferences.getString("name", "");
        Log.e(TAG, "getName: " + name);
        return name;
    }

    @Override
    public void saveName(String name) {
        SharedPreferences sharedPreferences = MainActivity.getContext()
                .getSharedPreferences("tmData", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("name", name);
        edit.commit();
        Log.e(TAG, "saveName: " + name);
    }
}
