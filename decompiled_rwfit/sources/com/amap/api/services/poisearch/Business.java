package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Business implements Parcelable {
    public static final Parcelable.Creator<Business> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6084a;

    /* renamed from: b, reason: collision with root package name */
    private String f6085b;

    /* renamed from: c, reason: collision with root package name */
    private String f6086c;

    /* renamed from: d, reason: collision with root package name */
    private String f6087d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6088f;

    /* renamed from: g, reason: collision with root package name */
    private String f6089g;

    /* renamed from: h, reason: collision with root package name */
    private String f6090h;

    /* renamed from: i, reason: collision with root package name */
    private String f6091i;

    /* renamed from: j, reason: collision with root package name */
    private String f6092j;

    public static class a implements Parcelable.Creator<Business> {
        @Override // android.os.Parcelable.Creator
        public Business createFromParcel(Parcel parcel) {
            return new Business(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Business[] newArray(int i3) {
            return new Business[i3];
        }
    }

    public Business(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f6084a = str;
        this.f6085b = str2;
        this.f6086c = str3;
        this.f6087d = str4;
        this.e = str5;
        this.f6088f = str6;
        this.f6089g = str7;
        this.f6090h = str8;
        this.f6091i = str9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.f6091i;
    }

    public String getBusinessArea() {
        return this.f6084a;
    }

    public String getCPID() {
        return this.f6092j;
    }

    public String getCost() {
        return this.f6089g;
    }

    public String getOpentimeToday() {
        return this.f6085b;
    }

    public String getOpentimeWeek() {
        return this.f6086c;
    }

    public String getParkingType() {
        return this.f6090h;
    }

    public String getTag() {
        return this.e;
    }

    public String getTel() {
        return this.f6087d;
    }

    public String getmRating() {
        return this.f6088f;
    }

    public void setCPID(String str) {
        this.f6092j = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6084a);
        parcel.writeString(this.f6085b);
        parcel.writeString(this.f6086c);
        parcel.writeString(this.f6087d);
        parcel.writeString(this.e);
        parcel.writeString(this.f6088f);
        parcel.writeString(this.f6089g);
        parcel.writeString(this.f6090h);
        parcel.writeString(this.f6091i);
        parcel.writeString(this.f6092j);
    }

    public Business(Parcel parcel) {
        this.f6084a = parcel.readString();
        this.f6085b = parcel.readString();
        this.f6086c = parcel.readString();
        this.f6087d = parcel.readString();
        this.e = parcel.readString();
        this.f6088f = parcel.readString();
        this.f6089g = parcel.readString();
        this.f6090h = parcel.readString();
        this.f6091i = parcel.readString();
        this.f6092j = parcel.readString();
    }
}
