package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResultV2> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<WalkPath> f6491c;

    /* renamed from: d, reason: collision with root package name */
    private RouteSearchV2.WalkRouteQuery f6492d;

    public static class a implements Parcelable.Creator<WalkRouteResultV2> {
        @Override // android.os.Parcelable.Creator
        public WalkRouteResultV2 createFromParcel(Parcel parcel) {
            return new WalkRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WalkRouteResultV2[] newArray(int i3) {
            return new WalkRouteResultV2[i3];
        }
    }

    public WalkRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f6491c = new ArrayList();
        this.f6491c = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f6492d = (RouteSearchV2.WalkRouteQuery) parcel.readParcelable(RouteSearchV2.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f6491c;
    }

    public RouteSearchV2.WalkRouteQuery getWalkQuery() {
        return this.f6492d;
    }

    public void setPaths(List<WalkPath> list) {
        this.f6491c = list;
    }

    public void setWalkQuery(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        this.f6492d = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeTypedList(this.f6491c);
        parcel.writeParcelable(this.f6492d, i3);
    }

    public WalkRouteResultV2() {
        this.f6491c = new ArrayList();
    }
}
