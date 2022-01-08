package com.example.bankmvvm.mvvm.bank;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.bankmvvm.mvvm.api.RetrofitResponse;
import com.example.bankmvvm.mvvm.bank.model.BankModel;
import com.example.bankmvvm.mvvm.bank.repository.RepositoryBank;
import java.util.ArrayList;
import io.reactivex.disposables.CompositeDisposable;


public class BankViewModel extends ViewModel {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<ArrayList<BankModel>> listMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorMutableLiveData = new MutableLiveData<>();
    private RepositoryBank repositoryBank = RepositoryBank.getInstance();
    public void getListMutableLiveData(){
        repositoryBank.getAllBank(compositeDisposable, new RetrofitResponse() {
            @Override
            public void onSuccess(ArrayList arrayListData) {
                listMutableLiveData.postValue(arrayListData);
            }

            @Override
            public void onFailed(String error) {
                errorMutableLiveData.postValue(error);
            }
        });
    }

    public LiveData<String> errorMassage(){
        return errorMutableLiveData;
    }

    public LiveData<ArrayList<BankModel>> getListBankLiveData(){
        return listMutableLiveData;
    }
    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
