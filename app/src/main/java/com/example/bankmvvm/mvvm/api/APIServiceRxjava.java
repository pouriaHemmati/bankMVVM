package com.example.bankmvvm.mvvm.api;

import com.example.bankmvvm.mvvm.bank.repository.GetBankResponce;

import io.reactivex.rxjava3.core.Observable;


import retrofit2.Response;
import retrofit2.http.GET;


public interface APIServiceRxjava {

    @GET("Api/ApiGlobal/GetAllBank")
    Observable<Response<GetBankResponce>> getBank();


}
