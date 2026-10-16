package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f6006a;

    /* renamed from: b, reason: collision with root package name */
    private String f6007b;

    public static class a implements Parcelable.Creator<BusinessArea> {
        @Override // android.os.Parcelable.Creator
        public BusinessArea createFromParcel(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BusinessArea[] newArray(int i3) {
            return new BusinessArea[i3];
        }
    }

    public BusinessArea() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f6006a;
    }

    public String getName() {
        return this.f6007b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f6006a = latLonPoint;
    }

    public void setName(String str) {
        this.f6007b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f6006a, i3);
        parcel.writeString(this.f6007b);
    }

    public BusinessArea(Parcel parcel) {
        this.f6006a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6007b = parcel.readString();
    }
}
