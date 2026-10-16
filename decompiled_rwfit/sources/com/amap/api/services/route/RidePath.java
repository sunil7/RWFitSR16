package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RidePath extends Path implements Parcelable {
    public static final Parcelable.Creator<RidePath> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private List<RideStep> f6301d;

    public static class a implements Parcelable.Creator<RidePath> {
        @Override // android.os.Parcelable.Creator
        public RidePath createFromParcel(Parcel parcel) {
            return new RidePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RidePath[] newArray(int i3) {
            return null;
        }
    }

    public RidePath(Parcel parcel) {
        super(parcel);
        this.f6301d = new ArrayList();
        this.f6301d = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RideStep> getSteps() {
        return this.f6301d;
    }

    public void setSteps(List<RideStep> list) {
        this.f6301d = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeTypedList(this.f6301d);
    }

    public RidePath() {
        this.f6301d = new ArrayList();
    }
}
