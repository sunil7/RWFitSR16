package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivePathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePathV2> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f6242d;
    private List<DriveStepV2> e;

    /* renamed from: f, reason: collision with root package name */
    private int f6243f;

    /* renamed from: g, reason: collision with root package name */
    private Cost f6244g;

    /* renamed from: h, reason: collision with root package name */
    private ElecConsumeInfo f6245h;

    /* renamed from: i, reason: collision with root package name */
    private List<ChargeStationInfo> f6246i;

    public static class a implements Parcelable.Creator<DrivePathV2> {
        @Override // android.os.Parcelable.Creator
        public DrivePathV2 createFromParcel(Parcel parcel) {
            return new DrivePathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DrivePathV2[] newArray(int i3) {
            return null;
        }
    }

    public DrivePathV2(Parcel parcel) {
        super(parcel);
        this.e = new ArrayList();
        this.f6246i = new ArrayList();
        this.f6242d = parcel.readString();
        this.e = parcel.createTypedArrayList(DriveStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ChargeStationInfo> getChargeStationInfo() {
        return this.f6246i;
    }

    public Cost getCost() {
        return this.f6244g;
    }

    public ElecConsumeInfo getElecConsumeInfo() {
        return this.f6245h;
    }

    public int getRestriction() {
        return this.f6243f;
    }

    public List<DriveStepV2> getSteps() {
        return this.e;
    }

    public String getStrategy() {
        return this.f6242d;
    }

    public void setChargeStationInfo(List<ChargeStationInfo> list) {
        this.f6246i = list;
    }

    public void setCost(Cost cost) {
        this.f6244g = cost;
    }

    public void setElecConsumeInfo(ElecConsumeInfo elecConsumeInfo) {
        this.f6245h = elecConsumeInfo;
    }

    public void setRestriction(int i3) {
        this.f6243f = i3;
    }

    public void setSteps(List<DriveStepV2> list) {
        this.e = list;
    }

    public void setStrategy(String str) {
        this.f6242d = str;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeTypedList(this.e);
    }

    public DrivePathV2() {
        this.e = new ArrayList();
        this.f6246i = new ArrayList();
    }
}
