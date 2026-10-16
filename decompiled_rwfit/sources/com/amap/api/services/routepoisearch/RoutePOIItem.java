package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6501a;

    /* renamed from: b, reason: collision with root package name */
    private String f6502b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6503c;

    /* renamed from: d, reason: collision with root package name */
    private float f6504d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private String f6505f;

    public static class a implements Parcelable.Creator<RoutePOIItem> {
        @Override // android.os.Parcelable.Creator
        public RoutePOIItem createFromParcel(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RoutePOIItem[] newArray(int i3) {
            return new RoutePOIItem[i3];
        }
    }

    public RoutePOIItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCPID() {
        return this.f6505f;
    }

    public float getDistance() {
        return this.f6504d;
    }

    public float getDuration() {
        return this.e;
    }

    public String getID() {
        return this.f6501a;
    }

    public LatLonPoint getPoint() {
        return this.f6503c;
    }

    public String getTitle() {
        return this.f6502b;
    }

    public void setCPID(String str) {
        this.f6505f = str;
    }

    public void setDistance(float f2) {
        this.f6504d = f2;
    }

    public void setDuration(float f2) {
        this.e = f2;
    }

    public void setID(String str) {
        this.f6501a = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f6503c = latLonPoint;
    }

    public void setTitle(String str) {
        this.f6502b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6501a);
        parcel.writeString(this.f6502b);
        parcel.writeParcelable(this.f6503c, i3);
        parcel.writeFloat(this.f6504d);
        parcel.writeFloat(this.e);
        parcel.writeString(this.f6505f);
    }

    public RoutePOIItem(Parcel parcel) {
        this.f6501a = parcel.readString();
        this.f6502b = parcel.readString();
        this.f6503c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6504d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f6505f = parcel.readString();
    }
}
