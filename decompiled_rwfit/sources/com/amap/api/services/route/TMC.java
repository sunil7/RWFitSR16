package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f6444a;

    /* renamed from: b, reason: collision with root package name */
    private String f6445b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f6446c;

    public static class a implements Parcelable.Creator<TMC> {
        @Override // android.os.Parcelable.Creator
        public TMC createFromParcel(Parcel parcel) {
            return new TMC(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TMC[] newArray(int i3) {
            return null;
        }
    }

    public TMC(Parcel parcel) {
        this.f6446c = new ArrayList();
        this.f6444a = parcel.readInt();
        this.f6445b = parcel.readString();
        this.f6446c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f6444a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f6446c;
    }

    public String getStatus() {
        return this.f6445b;
    }

    public void setDistance(int i3) {
        this.f6444a = i3;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f6446c = list;
    }

    public void setStatus(String str) {
        this.f6445b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f6444a);
        parcel.writeString(this.f6445b);
        parcel.writeTypedList(this.f6446c);
    }

    public TMC() {
        this.f6446c = new ArrayList();
    }
}
