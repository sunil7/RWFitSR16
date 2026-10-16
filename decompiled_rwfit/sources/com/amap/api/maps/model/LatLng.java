package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public final class LatLng implements Parcelable, Cloneable {

    @JBindingExclude
    public static final LatLngCreator CREATOR = new LatLngCreator();
    public final double latitude;
    public final double longitude;

    public LatLng(double d5, double d8) {
        this(d5, d8, true);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i3 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i3 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + Const.STR_MART_COMMA + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }

    @JBindingExclude
    public LatLng(double d5, double d8, boolean z5) {
        if (!z5) {
            this.latitude = d5;
            this.longitude = d8;
            return;
        }
        if (-180.0d > d8 || d8 >= 180.0d) {
            this.longitude = ((((d8 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.longitude = d8;
        }
        if (d5 < -90.0d || d5 > 90.0d) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e) {
                e.printStackTrace();
            }
        }
        this.latitude = Math.max(-90.0d, Math.min(90.0d, d5));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LatLng m10clone() {
        return new LatLng(this.latitude, this.longitude);
    }
}
