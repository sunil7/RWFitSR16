package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<WalkPath> f6489c;

    /* renamed from: d, reason: collision with root package name */
    private RouteSearch.WalkRouteQuery f6490d;

    public static class a implements Parcelable.Creator<WalkRouteResult> {
        @Override // android.os.Parcelable.Creator
        public WalkRouteResult createFromParcel(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WalkRouteResult[] newArray(int i3) {
            return new WalkRouteResult[i3];
        }
    }

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f6489c = new ArrayList();
        this.f6489c = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f6490d = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f6489c;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.f6490d;
    }

    public void setPaths(List<WalkPath> list) {
        this.f6489c = list;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.f6490d = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeTypedList(this.f6489c);
        parcel.writeParcelable(this.f6490d, i3);
    }

    public WalkRouteResult() {
        this.f6489c = new ArrayList();
    }
}
