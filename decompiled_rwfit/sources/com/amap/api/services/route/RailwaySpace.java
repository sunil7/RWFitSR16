package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6292a;

    /* renamed from: b, reason: collision with root package name */
    private float f6293b;

    public static class a implements Parcelable.Creator<RailwaySpace> {
        @Override // android.os.Parcelable.Creator
        public RailwaySpace createFromParcel(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RailwaySpace[] newArray(int i3) {
            return new RailwaySpace[i3];
        }
    }

    public RailwaySpace(String str, float f2) {
        this.f6292a = str;
        this.f6293b = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.f6292a;
    }

    public float getCost() {
        return this.f6293b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6292a);
        parcel.writeFloat(this.f6293b);
    }

    public RailwaySpace(Parcel parcel) {
        this.f6292a = parcel.readString();
        this.f6293b = parcel.readFloat();
    }
}
