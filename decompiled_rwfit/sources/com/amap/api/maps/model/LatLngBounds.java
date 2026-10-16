package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.p0003sl.v4;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        public LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                Log.w(LatLngBounds.CLASSNAME, "no included points");
                return null;
            }
            double d5 = this.mWest;
            double d8 = this.mEast;
            if (d5 > d8) {
                this.mWest = d8;
                this.mEast = d5;
            }
            double d10 = this.mSouth;
            double d11 = this.mNorth;
            if (d10 > d11) {
                this.mSouth = d11;
                this.mNorth = d10;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d5 = latLng.longitude;
            if (Double.isNaN(this.mWest)) {
                this.mWest = d5;
                this.mEast = d5;
                return this;
            }
            double d8 = this.mWest;
            double d10 = this.mEast;
            if (d8 > d10 ? !(d8 <= d5 || d5 <= d10) : !(d8 <= d5 && d5 <= d10)) {
                LatLngBoundsCreator latLngBoundsCreator = LatLngBounds.CREATOR;
                if (((d8 - d5) + 360.0d) % 360.0d < ((d5 - d10) + 360.0d) % 360.0d) {
                    this.mWest = d5;
                    return this;
                }
                this.mEast = d5;
            }
            return this;
        }
    }

    public LatLngBounds(int i3, LatLng latLng, LatLng latLng2) {
        boolean z5;
        try {
        } catch (Throwable th2) {
            Log.e(CLASSNAME, "the structure parameters are illegal!");
            th2.printStackTrace();
            z5 = false;
        }
        if (latLng == null) {
            throw new RuntimeRemoteException("null southwest");
        }
        if (latLng2 == null) {
            throw new RuntimeRemoteException("null northeast");
        }
        if (latLng2.latitude >= latLng.latitude) {
            z5 = true;
            this.mVersionCode = z5 ? i3 : 0;
            this.southwest = z5 ? latLng : null;
            this.northeast = z5 ? latLng2 : null;
            return;
        }
        throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
    }

    public static Builder builder() {
        return new Builder();
    }

    public int a() {
        return this.mVersionCode;
    }

    public boolean contains(LatLng latLng) {
        LatLng latLng2;
        if (latLng == null) {
            return false;
        }
        LatLng latLng3 = this.northeast;
        if (latLng3 == null || (latLng2 = this.southwest) == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return false;
        }
        double d5 = latLng.latitude;
        return latLng2.latitude <= d5 && d5 <= latLng3.latitude && a(latLng.longitude);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public int hashCode() {
        Object[] objArr = {this.southwest, this.northeast};
        int i3 = v4.f5181b;
        return Arrays.hashCode(objArr);
    }

    public LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d5;
        if (latLng == null) {
            return this;
        }
        if (this.northeast == null || (latLng2 = this.southwest) == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return this;
        }
        double min = Math.min(latLng2.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d8 = this.northeast.longitude;
        double d10 = this.southwest.longitude;
        double d11 = latLng.longitude;
        try {
            if (!a(d11)) {
                if (((d10 - d11) + 360.0d) % 360.0d >= ((d11 - d8) + 360.0d) % 360.0d) {
                    d5 = d11;
                    return new LatLngBounds(new LatLng(min, d10, false), new LatLng(max, d5, false));
                }
                d10 = d11;
            }
            return new LatLngBounds(new LatLng(min, d10, false), new LatLng(max, d5, false));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return this;
        }
        d5 = d8;
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return a(latLngBounds) || latLngBounds.a(this);
        }
        Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    public String toString() {
        return v4.a(v4.a("southwest", this.southwest), v4.a("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(a());
        parcel.writeParcelable(this.southwest, i3);
        parcel.writeParcelable(this.northeast, i3);
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2 = latLngBounds.northeast;
        if (latLng2 == null || (latLng = latLngBounds.southwest) == null) {
            return false;
        }
        double d5 = latLng2.longitude;
        double d8 = latLng.longitude;
        LatLng latLng3 = this.northeast;
        double d10 = latLng3.longitude;
        LatLng latLng4 = this.southwest;
        double d11 = latLng4.longitude;
        double d12 = ((d5 + d8) - d10) - d11;
        double d13 = ((d10 - d11) + d5) - d8;
        double d14 = latLng2.latitude;
        double d15 = latLng.latitude;
        double d16 = latLng3.latitude;
        double d17 = latLng4.latitude;
        return Math.abs(d12) < d13 && Math.abs(((d14 + d15) - d16) - d17) < ((d16 - d17) + d14) - d15;
    }

    private boolean a(double d5) {
        double d8 = this.southwest.longitude;
        double d10 = this.northeast.longitude;
        return d8 <= d10 ? d8 <= d5 && d5 <= d10 : d8 <= d5 || d5 <= d10;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }
}
