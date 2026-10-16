package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6052a;

    /* renamed from: b, reason: collision with root package name */
    private String f6053b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6054c;

    /* renamed from: d, reason: collision with root package name */
    private String f6055d;
    private float e;

    public static class a implements Parcelable.Creator<StreetNumber> {
        @Override // android.os.Parcelable.Creator
        public StreetNumber createFromParcel(Parcel parcel) {
            return new StreetNumber(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StreetNumber[] newArray(int i3) {
            return null;
        }
    }

    public /* synthetic */ StreetNumber(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f6055d;
    }

    public float getDistance() {
        return this.e;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f6054c;
    }

    public String getNumber() {
        return this.f6053b;
    }

    public String getStreet() {
        return this.f6052a;
    }

    public void setDirection(String str) {
        this.f6055d = str;
    }

    public void setDistance(float f2) {
        this.e = f2;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f6054c = latLonPoint;
    }

    public void setNumber(String str) {
        this.f6053b = str;
    }

    public void setStreet(String str) {
        this.f6052a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6052a);
        parcel.writeString(this.f6053b);
        parcel.writeValue(this.f6054c);
        parcel.writeString(this.f6055d);
        parcel.writeFloat(this.e);
    }

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.f6052a = parcel.readString();
        this.f6053b = parcel.readString();
        this.f6054c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f6055d = parcel.readString();
        this.e = parcel.readFloat();
    }
}
