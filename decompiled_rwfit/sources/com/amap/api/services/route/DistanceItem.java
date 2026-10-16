package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = new a();
    public final int ERROR_CODE_NOT_IN_CHINA;
    public final int ERROR_CODE_NO_DRIVE;
    public final int ERROR_CODE_TOO_FAR;

    /* renamed from: a, reason: collision with root package name */
    private int f6221a;

    /* renamed from: b, reason: collision with root package name */
    private int f6222b;

    /* renamed from: c, reason: collision with root package name */
    private float f6223c;

    /* renamed from: d, reason: collision with root package name */
    private float f6224d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private int f6225f;

    public static class a implements Parcelable.Creator<DistanceItem> {
        @Override // android.os.Parcelable.Creator
        public DistanceItem createFromParcel(Parcel parcel) {
            return new DistanceItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistanceItem[] newArray(int i3) {
            return new DistanceItem[i3];
        }
    }

    public DistanceItem() {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f6221a = 1;
        this.f6222b = 1;
        this.f6223c = 0.0f;
        this.f6224d = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDestId() {
        return this.f6222b;
    }

    public float getDistance() {
        return this.f6223c;
    }

    public float getDuration() {
        return this.f6224d;
    }

    public int getErrorCode() {
        return this.f6225f;
    }

    public String getErrorInfo() {
        return this.e;
    }

    public int getOriginId() {
        return this.f6221a;
    }

    public void setDestId(int i3) {
        this.f6222b = i3;
    }

    public void setDistance(float f2) {
        this.f6223c = f2;
    }

    public void setDuration(float f2) {
        this.f6224d = f2;
    }

    public void setErrorCode(int i3) {
        this.f6225f = i3;
    }

    public void setErrorInfo(String str) {
        this.e = str;
    }

    public void setOriginId(int i3) {
        this.f6221a = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f6221a);
        parcel.writeInt(this.f6222b);
        parcel.writeFloat(this.f6223c);
        parcel.writeFloat(this.f6224d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f6225f);
    }

    public DistanceItem(Parcel parcel) {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f6221a = 1;
        this.f6222b = 1;
        this.f6223c = 0.0f;
        this.f6224d = 0.0f;
        this.f6221a = parcel.readInt();
        this.f6222b = parcel.readInt();
        this.f6223c = parcel.readFloat();
        this.f6224d = parcel.readFloat();
        this.e = parcel.readString();
        this.f6225f = parcel.readInt();
    }
}
