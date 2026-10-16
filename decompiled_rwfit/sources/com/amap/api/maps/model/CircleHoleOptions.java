package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {

    @JBindingExclude
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new a();
    private LatLng point;
    private double radius;

    public static class a implements Parcelable.Creator<CircleHoleOptions> {
        @Override // android.os.Parcelable.Creator
        public CircleHoleOptions createFromParcel(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CircleHoleOptions[] newArray(int i3) {
            return new CircleHoleOptions[i3];
        }
    }

    public CircleHoleOptions() {
        this.point = null;
        this.radius = 0.0d;
        this.isPolygonHoleOptions = false;
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions radius(double d5) {
        this.radius = d5;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble(Const.JSON_KEY_LAT, latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }

    @JBindingExclude
    public CircleHoleOptions(Parcel parcel) {
        this.point = null;
        this.radius = 0.0d;
        Bundle readBundle = parcel.readBundle();
        this.point = new LatLng(readBundle.getDouble(Const.JSON_KEY_LAT), readBundle.getDouble("lng"));
        this.radius = parcel.readDouble();
    }
}
