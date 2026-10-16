package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    float f6247a;

    /* renamed from: b, reason: collision with root package name */
    int f6248b;

    /* renamed from: c, reason: collision with root package name */
    private List<DrivePlanStep> f6249c;

    public static class a implements Parcelable.Creator<DrivePlanPath> {
        @Override // android.os.Parcelable.Creator
        public DrivePlanPath createFromParcel(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i3) {
            return null;
        }
    }

    public DrivePlanPath(Parcel parcel) {
        this.f6249c = new ArrayList();
        this.f6247a = parcel.readFloat();
        this.f6248b = parcel.readInt();
        this.f6249c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f6247a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.f6249c;
    }

    public float getTrafficLights() {
        return this.f6248b;
    }

    public void setDistance(float f2) {
        this.f6247a = f2;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.f6249c = list;
    }

    public void setTrafficLights(int i3) {
        this.f6248b = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f6247a);
        parcel.writeInt(this.f6248b);
        parcel.writeTypedList(this.f6249c);
    }

    public DrivePlanPath() {
        this.f6249c = new ArrayList();
    }
}
