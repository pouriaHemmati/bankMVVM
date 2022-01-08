package com.example.bankmvvm.mvvm.bank.repository;

import com.example.bankmvvm.mvvm.api.BaseResponse;
import com.example.bankmvvm.mvvm.bank.model.BankModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetBankResponce extends BaseResponse {
    @SerializedName("Data")
    @Expose
    private ArrayList<BankModel> getBankModels = null;

    public ArrayList<BankModel> getGetBankModels() {
        return getBankModels;
    }

    public void setGetBankModels(ArrayList<BankModel> getBankModels) {
        this.getBankModels = getBankModels;
    }
}
