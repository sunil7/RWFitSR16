package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6161a;

    /* renamed from: b, reason: collision with root package name */
    private String f6162b;

    /* renamed from: c, reason: collision with root package name */
    private String f6163c;

    /* renamed from: d, reason: collision with root package name */
    private int f6164d;
    private LatLonPoint e;

    /* renamed from: f, reason: collision with root package name */
    private String f6165f;

    /* renamed from: g, reason: collision with root package name */
    private String f6166g;

    public static class a implements Parcelable.Creator<SubPoiItem> {
        @Override // android.os.Parcelable.Creator
        public SubPoiItem createFromParcel(Parcel parcel) {
            return new SubPoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SubPoiItem[] newArray(int i3) {
            return null;
        }
    }

    public SubPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f6161a = str;
        this.e = latLonPoint;
        this.f6162b = str2;
        this.f6165f = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f6164d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.e;
    }

    public String getPoiId() {
        return this.f6161a;
    }

    public String getSnippet() {
        return this.f6165f;
    }

    public String getSubName() {
        return this.f6163c;
    }

    public String getSubTypeDes() {
        return this.f6166g;
    }

    public String getTitle() {
        return this.f6162b;
    }

    public void setDistance(int i3) {
        this.f6164d = i3;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f6161a = str;
    }

    public void setSnippet(String str) {
        this.f6165f = str;
    }

    public void setSubName(String str) {
        this.f6163c = str;
    }

    public void setSubTypeDes(String str) {
        this.f6166g = str;
    }

    public void setTitle(String str) {
        this.f6162b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6161a);
        parcel.writeString(this.f6162b);
        parcel.writeString(this.f6163c);
        parcel.writeInt(this.f6164d);
        parcel.writeValue(this.e);
        parcel.writeString(this.f6165f);
        parcel.writeString(this.f6166g);
    }

    public SubPoiItem(Parcel parcel) {
        this.f6161a = parcel.readString();
        this.f6162b = parcel.readString();
        this.f6163c = parcel.readString();
        this.f6164d = parcel.readInt();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f6165f = parcel.readString();
        this.f6166g = parcel.readString();
    }
}
