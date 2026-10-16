package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* loaded from: classes.dex */
public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private DistanceSearch.DistanceQuery f6226a;

    /* renamed from: b, reason: collision with root package name */
    private List<DistanceItem> f6227b;

    public static class a implements Parcelable.Creator<DistanceResult> {
        @Override // android.os.Parcelable.Creator
        public DistanceResult createFromParcel(Parcel parcel) {
            return new DistanceResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistanceResult[] newArray(int i3) {
            return new DistanceResult[i3];
        }
    }

    public DistanceResult() {
        this.f6227b = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.f6226a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.f6227b;
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery distanceQuery) {
        this.f6226a = distanceQuery;
    }

    public void setDistanceResults(List<DistanceItem> list) {
        this.f6227b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.f6227b);
    }

    public DistanceResult(Parcel parcel) {
        this.f6227b = null;
        this.f6227b = parcel.createTypedArrayList(DistanceItem.CREATOR);
    }
}
