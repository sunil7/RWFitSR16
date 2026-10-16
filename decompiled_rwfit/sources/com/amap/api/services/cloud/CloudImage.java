package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5897a;

    /* renamed from: b, reason: collision with root package name */
    private String f5898b;

    /* renamed from: c, reason: collision with root package name */
    private String f5899c;

    public static class a implements Parcelable.Creator<CloudImage> {
        @Override // android.os.Parcelable.Creator
        public CloudImage createFromParcel(Parcel parcel) {
            return new CloudImage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CloudImage[] newArray(int i3) {
            return new CloudImage[i3];
        }
    }

    public CloudImage(String str, String str2, String str3) {
        this.f5897a = str;
        this.f5898b = str2;
        this.f5899c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f5897a;
    }

    public String getPreurl() {
        return this.f5898b;
    }

    public String getUrl() {
        return this.f5899c;
    }

    public void setId(String str) {
        this.f5897a = str;
    }

    public void setPreurl(String str) {
        this.f5898b = str;
    }

    public void setUrl(String str) {
        this.f5899c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5897a);
        parcel.writeString(this.f5898b);
        parcel.writeString(this.f5899c);
    }

    public CloudImage(Parcel parcel) {
        this.f5897a = parcel.readString();
        this.f5898b = parcel.readString();
        this.f5899c = parcel.readString();
    }
}
