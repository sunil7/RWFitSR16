package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5883a;

    /* renamed from: b, reason: collision with root package name */
    private String f5884b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f5885c;

    /* renamed from: d, reason: collision with root package name */
    private String f5886d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private List<BusLineItem> f5887f;

    public static class a implements Parcelable.Creator<BusStationItem> {
        @Override // android.os.Parcelable.Creator
        public BusStationItem createFromParcel(Parcel parcel) {
            return new BusStationItem(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusStationItem[] newArray(int i3) {
            return null;
        }
    }

    public /* synthetic */ BusStationItem(Parcel parcel, a aVar) {
        this(parcel);
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
        BusStationItem busStationItem = (BusStationItem) obj;
        String str = this.f5883a;
        if (str == null) {
            if (busStationItem.f5883a != null) {
                return false;
            }
        } else if (!str.equals(busStationItem.f5883a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f5887f;
    }

    public String getBusStationId() {
        return this.f5883a;
    }

    public String getBusStationName() {
        return this.f5884b;
    }

    public String getCityCode() {
        return this.f5886d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f5885c;
    }

    public int hashCode() {
        String str = this.f5883a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f5887f = list;
    }

    public void setBusStationId(String str) {
        this.f5883a = str;
    }

    public void setBusStationName(String str) {
        this.f5884b = str;
    }

    public void setCityCode(String str) {
        this.f5886d = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f5885c = latLonPoint;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BusStationName: ");
        sb2.append(this.f5884b);
        sb2.append(" LatLonPoint: ");
        sb2.append(this.f5885c.toString());
        sb2.append(" BusLines: ");
        List<BusLineItem> list = this.f5887f;
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                stringBuffer.append(list.get(i3).getBusLineName());
                if (i3 < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        sb2.append(stringBuffer.toString());
        sb2.append(" CityCode: ");
        sb2.append(this.f5886d);
        sb2.append(" AdCode: ");
        sb2.append(this.e);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5884b);
        parcel.writeString(this.f5883a);
        parcel.writeValue(this.f5885c);
        parcel.writeString(this.f5886d);
        parcel.writeString(this.e);
        parcel.writeList(this.f5887f);
    }

    public BusStationItem() {
        this.f5887f = new ArrayList();
    }

    private BusStationItem(Parcel parcel) {
        this.f5887f = new ArrayList();
        this.f5884b = parcel.readString();
        this.f5883a = parcel.readString();
        this.f5885c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f5886d = parcel.readString();
        this.e = parcel.readString();
        this.f5887f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
