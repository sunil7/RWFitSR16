package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private double f5931a;

    /* renamed from: b, reason: collision with root package name */
    private double f5932b;

    public static class a implements Parcelable.Creator<LatLonPoint> {
        @Override // android.os.Parcelable.Creator
        public LatLonPoint createFromParcel(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LatLonPoint[] newArray(int i3) {
            return new LatLonPoint[i3];
        }
    }

    public LatLonPoint(double d5, double d8) {
        this.f5931a = d5;
        this.f5932b = d8;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f5931a, this.f5932b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.f5931a) == Double.doubleToLongBits(latLonPoint.f5931a) && Double.doubleToLongBits(this.f5932b) == Double.doubleToLongBits(latLonPoint.f5932b);
    }

    public double getLatitude() {
        return this.f5931a;
    }

    public double getLongitude() {
        return this.f5932b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f5931a);
        int i3 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f5932b);
        return (i3 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public void setLatitude(double d5) {
        this.f5931a = d5;
    }

    public void setLongitude(double d5) {
        this.f5932b = d5;
    }

    public String toString() {
        return "" + this.f5931a + Const.STR_MART_COMMA + this.f5932b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeDouble(this.f5931a);
        parcel.writeDouble(this.f5932b);
    }

    public LatLonPoint(Parcel parcel) {
        this.f5931a = parcel.readDouble();
        this.f5932b = parcel.readDouble();
    }
}
