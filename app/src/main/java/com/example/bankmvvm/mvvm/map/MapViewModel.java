package com.example.bankmvvm.mvvm.map;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bankmvvm.mvvm.bank.model.BankModel;
import com.example.bankmvvm.utils.LocationUtil;

import java.util.ArrayList;

public class MapViewModel extends ViewModel {
    private MutableLiveData<double[]> locationMutableLiveData = new MutableLiveData<>();

    public void getCurrentLocation(Context context)
    {
        LocationUtil locationProvider =new LocationUtil(context);
        double[] doubles =  new double[]{locationProvider.getLatitude() , locationProvider.getLongitude()};
        locationMutableLiveData.postValue(doubles);
    }

    public LiveData<double[]> getMyLocation(){
        return locationMutableLiveData;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
