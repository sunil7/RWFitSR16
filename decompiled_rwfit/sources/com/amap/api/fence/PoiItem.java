package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5597a;

    /* renamed from: b, reason: collision with root package name */
    private String f5598b;

    /* renamed from: c, reason: collision with root package name */
    private String f5599c;

    /* renamed from: d, reason: collision with root package name */
    private String f5600d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private double f5601f;

    /* renamed from: g, reason: collision with root package name */
    private double f5602g;

    /* renamed from: h, reason: collision with root package name */
    private String f5603h;

    /* renamed from: i, reason: collision with root package name */
    private String f5604i;

    /* renamed from: j, reason: collision with root package name */
    private String f5605j;

    /* renamed from: k, reason: collision with root package name */
    private String f5606k;

    public static class a implements Parcelable.Creator<PoiItem> {
        @Override // android.os.Parcelable.Creator
        public PoiItem createFromParcel(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PoiItem[] newArray(int i3) {
            return new PoiItem[i3];
        }
    }

    public PoiItem() {
        this.f5597a = "";
        this.f5598b = "";
        this.f5599c = "";
        this.f5600d = "";
        this.e = "";
        this.f5601f = 0.0d;
        this.f5602g = 0.0d;
        this.f5603h = "";
        this.f5604i = "";
        this.f5605j = "";
        this.f5606k = "";
    }

    public static Parcelable.Creator<PoiItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.e;
    }

    public String getAdname() {
        return this.f5606k;
    }

    public String getCity() {
        return this.f5605j;
    }

    public double getLatitude() {
        return this.f5601f;
    }

    public double getLongitude() {
        return this.f5602g;
    }

    public String getPoiId() {
        return this.f5598b;
    }

    public String getPoiName() {
        return this.f5597a;
    }

    public String getPoiType() {
        return this.f5599c;
    }

    public String getProvince() {
        return this.f5604i;
    }

    public String getTel() {
        return this.f5603h;
    }

    public String getTypeCode() {
        return this.f5600d;
    }

    public void setAddress(String str) {
        this.e = str;
    }

    public void setAdname(String str) {
        this.f5606k = str;
    }

    public void setCity(String str) {
        this.f5605j = str;
    }

    public void setLatitude(double d5) {
        this.f5601f = d5;
    }

    public void setLongitude(double d5) {
        this.f5602g = d5;
    }

    public void setPoiId(String str) {
        this.f5598b = str;
    }

    public void setPoiName(String str) {
        this.f5597a = str;
    }

    public void setPoiType(String str) {
        this.f5599c = str;
    }

    public void setProvince(String str) {
        this.f5604i = str;
    }

    public void setTel(String str) {
        this.f5603h = str;
    }

    public void setTypeCode(String str) {
        this.f5600d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5597a);
        parcel.writeString(this.f5598b);
        parcel.writeString(this.f5599c);
        parcel.writeString(this.f5600d);
        parcel.writeString(this.e);
        parcel.writeDouble(this.f5601f);
        parcel.writeDouble(this.f5602g);
        parcel.writeString(this.f5603h);
        parcel.writeString(this.f5604i);
        parcel.writeString(this.f5605j);
        parcel.writeString(this.f5606k);
    }

    public PoiItem(Parcel parcel) {
        this.f5597a = "";
        this.f5598b = "";
        this.f5599c = "";
        this.f5600d = "";
        this.e = "";
        this.f5601f = 0.0d;
        this.f5602g = 0.0d;
        this.f5603h = "";
        this.f5604i = "";
        this.f5605j = "";
        this.f5606k = "";
        this.f5597a = parcel.readString();
        this.f5598b = parcel.readString();
        this.f5599c = parcel.readString();
        this.f5600d = parcel.readString();
        this.e = parcel.readString();
        this.f5601f = parcel.readDouble();
        this.f5602g = parcel.readDouble();
        this.f5603h = parcel.readString();
        this.f5604i = parcel.readString();
        this.f5605j = parcel.readString();
        this.f5606k = parcel.readString();
    }
}
