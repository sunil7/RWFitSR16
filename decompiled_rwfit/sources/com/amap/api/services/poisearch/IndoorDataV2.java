package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IndoorDataV2 implements Parcelable {
    public static final Parcelable.Creator<IndoorDataV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f6096a;

    /* renamed from: b, reason: collision with root package name */
    private String f6097b;

    /* renamed from: c, reason: collision with root package name */
    private int f6098c;

    /* renamed from: d, reason: collision with root package name */
    private String f6099d;

    public static class a implements Parcelable.Creator<IndoorDataV2> {
        @Override // android.os.Parcelable.Creator
        public IndoorDataV2 createFromParcel(Parcel parcel) {
            return new IndoorDataV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IndoorDataV2[] newArray(int i3) {
            return new IndoorDataV2[i3];
        }
    }

    public IndoorDataV2(boolean z5, String str, int i3, String str2) {
        this.f6096a = z5;
        this.f6097b = str;
        this.f6098c = i3;
        this.f6099d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f6098c;
    }

    public String getFloorName() {
        return this.f6099d;
    }

    public String getPoiId() {
        return this.f6097b;
    }

    public boolean isIndoorMap() {
        return this.f6096a;
    }

    public void setFloor(int i3) {
        this.f6098c = i3;
    }

    public void setFloorName(String str) {
        this.f6099d = str;
    }

    public void setIndoorMap(boolean z5) {
        this.f6096a = z5;
    }

    public void setPoiId(String str) {
        this.f6097b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeBooleanArray(new boolean[]{this.f6096a});
        parcel.writeString(this.f6097b);
        parcel.writeInt(this.f6098c);
        parcel.writeString(this.f6099d);
    }

    public IndoorDataV2(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f6096a = zArr[0];
        this.f6097b = parcel.readString();
        this.f6098c = parcel.readInt();
        this.f6099d = parcel.readString();
    }
}
