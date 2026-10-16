package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6294a;

    /* renamed from: b, reason: collision with root package name */
    private String f6295b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6296c;

    /* renamed from: d, reason: collision with root package name */
    private String f6297d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6298f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6299g;

    /* renamed from: h, reason: collision with root package name */
    private float f6300h;

    public static class a implements Parcelable.Creator<RailwayStationItem> {
        @Override // android.os.Parcelable.Creator
        public RailwayStationItem createFromParcel(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RailwayStationItem[] newArray(int i3) {
            return new RailwayStationItem[i3];
        }
    }

    public RailwayStationItem() {
        this.f6298f = false;
        this.f6299g = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f6297d;
    }

    public String getID() {
        return this.f6294a;
    }

    public LatLonPoint getLocation() {
        return this.f6296c;
    }

    public String getName() {
        return this.f6295b;
    }

    public String getTime() {
        return this.e;
    }

    public float getWait() {
        return this.f6300h;
    }

    public boolean isEnd() {
        return this.f6299g;
    }

    public boolean isStart() {
        return this.f6298f;
    }

    public void setAdcode(String str) {
        this.f6297d = str;
    }

    public void setID(String str) {
        this.f6294a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f6296c = latLonPoint;
    }

    public void setName(String str) {
        this.f6295b = str;
    }

    public void setTime(String str) {
        this.e = str;
    }

    public void setWait(float f2) {
        this.f6300h = f2;
    }

    public void setisEnd(boolean z5) {
        this.f6299g = z5;
    }

    public void setisStart(boolean z5) {
        this.f6298f = z5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6294a);
        parcel.writeString(this.f6295b);
        parcel.writeParcelable(this.f6296c, i3);
        parcel.writeString(this.f6297d);
        parcel.writeString(this.e);
        parcel.writeBooleanArray(new boolean[]{this.f6298f, this.f6299g});
        parcel.writeFloat(this.f6300h);
    }

    public RailwayStationItem(Parcel parcel) {
        this.f6298f = false;
        this.f6299g = false;
        this.f6294a = parcel.readString();
        this.f6295b = parcel.readString();
        this.f6296c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6297d = parcel.readString();
        this.e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f6298f = zArr[0];
        this.f6299g = zArr[1];
        this.f6300h = parcel.readFloat();
    }
}
