package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6093a;

    /* renamed from: b, reason: collision with root package name */
    private int f6094b;

    /* renamed from: c, reason: collision with root package name */
    private String f6095c;

    public static class a implements Parcelable.Creator<IndoorData> {
        @Override // android.os.Parcelable.Creator
        public IndoorData createFromParcel(Parcel parcel) {
            return new IndoorData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IndoorData[] newArray(int i3) {
            return new IndoorData[i3];
        }
    }

    public IndoorData(String str, int i3, String str2) {
        this.f6093a = str;
        this.f6094b = i3;
        this.f6095c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f6094b;
    }

    public String getFloorName() {
        return this.f6095c;
    }

    public String getPoiId() {
        return this.f6093a;
    }

    public void setFloor(int i3) {
        this.f6094b = i3;
    }

    public void setFloorName(String str) {
        this.f6095c = str;
    }

    public void setPoiId(String str) {
        this.f6093a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6093a);
        parcel.writeInt(this.f6094b);
        parcel.writeString(this.f6095c);
    }

    public IndoorData(Parcel parcel) {
        this.f6093a = parcel.readString();
        this.f6094b = parcel.readInt();
        this.f6095c = parcel.readString();
    }
}
