package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f6196a;

    /* renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f6197b;

    /* renamed from: c, reason: collision with root package name */
    private Doorway f6198c;

    /* renamed from: d, reason: collision with root package name */
    private Doorway f6199d;
    private RouteRailwayItem e;

    /* renamed from: f, reason: collision with root package name */
    private TaxiItem f6200f;

    public static class a implements Parcelable.Creator<BusStep> {
        @Override // android.os.Parcelable.Creator
        public BusStep createFromParcel(Parcel parcel) {
            return new BusStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusStep[] newArray(int i3) {
            return null;
        }
    }

    public BusStep(Parcel parcel) {
        this.f6197b = new ArrayList();
        this.f6196a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f6197b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f6198c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f6199d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f6200f = (TaxiItem) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f6197b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f6197b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f6197b;
    }

    public Doorway getEntrance() {
        return this.f6198c;
    }

    public Doorway getExit() {
        return this.f6199d;
    }

    public RouteRailwayItem getRailway() {
        return this.e;
    }

    public TaxiItem getTaxi() {
        return this.f6200f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f6196a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f6197b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f6197b.add(routeBusLineItem);
        }
        this.f6197b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f6197b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f6198c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f6199d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.e = routeRailwayItem;
    }

    public void setTaxi(TaxiItem taxiItem) {
        this.f6200f = taxiItem;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f6196a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f6196a, i3);
        parcel.writeTypedList(this.f6197b);
        parcel.writeParcelable(this.f6198c, i3);
        parcel.writeParcelable(this.f6199d, i3);
        parcel.writeParcelable(this.e, i3);
        parcel.writeParcelable(this.f6200f, i3);
    }

    public BusStep() {
        this.f6197b = new ArrayList();
    }
}
