package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RouteRailwayItem extends Railway implements Parcelable {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private String f6322c;

    /* renamed from: d, reason: collision with root package name */
    private String f6323d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private String f6324f;

    /* renamed from: g, reason: collision with root package name */
    private RailwayStationItem f6325g;

    /* renamed from: h, reason: collision with root package name */
    private RailwayStationItem f6326h;

    /* renamed from: i, reason: collision with root package name */
    private List<RailwayStationItem> f6327i;

    /* renamed from: j, reason: collision with root package name */
    private List<Railway> f6328j;

    /* renamed from: k, reason: collision with root package name */
    private List<RailwaySpace> f6329k;

    public static class a implements Parcelable.Creator<RouteRailwayItem> {
        @Override // android.os.Parcelable.Creator
        public RouteRailwayItem createFromParcel(Parcel parcel) {
            return new RouteRailwayItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RouteRailwayItem[] newArray(int i3) {
            return new RouteRailwayItem[i3];
        }
    }

    public RouteRailwayItem() {
        this.f6327i = new ArrayList();
        this.f6328j = new ArrayList();
        this.f6329k = new ArrayList();
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Railway> getAlters() {
        return this.f6328j;
    }

    public RailwayStationItem getArrivalstop() {
        return this.f6326h;
    }

    public RailwayStationItem getDeparturestop() {
        return this.f6325g;
    }

    public float getDistance() {
        return this.e;
    }

    public List<RailwaySpace> getSpaces() {
        return this.f6329k;
    }

    public String getTime() {
        return this.f6322c;
    }

    public String getTrip() {
        return this.f6323d;
    }

    public String getType() {
        return this.f6324f;
    }

    public List<RailwayStationItem> getViastops() {
        return this.f6327i;
    }

    public void setAlters(List<Railway> list) {
        this.f6328j = list;
    }

    public void setArrivalstop(RailwayStationItem railwayStationItem) {
        this.f6326h = railwayStationItem;
    }

    public void setDeparturestop(RailwayStationItem railwayStationItem) {
        this.f6325g = railwayStationItem;
    }

    public void setDistance(float f2) {
        this.e = f2;
    }

    public void setSpaces(List<RailwaySpace> list) {
        this.f6329k = list;
    }

    public void setTime(String str) {
        this.f6322c = str;
    }

    public void setTrip(String str) {
        this.f6323d = str;
    }

    public void setType(String str) {
        this.f6324f = str;
    }

    public void setViastops(List<RailwayStationItem> list) {
        this.f6327i = list;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f6322c);
        parcel.writeString(this.f6323d);
        parcel.writeFloat(this.e);
        parcel.writeString(this.f6324f);
        parcel.writeParcelable(this.f6325g, i3);
        parcel.writeParcelable(this.f6326h, i3);
        parcel.writeTypedList(this.f6327i);
        parcel.writeTypedList(this.f6328j);
        parcel.writeTypedList(this.f6329k);
    }

    public RouteRailwayItem(Parcel parcel) {
        super(parcel);
        this.f6327i = new ArrayList();
        this.f6328j = new ArrayList();
        this.f6329k = new ArrayList();
        this.f6322c = parcel.readString();
        this.f6323d = parcel.readString();
        this.e = parcel.readFloat();
        this.f6324f = parcel.readString();
        this.f6325g = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f6326h = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f6327i = parcel.createTypedArrayList(RailwayStationItem.CREATOR);
        this.f6328j = parcel.createTypedArrayList(Railway.CREATOR);
        this.f6329k = parcel.createTypedArrayList(RailwaySpace.CREATOR);
    }
}
