package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6008a;

    /* renamed from: b, reason: collision with root package name */
    private String f6009b;

    /* renamed from: c, reason: collision with root package name */
    private String f6010c;

    /* renamed from: d, reason: collision with root package name */
    private String f6011d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6012f;

    /* renamed from: g, reason: collision with root package name */
    private String f6013g;

    /* renamed from: h, reason: collision with root package name */
    private String f6014h;

    /* renamed from: i, reason: collision with root package name */
    private LatLonPoint f6015i;

    /* renamed from: j, reason: collision with root package name */
    private String f6016j;

    /* renamed from: k, reason: collision with root package name */
    private String f6017k;

    /* renamed from: l, reason: collision with root package name */
    private String f6018l;

    public static class a implements Parcelable.Creator<GeocodeAddress> {
        @Override // android.os.Parcelable.Creator
        public GeocodeAddress createFromParcel(Parcel parcel) {
            return new GeocodeAddress(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GeocodeAddress[] newArray(int i3) {
            return null;
        }
    }

    public /* synthetic */ GeocodeAddress(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f6014h;
    }

    public String getBuilding() {
        return this.f6013g;
    }

    public String getCity() {
        return this.f6010c;
    }

    public String getCountry() {
        return this.f6017k;
    }

    public String getDistrict() {
        return this.f6011d;
    }

    public String getFormatAddress() {
        return this.f6008a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f6015i;
    }

    public String getLevel() {
        return this.f6016j;
    }

    public String getNeighborhood() {
        return this.f6012f;
    }

    public String getPostcode() {
        return this.f6018l;
    }

    public String getProvince() {
        return this.f6009b;
    }

    public String getTownship() {
        return this.e;
    }

    public void setAdcode(String str) {
        this.f6014h = str;
    }

    public void setBuilding(String str) {
        this.f6013g = str;
    }

    public void setCity(String str) {
        this.f6010c = str;
    }

    public void setCountry(String str) {
        this.f6017k = str;
    }

    public void setDistrict(String str) {
        this.f6011d = str;
    }

    public void setFormatAddress(String str) {
        this.f6008a = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f6015i = latLonPoint;
    }

    public void setLevel(String str) {
        this.f6016j = str;
    }

    public void setNeighborhood(String str) {
        this.f6012f = str;
    }

    public void setPostcode(String str) {
        this.f6018l = str;
    }

    public void setProvince(String str) {
        this.f6009b = str;
    }

    public void setTownship(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6008a);
        parcel.writeString(this.f6009b);
        parcel.writeString(this.f6010c);
        parcel.writeString(this.f6011d);
        parcel.writeString(this.e);
        parcel.writeString(this.f6012f);
        parcel.writeString(this.f6013g);
        parcel.writeString(this.f6014h);
        parcel.writeValue(this.f6015i);
        parcel.writeString(this.f6016j);
        parcel.writeString(this.f6017k);
        parcel.writeString(this.f6018l);
    }

    public GeocodeAddress() {
    }

    private GeocodeAddress(Parcel parcel) {
        this.f6008a = parcel.readString();
        this.f6009b = parcel.readString();
        this.f6010c = parcel.readString();
        this.f6011d = parcel.readString();
        this.e = parcel.readString();
        this.f6012f = parcel.readString();
        this.f6013g = parcel.readString();
        this.f6014h = parcel.readString();
        this.f6015i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f6016j = parcel.readString();
        this.f6017k = parcel.readString();
        this.f6018l = parcel.readString();
    }
}
