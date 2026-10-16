package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6025a;

    /* renamed from: b, reason: collision with root package name */
    private String f6026b;

    /* renamed from: c, reason: collision with root package name */
    private String f6027c;

    /* renamed from: d, reason: collision with root package name */
    private String f6028d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6029f;

    /* renamed from: g, reason: collision with root package name */
    private String f6030g;

    /* renamed from: h, reason: collision with root package name */
    private StreetNumber f6031h;

    /* renamed from: i, reason: collision with root package name */
    private String f6032i;

    /* renamed from: j, reason: collision with root package name */
    private String f6033j;

    /* renamed from: k, reason: collision with root package name */
    private String f6034k;

    /* renamed from: l, reason: collision with root package name */
    private List<RegeocodeRoad> f6035l;

    /* renamed from: m, reason: collision with root package name */
    private List<Crossroad> f6036m;

    /* renamed from: n, reason: collision with root package name */
    private List<PoiItem> f6037n;

    /* renamed from: o, reason: collision with root package name */
    private List<BusinessArea> f6038o;

    /* renamed from: p, reason: collision with root package name */
    private List<AoiItem> f6039p;

    /* renamed from: q, reason: collision with root package name */
    private String f6040q;
    private String r;

    public static class a implements Parcelable.Creator<RegeocodeAddress> {
        @Override // android.os.Parcelable.Creator
        public RegeocodeAddress createFromParcel(Parcel parcel) {
            return new RegeocodeAddress(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RegeocodeAddress[] newArray(int i3) {
            return null;
        }
    }

    public /* synthetic */ RegeocodeAddress(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f6033j;
    }

    public List<AoiItem> getAois() {
        return this.f6039p;
    }

    public String getBuilding() {
        return this.f6030g;
    }

    public List<BusinessArea> getBusinessAreas() {
        return this.f6038o;
    }

    public String getCity() {
        return this.f6027c;
    }

    public String getCityCode() {
        return this.f6032i;
    }

    public String getCountry() {
        return this.f6040q;
    }

    public String getCountryCode() {
        return this.r;
    }

    public List<Crossroad> getCrossroads() {
        return this.f6036m;
    }

    public String getDistrict() {
        return this.f6028d;
    }

    public String getFormatAddress() {
        return this.f6025a;
    }

    public String getNeighborhood() {
        return this.f6029f;
    }

    public List<PoiItem> getPois() {
        return this.f6037n;
    }

    public String getProvince() {
        return this.f6026b;
    }

    public List<RegeocodeRoad> getRoads() {
        return this.f6035l;
    }

    public StreetNumber getStreetNumber() {
        return this.f6031h;
    }

    public String getTowncode() {
        return this.f6034k;
    }

    public String getTownship() {
        return this.e;
    }

    public void setAdCode(String str) {
        this.f6033j = str;
    }

    public void setAois(List<AoiItem> list) {
        this.f6039p = list;
    }

    public void setBuilding(String str) {
        this.f6030g = str;
    }

    public void setBusinessAreas(List<BusinessArea> list) {
        this.f6038o = list;
    }

    public void setCity(String str) {
        this.f6027c = str;
    }

    public void setCityCode(String str) {
        this.f6032i = str;
    }

    public void setCountry(String str) {
        this.f6040q = str;
    }

    public void setCountryCode(String str) {
        this.r = str;
    }

    public void setCrossroads(List<Crossroad> list) {
        this.f6036m = list;
    }

    public void setDistrict(String str) {
        this.f6028d = str;
    }

    public void setFormatAddress(String str) {
        this.f6025a = str;
    }

    public void setNeighborhood(String str) {
        this.f6029f = str;
    }

    public void setPois(List<PoiItem> list) {
        this.f6037n = list;
    }

    public void setProvince(String str) {
        this.f6026b = str;
    }

    public void setRoads(List<RegeocodeRoad> list) {
        this.f6035l = list;
    }

    public void setStreetNumber(StreetNumber streetNumber) {
        this.f6031h = streetNumber;
    }

    public void setTowncode(String str) {
        this.f6034k = str;
    }

    public void setTownship(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6025a);
        parcel.writeString(this.f6026b);
        parcel.writeString(this.f6027c);
        parcel.writeString(this.f6028d);
        parcel.writeString(this.e);
        parcel.writeString(this.f6029f);
        parcel.writeString(this.f6030g);
        parcel.writeValue(this.f6031h);
        parcel.writeList(this.f6035l);
        parcel.writeList(this.f6036m);
        parcel.writeList(this.f6037n);
        parcel.writeString(this.f6032i);
        parcel.writeString(this.f6033j);
        parcel.writeList(this.f6038o);
        parcel.writeList(this.f6039p);
        parcel.writeString(this.f6034k);
        parcel.writeString(this.f6040q);
        parcel.writeString(this.r);
    }

    public RegeocodeAddress() {
        this.f6035l = new ArrayList();
        this.f6036m = new ArrayList();
        this.f6037n = new ArrayList();
        this.f6038o = new ArrayList();
        this.f6039p = new ArrayList();
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f6035l = new ArrayList();
        this.f6036m = new ArrayList();
        this.f6037n = new ArrayList();
        this.f6038o = new ArrayList();
        this.f6039p = new ArrayList();
        this.f6025a = parcel.readString();
        this.f6026b = parcel.readString();
        this.f6027c = parcel.readString();
        this.f6028d = parcel.readString();
        this.e = parcel.readString();
        this.f6029f = parcel.readString();
        this.f6030g = parcel.readString();
        this.f6031h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f6035l = parcel.readArrayList(Road.class.getClassLoader());
        this.f6036m = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f6037n = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f6032i = parcel.readString();
        this.f6033j = parcel.readString();
        this.f6038o = parcel.readArrayList(BusinessArea.class.getClassLoader());
        this.f6039p = parcel.readArrayList(AoiItem.class.getClassLoader());
        this.f6034k = parcel.readString();
        this.f6040q = parcel.readString();
        this.r = parcel.readString();
    }
}
