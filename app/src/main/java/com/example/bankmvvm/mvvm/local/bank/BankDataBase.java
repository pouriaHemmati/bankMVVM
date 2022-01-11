package com.example.bankmvvm.mvvm.local.bank;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bankmvvm.mvvm.bank.model.BankModel;

@Database(entities={BankModel.class}, version=1)
public abstract class BankDataBase extends RoomDatabase {
    public abstract BankDao bankDao();
    public static final String nameDataBase = "BankDataBase";
}
