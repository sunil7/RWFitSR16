package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RideRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<RidePath> f6302c;

    /* renamed from: d, reason: collision with root package name */
    private RouteSearch.RideRouteQuery f6303d;

    public static class a implements Parcelable.Creator<RideRouteResult> {
        @Override // android.os.Parcelable.Creator
        public RideRouteResult createFromParcel(Parcel parcel) {
            return new RideRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RideRouteResult[] newArray(int i3) {
            return new RideRouteResult[i3];
        }
    }

    public RideRouteResult(Parcel parcel) {
        super(parcel);
        this.f6302c = new ArrayList();
        this.f6302c = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f6303d = (RouteSearch.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f6302c;
    }

    public RouteSearch.RideRouteQuery getRideQuery() {
        return this.f6303d;
    }

    public void setPaths(List<RidePath> list) {
        this.f6302c = list;
    }

    public void setRideQuery(RouteSearch.RideRouteQuery rideRouteQuery) {
        this.f6303d = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeTypedList(this.f6302c);
        parcel.writeParcelable(this.f6303d, i3);
    }

    public RideRouteResult() {
        this.f6302c = new ArrayList();
    }
}
