package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusStepV2 implements Parcelable {
    public static final Parcelable.Creator<BusStepV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f6201a;

    /* renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f6202b;

    /* renamed from: c, reason: collision with root package name */
    private Doorway f6203c;

    /* renamed from: d, reason: collision with root package name */
    private Doorway f6204d;
    private RouteRailwayItem e;

    /* renamed from: f, reason: collision with root package name */
    private TaxiItemV2 f6205f;

    public static class a implements Parcelable.Creator<BusStepV2> {
        @Override // android.os.Parcelable.Creator
        public BusStepV2 createFromParcel(Parcel parcel) {
            return new BusStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusStepV2[] newArray(int i3) {
            return null;
        }
    }

    public BusStepV2(Parcel parcel) {
        this.f6202b = new ArrayList();
        this.f6201a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f6202b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f6203c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f6204d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f6205f = (TaxiItemV2) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f6202b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f6202b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f6202b;
    }

    public Doorway getEntrance() {
        return this.f6203c;
    }

    public Doorway getExit() {
        return this.f6204d;
    }

    public RouteRailwayItem getRailway() {
        return this.e;
    }

    public TaxiItemV2 getTaxi() {
        return this.f6205f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f6201a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f6202b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f6202b.add(routeBusLineItem);
        }
        this.f6202b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f6202b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f6203c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f6204d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.e = routeRailwayItem;
    }

    public void setTaxi(TaxiItemV2 taxiItemV2) {
        this.f6205f = taxiItemV2;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f6201a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f6201a, i3);
        parcel.writeTypedList(this.f6202b);
        parcel.writeParcelable(this.f6203c, i3);
        parcel.writeParcelable(this.f6204d, i3);
        parcel.writeParcelable(this.e, i3);
        parcel.writeParcelable(this.f6205f, i3);
    }

    public BusStepV2() {
        this.f6202b = new ArrayList();
    }
}
