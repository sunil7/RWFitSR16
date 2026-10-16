package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public class PolygonHoleOptions extends BaseHoleOptions implements Parcelable {

    @JBindingExclude
    public static final Parcelable.Creator<PolygonHoleOptions> CREATOR = new a();
    private final List<LatLng> points;

    public static class a implements Parcelable.Creator<PolygonHoleOptions> {
        @Override // android.os.Parcelable.Creator
        public PolygonHoleOptions createFromParcel(Parcel parcel) {
            return new PolygonHoleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PolygonHoleOptions[] newArray(int i3) {
            return new PolygonHoleOptions[i3];
        }
    }

    public PolygonHoleOptions() {
        this.points = new ArrayList();
        this.isPolygonHoleOptions = true;
    }

    public PolygonHoleOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                Iterator<LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    this.points.add(it.next());
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.points);
    }

    @JBindingExclude
    public PolygonHoleOptions(Parcel parcel) {
        this.points = parcel.createTypedArrayList(LatLng.CREATOR);
        this.isPolygonHoleOptions = true;
    }
}
