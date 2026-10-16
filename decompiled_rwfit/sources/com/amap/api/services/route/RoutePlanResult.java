package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f6320a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6321b;

    public static class a implements Parcelable.Creator<RoutePlanResult> {
        @Override // android.os.Parcelable.Creator
        public RoutePlanResult createFromParcel(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RoutePlanResult[] newArray(int i3) {
            return new RoutePlanResult[i3];
        }
    }

    public RoutePlanResult(Parcel parcel) {
        this.f6320a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6321b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f6320a;
    }

    public LatLonPoint getTargetPos() {
        return this.f6321b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f6320a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f6321b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f6320a, i3);
        parcel.writeParcelable(this.f6321b, i3);
    }

    public RoutePlanResult() {
    }
}
