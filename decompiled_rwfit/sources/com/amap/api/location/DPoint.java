package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private double f5680a;

    /* renamed from: b, reason: collision with root package name */
    private double f5681b;

    public static class a implements Parcelable.Creator<DPoint> {
        @Override // android.os.Parcelable.Creator
        public DPoint createFromParcel(Parcel parcel) {
            return new DPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DPoint[] newArray(int i3) {
            return new DPoint[i3];
        }
    }

    public DPoint() {
        this.f5680a = 0.0d;
        this.f5681b = 0.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return this.f5681b == dPoint.f5681b && this.f5680a == dPoint.f5680a;
    }

    public double getLatitude() {
        return this.f5681b;
    }

    public double getLongitude() {
        return this.f5680a;
    }

    public int hashCode() {
        return Double.valueOf((this.f5681b + this.f5680a) * 1000000.0d).intValue();
    }

    public void setLatitude(double d5) {
        if (d5 > 90.0d) {
            d5 = 90.0d;
        }
        if (d5 < -90.0d) {
            d5 = -90.0d;
        }
        this.f5681b = d5;
    }

    public void setLongitude(double d5) {
        if (d5 > 180.0d) {
            d5 = 180.0d;
        }
        if (d5 < -180.0d) {
            d5 = -180.0d;
        }
        this.f5680a = d5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeDouble(this.f5680a);
        parcel.writeDouble(this.f5681b);
    }

    public DPoint(double d5, double d8) {
        this.f5680a = 0.0d;
        this.f5681b = 0.0d;
        d8 = d8 > 180.0d ? 180.0d : d8;
        d8 = d8 < -180.0d ? -180.0d : d8;
        d5 = d5 > 90.0d ? 90.0d : d5;
        d5 = d5 < -90.0d ? -90.0d : d5;
        this.f5680a = d8;
        this.f5681b = d5;
    }

    public DPoint(Parcel parcel) {
        this.f5680a = 0.0d;
        this.f5681b = 0.0d;
        this.f5680a = parcel.readDouble();
        this.f5681b = parcel.readDouble();
    }
}
