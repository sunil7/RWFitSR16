package com.example.network.bean;

import android.os.Parcel;
import android.os.Parcelable;
import r5.a;

/* loaded from: classes.dex */
public class LocationServerInfoBean implements Parcelable {
    public static final Parcelable.Creator<LocationServerInfoBean> CREATOR = new Parcelable.Creator<LocationServerInfoBean>() { // from class: com.example.network.bean.LocationServerInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationServerInfoBean createFromParcel(Parcel parcel) {
            return new LocationServerInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationServerInfoBean[] newArray(int i3) {
            return new LocationServerInfoBean[i3];
        }
    };
    private String address;
    private double lat;
    private double lng;

    public LocationServerInfoBean(Parcel parcel) {
        this.lat = parcel.readFloat();
        this.lng = parcel.readFloat();
        this.address = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setLat(double d5) {
        this.lat = d5;
    }

    public void setLng(double d5) {
        this.lng = d5;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LocationServerInfoBean{lat=");
        sb2.append(this.lat);
        sb2.append(", lng=");
        sb2.append(this.lng);
        sb2.append(", address='");
        return a.f(sb2, this.address, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeString(this.address);
    }
}
