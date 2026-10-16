package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6048a;

    /* renamed from: b, reason: collision with root package name */
    private String f6049b;

    /* renamed from: c, reason: collision with root package name */
    private float f6050c;

    /* renamed from: d, reason: collision with root package name */
    private String f6051d;
    private LatLonPoint e;

    public static class a implements Parcelable.Creator<RegeocodeRoad> {
        @Override // android.os.Parcelable.Creator
        public RegeocodeRoad createFromParcel(Parcel parcel) {
            return new RegeocodeRoad(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RegeocodeRoad[] newArray(int i3) {
            return null;
        }
    }

    public /* synthetic */ RegeocodeRoad(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f6051d;
    }

    public float getDistance() {
        return this.f6050c;
    }

    public String getId() {
        return this.f6048a;
    }

    public LatLonPoint getLatLngPoint() {
        return this.e;
    }

    public String getName() {
        return this.f6049b;
    }

    public void setDirection(String str) {
        this.f6051d = str;
    }

    public void setDistance(float f2) {
        this.f6050c = f2;
    }

    public void setId(String str) {
        this.f6048a = str;
    }

    public void setLatLngPoint(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setName(String str) {
        this.f6049b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6048a);
        parcel.writeString(this.f6049b);
        parcel.writeFloat(this.f6050c);
        parcel.writeString(this.f6051d);
        parcel.writeValue(this.e);
    }

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f6048a = parcel.readString();
        this.f6049b = parcel.readString();
        this.f6050c = parcel.readFloat();
        this.f6051d = parcel.readString();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
