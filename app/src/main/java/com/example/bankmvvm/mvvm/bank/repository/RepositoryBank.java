package com.example.bankmvvm.mvvm.bank.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bankmvvm.mvvm.api.APIServiceRxjava;
import com.example.bankmvvm.mvvm.api.ApiClient;
import com.example.bankmvvm.mvvm.api.RetrofitResponse;
import com.example.bankmvvm.mvvm.bank.model.BankModel;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RepositoryBank {

    APIServiceRxjava apiServiceRxjava = ApiClient.getInstance().getApiServiceRxjava();
    private static RepositoryBank instance;

    public static RepositoryBank getInstance() {
        if (instance == null)
            instance = new RepositoryBank();
        return instance;
    }

    public void getAllBank(CompositeDisposable compositeDisposable,RetrofitResponse response) {

        apiServiceRxjava.getBank()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Response<GetBankResponce>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Response<GetBankResponce> getBankResponceResponse) {
                        if (getBankResponceResponse.body().getSuccess()){
                            response.onSuccess(getBankResponceResponse.body().getGetBankModels());
                        } else {
                            response.onFailed(getBankResponceResponse.body().getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        response.onFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        if (!compositeDisposable.isDisposed()) {
                            compositeDisposable.dispose();
                        }
                        compositeDisposable.clear();
                    }
                });
    }


}
