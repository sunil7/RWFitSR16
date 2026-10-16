package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f6447a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6448b;

    /* renamed from: c, reason: collision with root package name */
    private float f6449c;

    /* renamed from: d, reason: collision with root package name */
    private float f6450d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6451f;

    public static class a implements Parcelable.Creator<TaxiItem> {
        @Override // android.os.Parcelable.Creator
        public TaxiItem createFromParcel(Parcel parcel) {
            return new TaxiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TaxiItem[] newArray(int i3) {
            return new TaxiItem[i3];
        }
    }

    public TaxiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f6448b;
    }

    public float getDistance() {
        return this.f6449c;
    }

    public float getDuration() {
        return this.f6450d;
    }

    public LatLonPoint getOrigin() {
        return this.f6447a;
    }

    public String getmSname() {
        return this.e;
    }

    public String getmTname() {
        return this.f6451f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f6448b = latLonPoint;
    }

    public void setDistance(float f2) {
        this.f6449c = f2;
    }

    public void setDuration(float f2) {
        this.f6450d = f2;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f6447a = latLonPoint;
    }

    public void setSname(String str) {
        this.e = str;
    }

    public void setTname(String str) {
        this.f6451f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f6447a, i3);
        parcel.writeParcelable(this.f6448b, i3);
        parcel.writeFloat(this.f6449c);
        parcel.writeFloat(this.f6450d);
        parcel.writeString(this.e);
        parcel.writeString(this.f6451f);
    }

    public TaxiItem(Parcel parcel) {
        this.f6447a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6448b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6449c = parcel.readFloat();
        this.f6450d = parcel.readFloat();
        this.e = parcel.readString();
        this.f6451f = parcel.readString();
    }
}
