package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6000a;

    /* renamed from: b, reason: collision with root package name */
    private String f6001b;

    /* renamed from: c, reason: collision with root package name */
    private String f6002c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f6003d;
    private Float e;

    /* renamed from: f, reason: collision with root package name */
    private float f6004f;

    /* renamed from: g, reason: collision with root package name */
    private String f6005g;

    public static class a implements Parcelable.Creator<AoiItem> {
        @Override // android.os.Parcelable.Creator
        public AoiItem createFromParcel(Parcel parcel) {
            return new AoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AoiItem[] newArray(int i3) {
            return new AoiItem[i3];
        }
    }

    public AoiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f6002c;
    }

    public Float getAoiArea() {
        return this.e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.f6003d;
    }

    public String getAoiId() {
        return this.f6000a;
    }

    public String getAoiName() {
        return this.f6001b;
    }

    public float getDistance() {
        return this.f6004f;
    }

    public String getType() {
        return this.f6005g;
    }

    public void setAdcode(String str) {
        this.f6002c = str;
    }

    public void setArea(Float f2) {
        this.e = f2;
    }

    public void setDistance(float f2) {
        this.f6004f = f2;
    }

    public void setId(String str) {
        this.f6000a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f6003d = latLonPoint;
    }

    public void setName(String str) {
        this.f6001b = str;
    }

    public void setType(String str) {
        this.f6005g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6000a);
        parcel.writeString(this.f6001b);
        parcel.writeString(this.f6002c);
        parcel.writeParcelable(this.f6003d, i3);
        parcel.writeFloat(this.e.floatValue());
        parcel.writeFloat(this.f6004f);
        parcel.writeString(this.f6005g);
    }

    public AoiItem(Parcel parcel) {
        this.f6000a = parcel.readString();
        this.f6001b = parcel.readString();
        this.f6002c = parcel.readString();
        this.f6003d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = Float.valueOf(parcel.readFloat());
        this.f6004f = parcel.readFloat();
        this.f6005g = parcel.readString();
    }
}
