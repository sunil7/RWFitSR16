package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* loaded from: classes.dex */
public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private RouteSearch.TruckRouteQuery f6472a;

    /* renamed from: b, reason: collision with root package name */
    private List<TruckPath> f6473b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6474c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f6475d;

    public static class a implements Parcelable.Creator<TruckRouteRestult> {
        @Override // android.os.Parcelable.Creator
        public TruckRouteRestult createFromParcel(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TruckRouteRestult[] newArray(int i3) {
            return new TruckRouteRestult[i3];
        }
    }

    public TruckRouteRestult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TruckPath> getPaths() {
        return this.f6473b;
    }

    public LatLonPoint getStartPos() {
        return this.f6474c;
    }

    public LatLonPoint getTargetPos() {
        return this.f6475d;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.f6472a;
    }

    public void setPaths(List<TruckPath> list) {
        this.f6473b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f6474c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f6475d = latLonPoint;
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.f6472a = truckRouteQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.f6473b);
        parcel.writeParcelable(this.f6474c, i3);
        parcel.writeParcelable(this.f6475d, i3);
    }

    public TruckRouteRestult(Parcel parcel) {
        this.f6473b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.f6474c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6475d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
