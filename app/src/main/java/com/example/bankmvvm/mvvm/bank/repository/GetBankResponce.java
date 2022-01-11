package com.example.bankmvvm.mvvm.bank.repository;

import com.example.bankmvvm.mvvm.api.BaseResponse;
import com.example.bankmvvm.mvvm.bank.model.BankModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetBankResponce extends BaseResponse {
    @SerializedName("Data")
    @Expose
    private List<BankModel> getBankModels = null;

    public List<BankModel> getGetBankModels() {
        return getBankModels;
    }

    public void setGetBankModels(List<BankModel> getBankModels) {
        this.getBankModels = getBankModels;
    }
}
