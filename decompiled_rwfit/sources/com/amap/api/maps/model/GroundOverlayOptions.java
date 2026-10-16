package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public final class GroundOverlayOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    private static final String CLASSNAME = "GroundOverlayOptions";

    @JBindingExclude
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();

    @JBindingExclude
    public static final float NO_DIMENSION = -1.0f;

    @JBindingExclude
    private final double NF_PI;

    @JBindingExclude
    private final double R;
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private float height;
    private boolean isVisible;
    private LatLng latLng;

    @JBindingExclude
    private LatLngBounds latlngBounds;

    @JBindingExclude
    private final int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;
    private float transparency;
    private float width;
    private float zIndex;

    @JBindingExclude
    public GroundOverlayOptions(int i3, LatLng latLng, float f2, float f10, LatLngBounds latLngBounds, float f11, float f12, boolean z5, float f13, float f14, float f15) {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = i3;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = latLng;
        this.width = f2;
        this.height = f10;
        this.latlngBounds = latLngBounds;
        this.bearing = f11;
        this.zIndex = f12;
        this.isVisible = z5;
        this.transparency = f13;
        this.anchorU = f14;
        this.anchorV = f15;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        this.type = CLASSNAME;
    }

    private void a() {
        LatLng latLng = this.latLng;
        if (latLng == null) {
            return;
        }
        double cos = this.width / ((Math.cos(latLng.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
        double d5 = this.height / 111194.94043265979d;
        try {
            LatLng latLng2 = this.latLng;
            LatLng latLng3 = new LatLng(latLng2.latitude - ((1.0f - this.anchorV) * d5), latLng2.longitude - (this.anchorU * cos));
            LatLng latLng4 = this.latLng;
            LatLngBounds latLngBounds = new LatLngBounds(latLng3, new LatLng((this.anchorV * d5) + latLng4.latitude, ((1.0f - this.anchorU) * cos) + latLng4.longitude));
            this.latlngBounds = latLngBounds;
            this.southwest = latLngBounds.southwest;
            this.northeast = latLngBounds.northeast;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void b() {
        if (this.southwest == null || this.northeast == null) {
            return;
        }
        LatLng latLng = this.southwest;
        double d5 = latLng.latitude;
        double d8 = 1.0f - this.anchorV;
        LatLng latLng2 = this.northeast;
        double d10 = ((latLng2.latitude - d5) * d8) + d5;
        double d11 = latLng.longitude;
        LatLng latLng3 = new LatLng(d10, ((latLng2.longitude - d11) * this.anchorU) + d11);
        this.latLng = latLng3;
        double cos = Math.cos(latLng3.latitude * 0.01745329251994329d) * 6371000.79d;
        LatLng latLng4 = this.northeast;
        double d12 = latLng4.longitude;
        LatLng latLng5 = this.southwest;
        this.width = (float) ((d12 - latLng5.longitude) * cos * 0.01745329251994329d);
        this.height = (float) ((latLng4.latitude - latLng5.latitude) * 6371000.79d * 0.01745329251994329d);
    }

    public GroundOverlayOptions anchor(float f2, float f10) {
        this.anchorU = f2;
        this.anchorV = f10;
        if (this.latlngBounds != null) {
            b();
            return this;
        }
        if (this.latLng != null) {
            a();
        }
        return this;
    }

    public GroundOverlayOptions bearing(float f2) {
        this.bearing = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public float getBearing() {
        return this.bearing;
    }

    public LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public float getHeight() {
        return this.height;
    }

    public BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public LatLng getLocation() {
        return this.latLng;
    }

    public float getTransparency() {
        return this.transparency;
    }

    public float getWidth() {
        return this.width;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public GroundOverlayOptions position(LatLng latLng, float f2) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f2 <= 0.0f) {
            Log.w(CLASSNAME, "Width must be non-negative");
        }
        this.latLng = latLng;
        this.width = f2;
        this.height = f2;
        a();
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        this.latlngBounds = latLngBounds;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        b();
        return this;
    }

    public GroundOverlayOptions transparency(float f2) {
        if (f2 < 0.0f) {
            Log.w(CLASSNAME, "Transparency must be in the range [0..1]");
            f2 = 0.0f;
        }
        this.transparency = f2;
        return this;
    }

    public GroundOverlayOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeParcelable(this.bitmapDescriptor, i3);
        parcel.writeParcelable(this.latLng, i3);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeParcelable(this.latlngBounds, i3);
        parcel.writeFloat(this.bearing);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.transparency);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
    }

    public GroundOverlayOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GroundOverlayOptions m9clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        groundOverlayOptions.bitmapDescriptor = this.bitmapDescriptor;
        groundOverlayOptions.latLng = this.latLng;
        groundOverlayOptions.width = this.width;
        groundOverlayOptions.height = this.height;
        groundOverlayOptions.latlngBounds = this.latlngBounds;
        groundOverlayOptions.bearing = this.bearing;
        groundOverlayOptions.zIndex = this.zIndex;
        groundOverlayOptions.isVisible = this.isVisible;
        groundOverlayOptions.transparency = this.transparency;
        groundOverlayOptions.anchorU = this.anchorU;
        groundOverlayOptions.anchorV = this.anchorV;
        groundOverlayOptions.southwest = this.southwest;
        groundOverlayOptions.northeast = this.northeast;
        return groundOverlayOptions;
    }

    public GroundOverlayOptions position(LatLng latLng, float f2, float f10) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f2 <= 0.0f || f10 <= 0.0f) {
            Log.w(CLASSNAME, "Width and Height must be non-negative");
        }
        this.latLng = latLng;
        this.width = f2;
        this.height = f10;
        a();
        return this;
    }

    public GroundOverlayOptions() {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = 1;
        this.type = CLASSNAME;
    }
}
