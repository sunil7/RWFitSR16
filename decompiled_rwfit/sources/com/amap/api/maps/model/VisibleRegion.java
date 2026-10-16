package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.v4;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class VisibleRegion implements Parcelable {
    public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    private final int mVersionCode;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    public VisibleRegion(int i3, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.mVersionCode = i3;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public int a() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    public int hashCode() {
        Object[] objArr = {this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds};
        int i3 = v4.f5181b;
        return Arrays.hashCode(objArr);
    }

    public String toString() {
        return v4.a(v4.a("nearLeft", this.nearLeft), v4.a("nearRight", this.nearRight), v4.a("farLeft", this.farLeft), v4.a("farRight", this.farRight), v4.a("latLngBounds", this.latLngBounds));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(a());
        parcel.writeParcelable(this.nearLeft, i3);
        parcel.writeParcelable(this.nearRight, i3);
        parcel.writeParcelable(this.farLeft, i3);
        parcel.writeParcelable(this.farRight, i3);
        parcel.writeParcelable(this.latLngBounds, i3);
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }
}
