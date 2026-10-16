package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RideRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResultV2> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<RidePath> f6304c;

    /* renamed from: d, reason: collision with root package name */
    private RouteSearchV2.RideRouteQuery f6305d;

    public static class a implements Parcelable.Creator<RideRouteResultV2> {
        @Override // android.os.Parcelable.Creator
        public RideRouteResultV2 createFromParcel(Parcel parcel) {
            return new RideRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RideRouteResultV2[] newArray(int i3) {
            return new RideRouteResultV2[i3];
        }
    }

    public RideRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f6304c = new ArrayList();
        this.f6304c = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f6305d = (RouteSearchV2.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f6304c;
    }

    public RouteSearchV2.RideRouteQuery getRideQuery() {
        return this.f6305d;
    }

    public void setPaths(List<RidePath> list) {
        this.f6304c = list;
    }

    public void setRideQuery(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        this.f6305d = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeTypedList(this.f6304c);
        parcel.writeParcelable(this.f6305d, i3);
    }

    public RideRouteResultV2() {
        this.f6304c = new ArrayList();
    }
}
