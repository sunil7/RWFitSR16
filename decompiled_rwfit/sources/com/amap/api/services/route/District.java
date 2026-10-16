package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6233a;

    /* renamed from: b, reason: collision with root package name */
    private String f6234b;

    public static class a implements Parcelable.Creator<District> {
        @Override // android.os.Parcelable.Creator
        public District createFromParcel(Parcel parcel) {
            return new District(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ District[] newArray(int i3) {
            return null;
        }
    }

    public District(Parcel parcel) {
        this.f6233a = parcel.readString();
        this.f6234b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.f6234b;
    }

    public String getDistrictName() {
        return this.f6233a;
    }

    public void setDistrictAdcode(String str) {
        this.f6234b = str;
    }

    public void setDistrictName(String str) {
        this.f6233a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6233a);
        parcel.writeString(this.f6234b);
    }

    public District() {
    }
}
