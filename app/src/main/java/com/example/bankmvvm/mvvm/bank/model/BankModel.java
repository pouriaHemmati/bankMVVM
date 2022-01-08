package com.example.bankmvvm.mvvm.bank.model;

import android.util.Log;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankModel {
    @SerializedName("ccBank")
    @Expose
    private Integer BankID;
    @SerializedName("NameBank")
    @Expose
    private String nameBank;
    @SerializedName("CodeBankInsheba")
    @Expose
    private String codeBankInsheba;

    public Integer getBankID() {
        return BankID;
    }

    public void setBankID(Integer bankID) {
        BankID = bankID;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getCodeBankInsheba() {
        return codeBankInsheba;
    }

    public void setCodeBankInsheba(String codeBankInsheba) {
        this.codeBankInsheba = codeBankInsheba;
    }

}
