package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5815a;

    /* renamed from: b, reason: collision with root package name */
    private String f5816b;

    /* renamed from: c, reason: collision with root package name */
    private String f5817c;

    /* renamed from: d, reason: collision with root package name */
    private String f5818d;

    public static class a implements Parcelable.Creator<Province> {
        @Override // android.os.Parcelable.Creator
        public Province createFromParcel(Parcel parcel) {
            return new Province(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Province[] newArray(int i3) {
            return new Province[i3];
        }
    }

    public Province() {
        this.f5815a = "";
        this.f5818d = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.f5816b;
    }

    public String getPinyin() {
        return this.f5817c;
    }

    public String getProvinceCode() {
        return this.f5818d;
    }

    public String getProvinceName() {
        return this.f5815a;
    }

    public void setJianpin(String str) {
        this.f5816b = str;
    }

    public void setPinyin(String str) {
        this.f5817c = str;
    }

    public void setProvinceCode(String str) {
        this.f5818d = str;
    }

    public void setProvinceName(String str) {
        this.f5815a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5815a);
        parcel.writeString(this.f5816b);
        parcel.writeString(this.f5817c);
        parcel.writeString(this.f5818d);
    }

    public Province(Parcel parcel) {
        this.f5815a = "";
        this.f5818d = "";
        this.f5815a = parcel.readString();
        this.f5816b = parcel.readString();
        this.f5817c = parcel.readString();
        this.f5818d = parcel.readString();
    }
}
