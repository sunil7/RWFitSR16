package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private String f5787f;

    /* renamed from: g, reason: collision with root package name */
    private long f5788g;

    /* renamed from: h, reason: collision with root package name */
    private int f5789h;

    /* renamed from: i, reason: collision with root package name */
    private String f5790i;

    /* renamed from: j, reason: collision with root package name */
    private int f5791j;

    public static class a implements Parcelable.Creator<OfflineMapCity> {
        @Override // android.os.Parcelable.Creator
        public OfflineMapCity createFromParcel(Parcel parcel) {
            return new OfflineMapCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public OfflineMapCity[] newArray(int i3) {
            return new OfflineMapCity[i3];
        }
    }

    public OfflineMapCity() {
        this.f5787f = "";
        this.f5788g = 0L;
        this.f5789h = 6;
        this.f5790i = "";
        this.f5791j = 0;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.f5788g;
    }

    public int getState() {
        return this.f5789h;
    }

    public String getUrl() {
        return this.f5787f;
    }

    public String getVersion() {
        return this.f5790i;
    }

    public int getcompleteCode() {
        return this.f5791j;
    }

    public void setCompleteCode(int i3) {
        this.f5791j = i3;
    }

    public void setSize(long j4) {
        this.f5788g = j4;
    }

    public void setState(int i3) {
        this.f5789h = i3;
    }

    public void setUrl(String str) {
        this.f5787f = str;
    }

    public void setVersion(String str) {
        this.f5790i = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f5787f);
        parcel.writeLong(this.f5788g);
        parcel.writeInt(this.f5789h);
        parcel.writeString(this.f5790i);
        parcel.writeInt(this.f5791j);
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f5787f = "";
        this.f5788g = 0L;
        this.f5789h = 6;
        this.f5790i = "";
        this.f5791j = 0;
        this.f5787f = parcel.readString();
        this.f5788g = parcel.readLong();
        this.f5789h = parcel.readInt();
        this.f5790i = parcel.readString();
        this.f5791j = parcel.readInt();
    }
}
