package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6100a;

    /* renamed from: b, reason: collision with root package name */
    private String f6101b;

    public static class a implements Parcelable.Creator<Photo> {
        @Override // android.os.Parcelable.Creator
        public Photo createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Photo[] newArray(int i3) {
            return null;
        }
    }

    public Photo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.f6100a;
    }

    public String getUrl() {
        return this.f6101b;
    }

    public void setTitle(String str) {
        this.f6100a = str;
    }

    public void setUrl(String str) {
        this.f6101b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6100a);
        parcel.writeString(this.f6101b);
    }

    public Photo(String str, String str2) {
        this.f6100a = str;
        this.f6101b = str2;
    }

    public Photo(Parcel parcel) {
        this.f6100a = parcel.readString();
        this.f6101b = parcel.readString();
    }
}
