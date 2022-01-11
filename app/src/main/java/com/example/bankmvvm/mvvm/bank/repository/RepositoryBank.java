package com.example.bankmvvm.mvvm.bank.repository;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

import com.example.bankmvvm.mvvm.api.APIServiceRxjava;
import com.example.bankmvvm.mvvm.api.ApiClient;
import com.example.bankmvvm.mvvm.bank.model.BankModel;
import com.example.bankmvvm.mvvm.base.BaseApp;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;


public class RepositoryBank {

    APIServiceRxjava apiServiceRxjava = ApiClient.getInstance().getApiServiceRxjava();
    private static RepositoryBank instance;


    public static RepositoryBank getInstance() {
        if (instance == null)
            instance = new RepositoryBank();
        return instance;
    }


    public Observable<Response<GetBankResponce>> getAllBank() {
      return   apiServiceRxjava.getBank()
                .subscribeOn(Schedulers.io());

    }

    public Observable<List<BankModel>> getAllBankDataBase(){
        return ((BaseApp) getApplicationContext()).getBankDataBase().bankDao().getAllBank()
                .subscribeOn(Schedulers.io());

    }

    public Single<Integer> deleteAll(){
        return  ((BaseApp) getApplicationContext()).getBankDataBase().bankDao().delete();
    }

    public Single<Long[]> insertAll(List<BankModel> models){
         return  ((BaseApp) getApplicationContext()).getBankDataBase().bankDao().insertBanks(models);

    }


}
