package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f6330a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6331b;

    public static class a implements Parcelable.Creator<RouteResult> {
        @Override // android.os.Parcelable.Creator
        public RouteResult createFromParcel(Parcel parcel) {
            return new RouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RouteResult[] newArray(int i3) {
            return new RouteResult[i3];
        }
    }

    public RouteResult(Parcel parcel) {
        this.f6330a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6331b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f6330a;
    }

    public LatLonPoint getTargetPos() {
        return this.f6331b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f6330a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f6331b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f6330a, i3);
        parcel.writeParcelable(this.f6331b, i3);
    }

    public RouteResult() {
    }
}
