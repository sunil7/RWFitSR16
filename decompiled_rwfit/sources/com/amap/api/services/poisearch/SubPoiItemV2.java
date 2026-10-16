package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class SubPoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<SubPoiItemV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6167a;

    /* renamed from: b, reason: collision with root package name */
    private String f6168b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6169c;

    /* renamed from: d, reason: collision with root package name */
    private String f6170d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6171f;

    public static class a implements Parcelable.Creator<SubPoiItemV2> {
        @Override // android.os.Parcelable.Creator
        public SubPoiItemV2 createFromParcel(Parcel parcel) {
            return new SubPoiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SubPoiItemV2[] newArray(int i3) {
            return null;
        }
    }

    public SubPoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f6167a = str;
        this.f6169c = latLonPoint;
        this.f6168b = str2;
        this.f6170d = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f6169c;
    }

    public String getPoiId() {
        return this.f6167a;
    }

    public String getSnippet() {
        return this.f6170d;
    }

    public String getSubTypeDes() {
        return this.e;
    }

    public String getTitle() {
        return this.f6168b;
    }

    public String getTypeCode() {
        return this.f6171f;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f6169c = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f6167a = str;
    }

    public void setSnippet(String str) {
        this.f6170d = str;
    }

    public void setSubTypeDes(String str) {
        this.e = str;
    }

    public void setTitle(String str) {
        this.f6168b = str;
    }

    public void setTypeCode(String str) {
        this.f6171f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6167a);
        parcel.writeString(this.f6168b);
        parcel.writeValue(this.f6169c);
        parcel.writeString(this.f6170d);
        parcel.writeString(this.e);
        parcel.writeString(this.f6171f);
    }

    public SubPoiItemV2(Parcel parcel) {
        this.f6167a = parcel.readString();
        this.f6168b = parcel.readString();
        this.f6169c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f6170d = parcel.readString();
        this.e = parcel.readString();
        this.f6171f = parcel.readString();
    }
}
