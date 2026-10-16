package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f6191c;

    /* renamed from: d, reason: collision with root package name */
    private List<BusPath> f6192d;
    private RouteSearch.BusRouteQuery e;

    public static class a implements Parcelable.Creator<BusRouteResult> {
        @Override // android.os.Parcelable.Creator
        public BusRouteResult createFromParcel(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BusRouteResult[] newArray(int i3) {
            return new BusRouteResult[i3];
        }
    }

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f6192d = new ArrayList();
        this.f6191c = parcel.readFloat();
        this.f6192d = parcel.createTypedArrayList(BusPath.CREATOR);
        this.e = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.e;
    }

    public List<BusPath> getPaths() {
        return this.f6192d;
    }

    public float getTaxiCost() {
        return this.f6191c;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.e = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.f6192d = list;
    }

    public void setTaxiCost(float f2) {
        this.f6191c = f2;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f6191c);
        parcel.writeTypedList(this.f6192d);
        parcel.writeParcelable(this.e, i3);
    }

    public BusRouteResult() {
        this.f6192d = new ArrayList();
    }
}
