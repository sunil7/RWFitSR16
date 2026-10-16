package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new a();
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private int f5810f;

    /* renamed from: g, reason: collision with root package name */
    private long f5811g;

    /* renamed from: h, reason: collision with root package name */
    private String f5812h;

    /* renamed from: i, reason: collision with root package name */
    private int f5813i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<OfflineMapCity> f5814j;

    public static class a implements Parcelable.Creator<OfflineMapProvince> {
        @Override // android.os.Parcelable.Creator
        public OfflineMapProvince createFromParcel(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public OfflineMapProvince[] newArray(int i3) {
            return new OfflineMapProvince[i3];
        }
    }

    public OfflineMapProvince() {
        this.f5810f = 6;
        this.f5813i = 0;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        ArrayList<OfflineMapCity> arrayList = this.f5814j;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public int getCompleteCode() {
        return this.f5813i;
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = this.f5814j;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                OfflineMapCity offlineMapCity = arrayList2.get(i3);
                i3++;
                OfflineMapCity offlineMapCity2 = offlineMapCity;
                if (offlineMapCity2.getState() != 6) {
                    arrayList.add(offlineMapCity2);
                }
            }
        }
        return arrayList;
    }

    public long getSize() {
        return this.f5811g;
    }

    public int getState() {
        return this.f5810f;
    }

    public String getUrl() {
        return this.e;
    }

    public String getVersion() {
        return this.f5812h;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f5814j = arrayList;
    }

    public void setCompleteCode(int i3) {
        this.f5813i = i3;
    }

    public void setSize(long j4) {
        this.f5811g = j4;
    }

    public void setState(int i3) {
        this.f5810f = i3;
    }

    public void setUrl(String str) {
        this.e = str;
    }

    public void setVersion(String str) {
        this.f5812h = str;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.e);
        parcel.writeInt(this.f5810f);
        parcel.writeLong(this.f5811g);
        parcel.writeString(this.f5812h);
        parcel.writeInt(this.f5813i);
        parcel.writeTypedList(this.f5814j);
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f5810f = 6;
        this.f5813i = 0;
        this.e = parcel.readString();
        this.f5810f = parcel.readInt();
        this.f5811g = parcel.readLong();
        this.f5812h = parcel.readString();
        this.f5813i = parcel.readInt();
        this.f5814j = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }
}
