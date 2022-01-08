package com.example.bankmvvm.mvvm.api;

import java.util.ArrayList;

public interface RetrofitResponse {
    void onSuccess(ArrayList arrayListData);

    void onFailed(String error);
}
