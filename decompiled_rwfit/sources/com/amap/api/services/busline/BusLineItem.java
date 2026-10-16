package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f5858a;

    /* renamed from: b, reason: collision with root package name */
    private String f5859b;

    /* renamed from: c, reason: collision with root package name */
    private String f5860c;

    /* renamed from: d, reason: collision with root package name */
    private String f5861d;
    private List<LatLonPoint> e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f5862f;

    /* renamed from: g, reason: collision with root package name */
    private String f5863g;

    /* renamed from: h, reason: collision with root package name */
    private String f5864h;

    /* renamed from: i, reason: collision with root package name */
    private String f5865i;

    /* renamed from: j, reason: collision with root package name */
    private Date f5866j;

    /* renamed from: k, reason: collision with root package name */
    private Date f5867k;

    /* renamed from: l, reason: collision with root package name */
    private String f5868l;

    /* renamed from: m, reason: collision with root package name */
    private float f5869m;

    /* renamed from: n, reason: collision with root package name */
    private float f5870n;

    /* renamed from: o, reason: collision with root package name */
    private List<BusStationItem> f5871o;

    public static class a implements Parcelable.Creator<BusLineItem> {
        @Override // android.os.Parcelable.Creator
        public BusLineItem createFromParcel(Parcel parcel) {
            return new BusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusLineItem[] newArray(int i3) {
            return null;
        }
    }

    public BusLineItem() {
        this.e = new ArrayList();
        this.f5862f = new ArrayList();
        this.f5871o = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineItem busLineItem = (BusLineItem) obj;
        String str = this.f5863g;
        if (str == null) {
            if (busLineItem.f5863g != null) {
                return false;
            }
        } else if (!str.equals(busLineItem.f5863g)) {
            return false;
        }
        return true;
    }

    public float getBasicPrice() {
        return this.f5869m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f5862f;
    }

    public String getBusCompany() {
        return this.f5868l;
    }

    public String getBusLineId() {
        return this.f5863g;
    }

    public String getBusLineName() {
        return this.f5859b;
    }

    public String getBusLineType() {
        return this.f5860c;
    }

    public List<BusStationItem> getBusStations() {
        return this.f5871o;
    }

    public String getCityCode() {
        return this.f5861d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.e;
    }

    public float getDistance() {
        return this.f5858a;
    }

    public Date getFirstBusTime() {
        Date date = this.f5866j;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public Date getLastBusTime() {
        Date date = this.f5867k;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getOriginatingStation() {
        return this.f5864h;
    }

    public String getTerminalStation() {
        return this.f5865i;
    }

    public float getTotalPrice() {
        return this.f5870n;
    }

    public int hashCode() {
        String str = this.f5863g;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setBasicPrice(float f2) {
        this.f5869m = f2;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f5862f = list;
    }

    public void setBusCompany(String str) {
        this.f5868l = str;
    }

    public void setBusLineId(String str) {
        this.f5863g = str;
    }

    public void setBusLineName(String str) {
        this.f5859b = str;
    }

    public void setBusLineType(String str) {
        this.f5860c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f5871o = list;
    }

    public void setCityCode(String str) {
        this.f5861d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.e = list;
    }

    public void setDistance(float f2) {
        this.f5858a = f2;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f5866j = null;
        } else {
            this.f5866j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f5867k = null;
        } else {
            this.f5867k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.f5864h = str;
    }

    public void setTerminalStation(String str) {
        this.f5865i = str;
    }

    public void setTotalPrice(float f2) {
        this.f5870n = f2;
    }

    public String toString() {
        return this.f5859b + " " + d6.a(this.f5866j) + "-" + d6.a(this.f5867k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f5858a);
        parcel.writeString(this.f5859b);
        parcel.writeString(this.f5860c);
        parcel.writeString(this.f5861d);
        parcel.writeList(this.e);
        parcel.writeList(this.f5862f);
        parcel.writeString(this.f5863g);
        parcel.writeString(this.f5864h);
        parcel.writeString(this.f5865i);
        parcel.writeString(d6.a(this.f5866j));
        parcel.writeString(d6.a(this.f5867k));
        parcel.writeString(this.f5868l);
        parcel.writeFloat(this.f5869m);
        parcel.writeFloat(this.f5870n);
        parcel.writeList(this.f5871o);
    }

    public BusLineItem(Parcel parcel) {
        this.e = new ArrayList();
        this.f5862f = new ArrayList();
        this.f5871o = new ArrayList();
        this.f5858a = parcel.readFloat();
        this.f5859b = parcel.readString();
        this.f5860c = parcel.readString();
        this.f5861d = parcel.readString();
        this.e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f5862f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f5863g = parcel.readString();
        this.f5864h = parcel.readString();
        this.f5865i = parcel.readString();
        this.f5866j = d6.c(parcel.readString());
        this.f5867k = d6.c(parcel.readString());
        this.f5868l = parcel.readString();
        this.f5869m = parcel.readFloat();
        this.f5870n = parcel.readFloat();
        this.f5871o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
