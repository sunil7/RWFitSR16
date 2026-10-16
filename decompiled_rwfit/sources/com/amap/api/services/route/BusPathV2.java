package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusPathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPathV2> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private float f6187d;
    private boolean e;

    /* renamed from: f, reason: collision with root package name */
    private float f6188f;

    /* renamed from: g, reason: collision with root package name */
    private float f6189g;

    /* renamed from: h, reason: collision with root package name */
    private List<BusStepV2> f6190h;

    public static class a implements Parcelable.Creator<BusPathV2> {
        @Override // android.os.Parcelable.Creator
        public BusPathV2 createFromParcel(Parcel parcel) {
            return new BusPathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusPathV2[] newArray(int i3) {
            return null;
        }
    }

    public BusPathV2(Parcel parcel) {
        super(parcel);
        this.f6190h = new ArrayList();
        this.f6187d = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.e = zArr[0];
        this.f6188f = parcel.readFloat();
        this.f6189g = parcel.readFloat();
        this.f6190h = parcel.createTypedArrayList(BusStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f6189g;
    }

    public float getCost() {
        return this.f6187d;
    }

    public List<BusStepV2> getSteps() {
        return this.f6190h;
    }

    public float getWalkDistance() {
        return this.f6188f;
    }

    public boolean isNightBus() {
        return this.e;
    }

    public void setBusDistance(float f2) {
        this.f6189g = f2;
    }

    public void setCost(float f2) {
        this.f6187d = f2;
    }

    public void setNightBus(boolean z5) {
        this.e = z5;
    }

    public void setSteps(List<BusStepV2> list) {
        this.f6190h = list;
    }

    public void setWalkDistance(float f2) {
        this.f6188f = f2;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f6187d);
        parcel.writeBooleanArray(new boolean[]{this.e});
        parcel.writeFloat(this.f6188f);
        parcel.writeFloat(this.f6189g);
        parcel.writeTypedList(this.f6190h);
    }

    public BusPathV2() {
        this.f6190h = new ArrayList();
    }
}
