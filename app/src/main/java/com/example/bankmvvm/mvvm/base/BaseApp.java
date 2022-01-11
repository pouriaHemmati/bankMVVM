package com.example.bankmvvm.mvvm.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.bankmvvm.mvvm.local.bank.BankDataBase;

import ir.map.sdk_map.Mapir;

public class BaseApp extends Application {
    private static BaseApp instance = null;
    private static Context context;
    private static Activity currentActivity;
    private BankDataBase bankDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        Mapir.getInstance(this, "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjhiNjYzYTJhZDU5MThlYzM5ZmE1YTNjM2NlOGIxMGZmNDliMGU0MGEyMjkxZDkxNGM5YjQ0MWU1NDIxNTViNTQxZTE2YWNhNzE1N2IwZGFkIn0.eyJhdWQiOiIxNjUyOSIsImp0aSI6IjhiNjYzYTJhZDU5MThlYzM5ZmE1YTNjM2NlOGIxMGZmNDliMGU0MGEyMjkxZDkxNGM5YjQ0MWU1NDIxNTViNTQxZTE2YWNhNzE1N2IwZGFkIiwiaWF0IjoxNjQxMTA3NTA3LCJuYmYiOjE2NDExMDc1MDcsImV4cCI6MTY0MzYxMzEwNywic3ViIjoiIiwic2NvcGVzIjpbImJhc2ljIl19.i4bsXZrlYBS0-1s57TWYfi-RUjCKlA4uuWoqzSgyi2YgjnLiI8wGJbdI7ygADPUVGAx57mjg0bpNCf97zZkXg1YUGUsyllcSgjLHUsgBp1jj8JHwWguw_-weQuHi_LTTWEGg4EEu0m6u7cvfgNXIbcJk_g5S2kcMiWhNTUgsEMEfloM9h2wNT2U7CDQBc2Q-9VPK0KtHP9EQ0UH-LRxFXTPdJ3iXNWUHDGPCJT5lXTezCd2oAKgAzarUxdsxmJkp8w9wDzALBJRnAWxT6Gb5yPjj9oOr9R28c2t4zS4Cba4eUQ4Y8j2dSerbJlrO-fK34OmnCkOUwASgCPw6qgjuBQ");

        bankDataBase = Room.databaseBuilder(this, BankDataBase.class, BankDataBase.nameDataBase).build();


    }

    public BankDataBase getBankDataBase() {
        return bankDataBase;
    }

    /**
     * get current context anywhere in app
     * @return just use BaseApplication.getContext
     */
    public  Context getContext() {
        if (currentActivity != null) {
            return currentActivity;
        }
        return context;
    }

    public  Context getCurrentActivity() {
        return currentActivity;
    }

    public  void setCurrentActivity(Activity activity) {
        currentActivity = activity;
    }

    public static synchronized BaseApp getInstance() {
        if (instance == null) {
            instance = new BaseApp();
        }
        return instance;
    }
}
