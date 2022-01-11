package com.example.bankmvvm.mvvm.local.bank;

import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.bankmvvm.mvvm.bank.model.BankModel;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;


@Dao
public interface BankDao {

    @Query("Select * From BankModel")
    Observable<List<BankModel>> getAllBank();

    @Delete
     void deleteUser(BankModel user);

    @Query("DELETE FROM BankModel")
    Single<Integer> delete();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long[]> insertBanks(List<BankModel> models);

}
