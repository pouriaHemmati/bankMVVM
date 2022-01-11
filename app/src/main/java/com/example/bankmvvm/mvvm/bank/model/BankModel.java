package com.example.bankmvvm.mvvm.bank.model;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class BankModel {

    @ColumnInfo
    @PrimaryKey(autoGenerate=true)
    private Long id;
    @ColumnInfo
    @SerializedName("ccBank")
    @Expose
    private int BankID;
    @ColumnInfo
    @SerializedName("NameBank")
    @Expose
    private String nameBank;
    @ColumnInfo
    @SerializedName("CodeBankInsheba")
    @Expose
    private String codeBankInsheba;

    public int getBankID() {
        return BankID;
    }

    public void setBankID(int bankID) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
