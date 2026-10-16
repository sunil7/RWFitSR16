package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveRoutePlanResult extends RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<DrivePlanPath> f6254c;

    /* renamed from: d, reason: collision with root package name */
    private List<TimeInfo> f6255d;
    private RouteSearch.DrivePlanQuery e;

    public static class a implements Parcelable.Creator<DriveRoutePlanResult> {
        @Override // android.os.Parcelable.Creator
        public DriveRoutePlanResult createFromParcel(Parcel parcel) {
            return new DriveRoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DriveRoutePlanResult[] newArray(int i3) {
            return new DriveRoutePlanResult[i3];
        }
    }

    public DriveRoutePlanResult(Parcel parcel) {
        super(parcel);
        this.f6254c = new ArrayList();
        this.f6255d = new ArrayList();
        this.f6254c = parcel.createTypedArrayList(DrivePlanPath.CREATOR);
        this.f6255d = parcel.createTypedArrayList(TimeInfo.CREATOR);
        this.e = (RouteSearch.DrivePlanQuery) parcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivePlanPath> getPaths() {
        return this.f6254c;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.f6255d;
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.e = drivePlanQuery;
        RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    public void setPaths(List<DrivePlanPath> list) {
        this.f6254c = list;
    }

    public void setTimeInfos(List<TimeInfo> list) {
        this.f6255d = list;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeTypedList(this.f6254c);
        parcel.writeTypedList(this.f6255d);
        parcel.writeParcelable(this.e, i3);
    }

    public DriveRoutePlanResult() {
        this.f6254c = new ArrayList();
        this.f6255d = new ArrayList();
    }
}
