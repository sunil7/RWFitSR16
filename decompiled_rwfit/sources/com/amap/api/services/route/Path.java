package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f6287a;

    /* renamed from: b, reason: collision with root package name */
    private long f6288b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f6289c;

    public static class a implements Parcelable.Creator<Path> {
        @Override // android.os.Parcelable.Creator
        public Path createFromParcel(Parcel parcel) {
            return new Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Path[] newArray(int i3) {
            return null;
        }
    }

    public Path(Parcel parcel) {
        this.f6289c = new ArrayList();
        this.f6287a = parcel.readFloat();
        this.f6288b = parcel.readLong();
        this.f6289c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f6287a;
    }

    public long getDuration() {
        return this.f6288b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f6289c;
    }

    public void setDistance(float f2) {
        this.f6287a = f2;
    }

    public void setDuration(long j4) {
        this.f6288b = j4;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f6289c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f6287a);
        parcel.writeLong(this.f6288b);
        parcel.writeTypedList(this.f6289c);
    }

    public Path() {
        this.f6289c = new ArrayList();
    }
}
