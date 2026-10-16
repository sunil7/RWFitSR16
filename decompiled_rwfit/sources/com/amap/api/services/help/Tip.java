package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6061a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6062b;

    /* renamed from: c, reason: collision with root package name */
    private String f6063c;

    /* renamed from: d, reason: collision with root package name */
    private String f6064d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6065f;

    /* renamed from: g, reason: collision with root package name */
    private String f6066g;

    /* renamed from: h, reason: collision with root package name */
    private String f6067h;

    public static class a implements Parcelable.Creator<Tip> {
        @Override // android.os.Parcelable.Creator
        public Tip createFromParcel(Parcel parcel) {
            return new Tip(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Tip[] newArray(int i3) {
            return null;
        }
    }

    public /* synthetic */ Tip(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.e;
    }

    public String getAddress() {
        return this.f6065f;
    }

    public String getDistrict() {
        return this.f6064d;
    }

    public String getName() {
        return this.f6063c;
    }

    public String getPoiID() {
        return this.f6061a;
    }

    public LatLonPoint getPoint() {
        return this.f6062b;
    }

    public String getTypeCode() {
        return this.f6066g;
    }

    public void setAdcode(String str) {
        this.e = str;
    }

    public void setAddress(String str) {
        this.f6065f = str;
    }

    public void setDistrict(String str) {
        this.f6064d = str;
    }

    public void setID(String str) {
        this.f6061a = str;
    }

    public void setName(String str) {
        this.f6063c = str;
    }

    public void setPostion(LatLonPoint latLonPoint) {
        this.f6062b = latLonPoint;
    }

    public void setTypeCode(String str) {
        this.f6066g = str;
    }

    public String toString() {
        return "name:" + this.f6063c + " district:" + this.f6064d + " adcode:" + this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6063c);
        parcel.writeString(this.e);
        parcel.writeString(this.f6064d);
        parcel.writeString(this.f6061a);
        parcel.writeValue(this.f6062b);
        parcel.writeString(this.f6065f);
        parcel.writeString(this.f6066g);
        parcel.writeString(this.f6067h);
    }

    public Tip() {
        this.f6067h = "";
    }

    private Tip(Parcel parcel) {
        this.f6067h = "";
        this.f6063c = parcel.readString();
        this.e = parcel.readString();
        this.f6064d = parcel.readString();
        this.f6061a = parcel.readString();
        this.f6062b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f6065f = parcel.readString();
        this.f6066g = parcel.readString();
        this.f6067h = parcel.readString();
    }
}
