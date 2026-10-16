package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f6256c;

    /* renamed from: d, reason: collision with root package name */
    private List<DrivePath> f6257d;
    private RouteSearch.DriveRouteQuery e;

    public static class a implements Parcelable.Creator<DriveRouteResult> {
        @Override // android.os.Parcelable.Creator
        public DriveRouteResult createFromParcel(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DriveRouteResult[] newArray(int i3) {
            return new DriveRouteResult[i3];
        }
    }

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f6257d = new ArrayList();
        this.f6256c = parcel.readFloat();
        this.f6257d = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.e = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.e;
    }

    public List<DrivePath> getPaths() {
        return this.f6257d;
    }

    public float getTaxiCost() {
        return this.f6256c;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.e = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.f6257d = list;
    }

    public void setTaxiCost(float f2) {
        this.f6256c = f2;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f6256c);
        parcel.writeTypedList(this.f6257d);
        parcel.writeParcelable(this.e, i3);
    }

    public DriveRouteResult() {
        this.f6257d = new ArrayList();
    }
}
