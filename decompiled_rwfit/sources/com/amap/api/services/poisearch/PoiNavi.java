package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class PoiNavi implements Parcelable {
    public static final Parcelable.Creator<PoiNavi> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6104a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6105b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6106c;

    /* renamed from: d, reason: collision with root package name */
    private String f6107d;

    public static class a implements Parcelable.Creator<PoiNavi> {
        @Override // android.os.Parcelable.Creator
        public PoiNavi createFromParcel(Parcel parcel) {
            return new PoiNavi(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PoiNavi[] newArray(int i3) {
            return null;
        }
    }

    public PoiNavi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getEnter() {
        return this.f6105b;
    }

    public LatLonPoint getExit() {
        return this.f6106c;
    }

    public String getGridCode() {
        return this.f6107d;
    }

    public String getNaviPoiID() {
        return this.f6104a;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f6105b = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f6106c = latLonPoint;
    }

    public void setGridCode(String str) {
        this.f6107d = str;
    }

    public void setNaviPoiID(String str) {
        this.f6104a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6104a);
        parcel.writeValue(this.f6105b);
        parcel.writeValue(this.f6106c);
        parcel.writeString(this.f6107d);
    }

    public PoiNavi(String str, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, String str2) {
        this.f6104a = str;
        this.f6105b = latLonPoint;
        this.f6106c = latLonPoint2;
        this.f6107d = str2;
    }

    public PoiNavi(Parcel parcel) {
        this.f6104a = parcel.readString();
        this.f6105b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f6106c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f6107d = parcel.readString();
    }
}
