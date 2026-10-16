package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivePath extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePath> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f6237d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private float f6238f;

    /* renamed from: g, reason: collision with root package name */
    private int f6239g;

    /* renamed from: h, reason: collision with root package name */
    private List<DriveStep> f6240h;

    /* renamed from: i, reason: collision with root package name */
    private int f6241i;

    public static class a implements Parcelable.Creator<DrivePath> {
        @Override // android.os.Parcelable.Creator
        public DrivePath createFromParcel(Parcel parcel) {
            return new DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DrivePath[] newArray(int i3) {
            return null;
        }
    }

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f6240h = new ArrayList();
        this.f6237d = parcel.readString();
        this.e = parcel.readFloat();
        this.f6238f = parcel.readFloat();
        this.f6240h = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.f6239g = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f6241i;
    }

    public List<DriveStep> getSteps() {
        return this.f6240h;
    }

    public String getStrategy() {
        return this.f6237d;
    }

    public float getTollDistance() {
        return this.f6238f;
    }

    public float getTolls() {
        return this.e;
    }

    public int getTotalTrafficlights() {
        return this.f6239g;
    }

    public void setRestriction(int i3) {
        this.f6241i = i3;
    }

    public void setSteps(List<DriveStep> list) {
        this.f6240h = list;
    }

    public void setStrategy(String str) {
        this.f6237d = str;
    }

    public void setTollDistance(float f2) {
        this.f6238f = f2;
    }

    public void setTolls(float f2) {
        this.e = f2;
    }

    public void setTotalTrafficlights(int i3) {
        this.f6239g = i3;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f6237d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f6238f);
        parcel.writeTypedList(this.f6240h);
        parcel.writeInt(this.f6239g);
    }

    public DrivePath() {
        this.f6240h = new ArrayList();
    }
}
