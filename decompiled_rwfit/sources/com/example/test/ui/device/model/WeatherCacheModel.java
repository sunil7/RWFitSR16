package com.example.test.ui.device.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WeatherCacheModel implements Parcelable {
    public static final Parcelable.Creator<WeatherCacheModel> CREATOR = new Parcelable.Creator<WeatherCacheModel>() { // from class: com.example.test.ui.device.model.WeatherCacheModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeatherCacheModel createFromParcel(Parcel parcel) {
            return new WeatherCacheModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeatherCacheModel[] newArray(int i3) {
            return new WeatherCacheModel[i3];
        }
    };
    private float lat;
    private float lng;

    public WeatherCacheModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getLat() {
        return this.lat;
    }

    public float getLng() {
        return this.lng;
    }

    public void setLat(float f2) {
        this.lat = f2;
    }

    public void setLng(float f2) {
        this.lng = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.lat);
        parcel.writeFloat(this.lng);
    }

    public WeatherCacheModel(Parcel parcel) {
        this.lat = parcel.readFloat();
        this.lng = parcel.readFloat();
    }
}
