package com.example.bankmvvm.mvvm.bank;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bankmvvm.mvvm.bank.model.BankModel;
import com.example.bankmvvm.mvvm.bank.repository.GetBankResponce;
import com.example.bankmvvm.mvvm.bank.repository.RepositoryBank;
import com.example.bankmvvm.mvvm.base.BaseApp;
import com.example.bankmvvm.mvvm.local.bank.BankDataBase;
import com.example.bankmvvm.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import retrofit2.Response;


public class BankViewModel extends ViewModel {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<BankModel>> listMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorMutableLiveData = new MutableLiveData<>();
    private RepositoryBank repositoryBank = RepositoryBank.getInstance();
    private NetworkUtils networkUtils = new NetworkUtils();

    public void getListMutableLiveData(Context context) {

        if (networkUtils.isConnected(context)) {
            Log.i("MyData", "NetworkOperatorName" + networkUtils.getNetworkOperatorName(context));
            Log.i("MyData", "NetworkOperatorName" + networkUtils.getIPAddress(true));
            Log.i("MyData", "NetworkOperatorName" + networkUtils.getNetworkType(context));
            repositoryBank.getAllBank().subscribe(new Observer<Response<GetBankResponce>>() {
                @Override
                public void onSubscribe(Disposable d) {
                    compositeDisposable.add(d);
                }

                @Override
                public void onNext(Response<GetBankResponce> value) {
                    assert value.body() != null;
                    repositoryBank.deleteAll()
                            .subscribe(new SingleObserver<Integer>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {
                                    compositeDisposable.add(d);
                                }
                                @Override
                                public void onSuccess(@NonNull Integer integer) {
                                    if (integer == 0)
                                        onError(new Throwable());
                                    else {
                                        insertAll(value.body().getGetBankModels());
                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {
                                    errorMutableLiveData.postValue(e.getMessage());
                                }
                            });
                }

                @Override
                public void onError(Throwable e) {
                    errorMutableLiveData.postValue(e.getMessage());
                }

                @Override
                public void onComplete() {

                }
            });

        } else {
            repositoryBank.getAllBankDataBase().subscribe(new Observer<List<BankModel>>() {
                @Override
                public void onSubscribe(Disposable d) {
                    compositeDisposable.add(d);
                }

                @Override
                public void onNext(List<BankModel> value) {
                    listMutableLiveData.postValue(new ArrayList<>(value));
                }

                @Override
                public void onError(Throwable e) {
                    errorMutableLiveData.postValue(e.getMessage());
                }

                @Override
                public void onComplete() {

                }
            });
        }

    }

    private void insertAll(List<BankModel> bankModels) {
        repositoryBank.insertAll(bankModels).subscribe(new SingleObserver<Long[]>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(@NonNull Long[] aLong) {
                listMutableLiveData.postValue(bankModels);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                errorMutableLiveData.postValue(e.getMessage());
            }
        });

    }

    public LiveData<String> errorMassage() {
        return errorMutableLiveData;
    }

    public LiveData<List<BankModel>> getListBankLiveData() {
        return listMutableLiveData;
    }

    public void clearRam() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
        compositeDisposable.clear();
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
