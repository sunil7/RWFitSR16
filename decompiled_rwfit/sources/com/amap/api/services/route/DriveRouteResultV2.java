package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResultV2> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f6258c;

    /* renamed from: d, reason: collision with root package name */
    private List<DrivePathV2> f6259d;
    private RouteSearchV2.DriveRouteQuery e;

    public static class a implements Parcelable.Creator<DriveRouteResultV2> {
        @Override // android.os.Parcelable.Creator
        public DriveRouteResultV2 createFromParcel(Parcel parcel) {
            return new DriveRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DriveRouteResultV2[] newArray(int i3) {
            return new DriveRouteResultV2[i3];
        }
    }

    public DriveRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f6259d = new ArrayList();
        this.f6258c = parcel.readFloat();
        this.f6259d = parcel.createTypedArrayList(DrivePathV2.CREATOR);
        this.e = (RouteSearchV2.DriveRouteQuery) parcel.readParcelable(RouteSearchV2.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.DriveRouteQuery getDriveQuery() {
        return this.e;
    }

    public List<DrivePathV2> getPaths() {
        return this.f6259d;
    }

    public float getTaxiCost() {
        return this.f6258c;
    }

    public void setDriveQuery(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        this.e = driveRouteQuery;
    }

    public void setPaths(List<DrivePathV2> list) {
        this.f6259d = list;
    }

    public void setTaxiCost(float f2) {
        this.f6258c = f2;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f6258c);
        parcel.writeTypedList(this.f6259d);
        parcel.writeParcelable(this.e, i3);
    }

    public DriveRouteResultV2() {
        this.f6259d = new ArrayList();
    }
}
