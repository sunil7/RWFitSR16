package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusPath extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPath> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private float f6183d;
    private boolean e;

    /* renamed from: f, reason: collision with root package name */
    private float f6184f;

    /* renamed from: g, reason: collision with root package name */
    private float f6185g;

    /* renamed from: h, reason: collision with root package name */
    private List<BusStep> f6186h;

    public static class a implements Parcelable.Creator<BusPath> {
        @Override // android.os.Parcelable.Creator
        public BusPath createFromParcel(Parcel parcel) {
            return new BusPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusPath[] newArray(int i3) {
            return null;
        }
    }

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f6186h = new ArrayList();
        this.f6183d = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.e = zArr[0];
        this.f6184f = parcel.readFloat();
        this.f6185g = parcel.readFloat();
        this.f6186h = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f6185g;
    }

    public float getCost() {
        return this.f6183d;
    }

    public List<BusStep> getSteps() {
        return this.f6186h;
    }

    public float getWalkDistance() {
        return this.f6184f;
    }

    public boolean isNightBus() {
        return this.e;
    }

    public void setBusDistance(float f2) {
        this.f6185g = f2;
    }

    public void setCost(float f2) {
        this.f6183d = f2;
    }

    public void setNightBus(boolean z5) {
        this.e = z5;
    }

    public void setSteps(List<BusStep> list) {
        this.f6186h = list;
    }

    public void setWalkDistance(float f2) {
        this.f6184f = f2;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f6183d);
        parcel.writeBooleanArray(new boolean[]{this.e});
        parcel.writeFloat(this.f6184f);
        parcel.writeFloat(this.f6185g);
        parcel.writeTypedList(this.f6186h);
    }

    public BusPath() {
        this.f6186h = new ArrayList();
    }
}
