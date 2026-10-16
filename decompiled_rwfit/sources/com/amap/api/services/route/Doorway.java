package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6235a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f6236b;

    public static class a implements Parcelable.Creator<Doorway> {
        @Override // android.os.Parcelable.Creator
        public Doorway createFromParcel(Parcel parcel) {
            return new Doorway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Doorway[] newArray(int i3) {
            return null;
        }
    }

    public Doorway(Parcel parcel) {
        this.f6235a = parcel.readString();
        this.f6236b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f6236b;
    }

    public String getName() {
        return this.f6235a;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f6236b = latLonPoint;
    }

    public void setName(String str) {
        this.f6235a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6235a);
        parcel.writeParcelable(this.f6236b, i3);
    }

    public Doorway() {
    }
}
