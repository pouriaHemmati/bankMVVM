package com.example.bankmvvm.mvvm.map;

import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.location.LocationEngineResult;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.lang.ref.WeakReference;

public  class MyLocationCallback implements LocationEngineCallback<LocationEngineResult> {
    private final WeakReference<Map> activityWeakReference;
    MyLocationCallback(Map activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }
    /**
     * The LocationEngineCallback interface's method which fires when the device's location has changed.
     *
     * @param result the LocationEngineResult object which has the last known location within it.
     */
    @Override
    public void onSuccess(LocationEngineResult result) {
        Map activity = activityWeakReference.get();
        if (activity != null) {
            Location location = result.getLastLocation();
            if (location == null)
                return;
            // Here you access last know location
            activity.lastKnowLatLng = new LatLng(location.getLatitude(), location.getLongitude());
            Toast.makeText(activity, activity.lastKnowLatLng.getLatitude() + ", " + activity.lastKnowLatLng.getLongitude(), Toast.LENGTH_SHORT).show();
            // Pass the new location to the Mapir SDK's LocationComponent
            if (activity.map != null && result.getLastLocation() != null)
                activity.map.getLocationComponent().forceLocationUpdate(result.getLastLocation());
        }
    }
    /**
     * The LocationEngineCallback interface's method which fires when the device's location can not be captured
     *
     * @param exception the exception message
     */
    @Override
    public void onFailure(@NonNull Exception exception) {
        Log.d("LocationChangeActivity", exception.getLocalizedMessage());
        Map activity = activityWeakReference.get();
        if (activity != null)
            Toast.makeText(activity, exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}

