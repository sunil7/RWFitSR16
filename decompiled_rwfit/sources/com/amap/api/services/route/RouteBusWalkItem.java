package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new a();
    private LatLonPoint e;

    /* renamed from: f, reason: collision with root package name */
    private LatLonPoint f6319f;

    public static class a implements Parcelable.Creator<RouteBusWalkItem> {
        @Override // android.os.Parcelable.Creator
        public RouteBusWalkItem createFromParcel(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RouteBusWalkItem[] newArray(int i3) {
            return null;
        }
    }

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.e = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6319f = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f6319f;
    }

    public LatLonPoint getOrigin() {
        return this.e;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f6319f = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeParcelable(this.e, i3);
        parcel.writeParcelable(this.f6319f, i3);
    }

    public RouteBusWalkItem() {
    }
}
