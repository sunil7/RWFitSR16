package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new a();

    /* renamed from: p, reason: collision with root package name */
    private BusStationItem f6314p;

    /* renamed from: q, reason: collision with root package name */
    private BusStationItem f6315q;
    private List<LatLonPoint> r;

    /* renamed from: s, reason: collision with root package name */
    private int f6316s;

    /* renamed from: t, reason: collision with root package name */
    private List<BusStationItem> f6317t;

    /* renamed from: u, reason: collision with root package name */
    private float f6318u;

    public static class a implements Parcelable.Creator<RouteBusLineItem> {
        @Override // android.os.Parcelable.Creator
        public RouteBusLineItem createFromParcel(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RouteBusLineItem[] newArray(int i3) {
            return null;
        }
    }

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.r = new ArrayList();
        this.f6317t = new ArrayList();
        this.f6314p = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f6315q = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.r = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f6316s = parcel.readInt();
        this.f6317t = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f6318u = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        BusStationItem busStationItem = this.f6315q;
        if (busStationItem == null) {
            if (routeBusLineItem.f6315q != null) {
                return false;
            }
        } else if (!busStationItem.equals(routeBusLineItem.f6315q)) {
            return false;
        }
        BusStationItem busStationItem2 = this.f6314p;
        if (busStationItem2 == null) {
            if (routeBusLineItem.f6314p != null) {
                return false;
            }
        } else if (!busStationItem2.equals(routeBusLineItem.f6314p)) {
            return false;
        }
        return true;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f6315q;
    }

    public BusStationItem getDepartureBusStation() {
        return this.f6314p;
    }

    public float getDuration() {
        return this.f6318u;
    }

    public int getPassStationNum() {
        return this.f6316s;
    }

    public List<BusStationItem> getPassStations() {
        return this.f6317t;
    }

    public List<LatLonPoint> getPolyline() {
        return this.r;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        BusStationItem busStationItem = this.f6315q;
        int hashCode2 = (hashCode + (busStationItem == null ? 0 : busStationItem.hashCode())) * 31;
        BusStationItem busStationItem2 = this.f6314p;
        return hashCode2 + (busStationItem2 != null ? busStationItem2.hashCode() : 0);
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f6315q = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f6314p = busStationItem;
    }

    public void setDuration(float f2) {
        this.f6318u = f2;
    }

    public void setPassStationNum(int i3) {
        this.f6316s = i3;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f6317t = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.r = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeParcelable(this.f6314p, i3);
        parcel.writeParcelable(this.f6315q, i3);
        parcel.writeTypedList(this.r);
        parcel.writeInt(this.f6316s);
        parcel.writeTypedList(this.f6317t);
        parcel.writeFloat(this.f6318u);
    }

    public RouteBusLineItem() {
        this.r = new ArrayList();
        this.f6317t = new ArrayList();
    }
}
