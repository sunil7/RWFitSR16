package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBinding2cFieldOrMethod;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public final class ArcOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f5724a;
    private LatLng endpoint;
    private LatLng passedpoint;
    private LatLng startpoint;
    private float strokeWidth = 10.0f;
    private int strokeColor = -16777216;
    private float zIndex = 0.0f;
    private boolean isVisible = true;

    public ArcOptions() {
        this.type = "ArcOptions";
    }

    @Override // android.os.Parcelable
    @JBinding2cFieldOrMethod
    public int describeContents() {
        return 0;
    }

    public LatLng getEnd() {
        return this.endpoint;
    }

    public LatLng getPassed() {
        return this.passedpoint;
    }

    public LatLng getStart() {
        return this.startpoint;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.startpoint = latLng;
        this.passedpoint = latLng2;
        this.endpoint = latLng3;
        return this;
    }

    public ArcOptions strokeColor(int i3) {
        this.strokeColor = i3;
        return this;
    }

    public ArcOptions strokeWidth(float f2) {
        this.strokeWidth = f2;
        return this;
    }

    public ArcOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    @Override // android.os.Parcelable
    @JBindingExclude
    public void writeToParcel(Parcel parcel, int i3) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.startpoint;
        if (latLng != null) {
            bundle.putDouble("startlat", latLng.latitude);
            bundle.putDouble("startlng", this.startpoint.longitude);
        }
        LatLng latLng2 = this.passedpoint;
        if (latLng2 != null) {
            bundle.putDouble("passedlat", latLng2.latitude);
            bundle.putDouble("passedlng", this.passedpoint.longitude);
        }
        LatLng latLng3 = this.endpoint;
        if (latLng3 != null) {
            bundle.putDouble("endlat", latLng3.latitude);
            bundle.putDouble("endlng", this.endpoint.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f5724a);
    }

    public ArcOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ArcOptions m5clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        ArcOptions arcOptions = new ArcOptions();
        arcOptions.f5724a = this.f5724a;
        arcOptions.startpoint = this.startpoint;
        arcOptions.passedpoint = this.passedpoint;
        arcOptions.endpoint = this.endpoint;
        arcOptions.strokeWidth = this.strokeWidth;
        arcOptions.strokeColor = this.strokeColor;
        arcOptions.zIndex = this.zIndex;
        arcOptions.isVisible = this.isVisible;
        return arcOptions;
    }
}
