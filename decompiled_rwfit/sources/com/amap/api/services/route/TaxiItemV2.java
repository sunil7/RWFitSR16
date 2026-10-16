package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TaxiItemV2 implements Parcelable {
    public static final Parcelable.Creator<TaxiItemV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f6452a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6453b;

    /* renamed from: c, reason: collision with root package name */
    private float f6454c;

    /* renamed from: d, reason: collision with root package name */
    private float f6455d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6456f;

    /* renamed from: g, reason: collision with root package name */
    private float f6457g;

    /* renamed from: h, reason: collision with root package name */
    private List<LatLonPoint> f6458h;

    public static class a implements Parcelable.Creator<TaxiItemV2> {
        @Override // android.os.Parcelable.Creator
        public TaxiItemV2 createFromParcel(Parcel parcel) {
            return new TaxiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TaxiItemV2[] newArray(int i3) {
            return new TaxiItemV2[i3];
        }
    }

    public TaxiItemV2() {
        this.f6458h = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f6453b;
    }

    public float getDistance() {
        return this.f6454c;
    }

    public float getDuration() {
        return this.f6455d;
    }

    public LatLonPoint getOrigin() {
        return this.f6452a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f6458h;
    }

    public float getPrice() {
        return this.f6457g;
    }

    public String getmSname() {
        return this.e;
    }

    public String getmTname() {
        return this.f6456f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f6453b = latLonPoint;
    }

    public void setDistance(float f2) {
        this.f6454c = f2;
    }

    public void setDuration(float f2) {
        this.f6455d = f2;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f6452a = latLonPoint;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f6458h = list;
    }

    public void setPrice(float f2) {
        this.f6457g = f2;
    }

    public void setSname(String str) {
        this.e = str;
    }

    public void setTname(String str) {
        this.f6456f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f6452a, i3);
        parcel.writeParcelable(this.f6453b, i3);
        parcel.writeFloat(this.f6454c);
        parcel.writeFloat(this.f6455d);
        parcel.writeString(this.e);
        parcel.writeString(this.f6456f);
        parcel.writeFloat(this.f6457g);
        parcel.writeTypedList(this.f6458h);
    }

    public TaxiItemV2(Parcel parcel) {
        this.f6458h = new ArrayList();
        this.f6452a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6453b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f6454c = parcel.readFloat();
        this.f6455d = parcel.readFloat();
        this.e = parcel.readString();
        this.f6456f = parcel.readString();
        this.f6457g = parcel.readFloat();
        this.f6458h = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }
}
