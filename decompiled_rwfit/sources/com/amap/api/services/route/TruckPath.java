package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class TruckPath implements Parcelable {
    public static final Parcelable.Creator<TruckPath> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f6465a;

    /* renamed from: b, reason: collision with root package name */
    private long f6466b;

    /* renamed from: c, reason: collision with root package name */
    private String f6467c;

    /* renamed from: d, reason: collision with root package name */
    private float f6468d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private int f6469f;

    /* renamed from: g, reason: collision with root package name */
    private int f6470g;

    /* renamed from: h, reason: collision with root package name */
    private List<TruckStep> f6471h;

    public static class a implements Parcelable.Creator<TruckPath> {
        @Override // android.os.Parcelable.Creator
        public TruckPath createFromParcel(Parcel parcel) {
            return new TruckPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TruckPath[] newArray(int i3) {
            return new TruckPath[i3];
        }
    }

    public TruckPath() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f6465a;
    }

    public long getDuration() {
        return this.f6466b;
    }

    public int getRestriction() {
        return this.f6470g;
    }

    public List<TruckStep> getSteps() {
        return this.f6471h;
    }

    public String getStrategy() {
        return this.f6467c;
    }

    public float getTollDistance() {
        return this.e;
    }

    public float getTolls() {
        return this.f6468d;
    }

    public int getTotalTrafficlights() {
        return this.f6469f;
    }

    public void setDistance(float f2) {
        this.f6465a = f2;
    }

    public void setDuration(long j4) {
        this.f6466b = j4;
    }

    public void setRestriction(int i3) {
        this.f6470g = i3;
    }

    public void setSteps(List<TruckStep> list) {
        this.f6471h = list;
    }

    public void setStrategy(String str) {
        this.f6467c = str;
    }

    public void setTollDistance(float f2) {
        this.e = f2;
    }

    public void setTolls(float f2) {
        this.f6468d = f2;
    }

    public void setTotalTrafficlights(int i3) {
        this.f6469f = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f6465a);
        parcel.writeLong(this.f6466b);
        parcel.writeString(this.f6467c);
        parcel.writeFloat(this.f6468d);
        parcel.writeFloat(this.e);
        parcel.writeInt(this.f6469f);
        parcel.writeInt(this.f6470g);
        parcel.writeTypedList(this.f6471h);
    }

    public TruckPath(Parcel parcel) {
        this.f6465a = parcel.readFloat();
        this.f6466b = parcel.readLong();
        this.f6467c = parcel.readString();
        this.f6468d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f6469f = parcel.readInt();
        this.f6470g = parcel.readInt();
        this.f6471h = parcel.createTypedArrayList(TruckStep.CREATOR);
    }
}
