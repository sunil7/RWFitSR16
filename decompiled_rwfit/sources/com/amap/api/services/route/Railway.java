package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6290a;

    /* renamed from: b, reason: collision with root package name */
    private String f6291b;

    public static class a implements Parcelable.Creator<Railway> {
        @Override // android.os.Parcelable.Creator
        public Railway createFromParcel(Parcel parcel) {
            return new Railway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Railway[] newArray(int i3) {
            return new Railway[i3];
        }
    }

    public Railway() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getID() {
        return this.f6290a;
    }

    public String getName() {
        return this.f6291b;
    }

    public void setID(String str) {
        this.f6290a = str;
    }

    public void setName(String str) {
        this.f6291b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6290a);
        parcel.writeString(this.f6291b);
    }

    public Railway(Parcel parcel) {
        this.f6290a = parcel.readString();
        this.f6291b = parcel.readString();
    }
}
