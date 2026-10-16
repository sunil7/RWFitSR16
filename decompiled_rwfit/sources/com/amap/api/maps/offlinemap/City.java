package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5772a;

    /* renamed from: b, reason: collision with root package name */
    private String f5773b;

    /* renamed from: c, reason: collision with root package name */
    private String f5774c;

    /* renamed from: d, reason: collision with root package name */
    private String f5775d;
    private String e;

    public static class a implements Parcelable.Creator<City> {
        @Override // android.os.Parcelable.Creator
        public City createFromParcel(Parcel parcel) {
            return new City(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public City[] newArray(int i3) {
            return new City[i3];
        }
    }

    public City() {
        this.f5772a = "";
        this.f5773b = "";
        this.f5774c = "";
        this.f5775d = "";
        this.e = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.e;
    }

    public String getCity() {
        return this.f5772a;
    }

    public String getCode() {
        return this.f5773b;
    }

    public String getJianpin() {
        return this.f5774c;
    }

    public String getPinyin() {
        return this.f5775d;
    }

    public void setAdcode(String str) {
        this.e = str;
    }

    public void setCity(String str) {
        this.f5772a = str;
    }

    public void setCode(String str) {
        if (str == null || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(str)) {
            return;
        }
        this.f5773b = str;
    }

    public void setJianpin(String str) {
        this.f5774c = str;
    }

    public void setPinyin(String str) {
        this.f5775d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5772a);
        parcel.writeString(this.f5773b);
        parcel.writeString(this.f5774c);
        parcel.writeString(this.f5775d);
        parcel.writeString(this.e);
    }

    public City(Parcel parcel) {
        this.f5772a = "";
        this.f5773b = "";
        this.f5774c = "";
        this.f5775d = "";
        this.e = "";
        this.f5772a = parcel.readString();
        this.f5773b = parcel.readString();
        this.f5774c = parcel.readString();
        this.f5775d = parcel.readString();
        this.e = parcel.readString();
    }
}
