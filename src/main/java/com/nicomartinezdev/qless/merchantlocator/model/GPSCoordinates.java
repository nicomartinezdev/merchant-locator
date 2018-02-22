package com.nicomartinezdev.qless.merchantlocator.model;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
public class GPSCoordinates {

    private double longitude;
    private double latitude;

    public GPSCoordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
