package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResultV2> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f6193c;

    /* renamed from: d, reason: collision with root package name */
    private List<BusPathV2> f6194d;
    private RouteSearchV2.BusRouteQuery e;

    /* renamed from: f, reason: collision with root package name */
    private float f6195f;

    public static class a implements Parcelable.Creator<BusRouteResultV2> {
        @Override // android.os.Parcelable.Creator
        public BusRouteResultV2 createFromParcel(Parcel parcel) {
            return new BusRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BusRouteResultV2[] newArray(int i3) {
            return new BusRouteResultV2[i3];
        }
    }

    public BusRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f6194d = new ArrayList();
        this.f6193c = parcel.readFloat();
        this.f6194d = parcel.createTypedArrayList(BusPathV2.CREATOR);
        this.e = (RouteSearchV2.BusRouteQuery) parcel.readParcelable(RouteSearchV2.BusRouteQuery.class.getClassLoader());
        this.f6195f = parcel.readFloat();
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.BusRouteQuery getBusQuery() {
        return this.e;
    }

    public float getDistance() {
        return this.f6195f;
    }

    public List<BusPathV2> getPaths() {
        return this.f6194d;
    }

    public float getTaxiCost() {
        return this.f6193c;
    }

    public void setBusQuery(RouteSearchV2.BusRouteQuery busRouteQuery) {
        this.e = busRouteQuery;
    }

    public void setDistance(float f2) {
        this.f6195f = f2;
    }

    public void setPaths(List<BusPathV2> list) {
        this.f6194d = list;
    }

    public void setTaxiCost(float f2) {
        this.f6193c = f2;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f6193c);
        parcel.writeTypedList(this.f6194d);
        parcel.writeParcelable(this.e, i3);
        parcel.writeFloat(this.f6195f);
    }

    public BusRouteResultV2() {
        this.f6194d = new ArrayList();
    }
}
