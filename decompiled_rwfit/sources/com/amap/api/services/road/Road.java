package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6178a;

    /* renamed from: b, reason: collision with root package name */
    private String f6179b;

    /* renamed from: c, reason: collision with root package name */
    private String f6180c;

    /* renamed from: d, reason: collision with root package name */
    private float f6181d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private LatLonPoint f6182f;

    public static class a implements Parcelable.Creator<Road> {
        @Override // android.os.Parcelable.Creator
        public Road createFromParcel(Parcel parcel) {
            return new Road(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Road[] newArray(int i3) {
            return null;
        }
    }

    public Road() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f6182f;
    }

    public String getCityCode() {
        return this.f6180c;
    }

    public String getId() {
        return this.f6178a;
    }

    public String getName() {
        return this.f6179b;
    }

    public float getRoadWidth() {
        return this.f6181d;
    }

    public String getType() {
        return this.e;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f6182f = latLonPoint;
    }

    public void setCityCode(String str) {
        this.f6180c = str;
    }

    public void setId(String str) {
        this.f6178a = str;
    }

    public void setName(String str) {
        this.f6179b = str;
    }

    public void setRoadWidth(float f2) {
        this.f6181d = f2;
    }

    public void setType(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6178a);
        parcel.writeString(this.f6179b);
        parcel.writeString(this.f6180c);
        parcel.writeFloat(this.f6181d);
        parcel.writeString(this.e);
        parcel.writeValue(this.f6182f);
    }

    public Road(String str, String str2) {
        this.f6178a = str;
        this.f6179b = str2;
    }

    public Road(Parcel parcel) {
        this.f6178a = parcel.readString();
        this.f6179b = parcel.readString();
        this.f6180c = parcel.readString();
        this.f6181d = parcel.readFloat();
        this.e = parcel.readString();
        this.f6182f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
