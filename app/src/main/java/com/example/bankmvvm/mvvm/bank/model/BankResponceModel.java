package com.example.bankmvvm.mvvm.bank.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BankResponceModel {
    @SerializedName("Data")
    @Expose
    private ArrayList<BankModel> data = null;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Success")
    @Expose
    private boolean success;
    @SerializedName("HasPermission")
    @Expose
    private boolean hasPermission;
    @SerializedName("TotalCount")
    @Expose
    private int totalCount;

    public ArrayList<BankModel> getData() {
        return data;
    }

    public void setData(ArrayList<BankModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
