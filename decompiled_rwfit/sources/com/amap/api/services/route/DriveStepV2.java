package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveStepV2 implements Parcelable {
    public static final Parcelable.Creator<DriveStepV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6272a;

    /* renamed from: b, reason: collision with root package name */
    private String f6273b;

    /* renamed from: c, reason: collision with root package name */
    private String f6274c;

    /* renamed from: d, reason: collision with root package name */
    private List<LatLonPoint> f6275d;
    private List<RouteSearchCity> e;

    /* renamed from: f, reason: collision with root package name */
    private List<TMC> f6276f;

    /* renamed from: g, reason: collision with root package name */
    private int f6277g;

    /* renamed from: h, reason: collision with root package name */
    private Cost f6278h;

    /* renamed from: i, reason: collision with root package name */
    private Navi f6279i;

    public static class a implements Parcelable.Creator<DriveStepV2> {
        @Override // android.os.Parcelable.Creator
        public DriveStepV2 createFromParcel(Parcel parcel) {
            return new DriveStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DriveStepV2[] newArray(int i3) {
            return null;
        }
    }

    public DriveStepV2(Parcel parcel) {
        this.f6275d = new ArrayList();
        this.e = new ArrayList();
        this.f6276f = new ArrayList();
        this.f6277g = -1;
        this.f6272a = parcel.readString();
        this.f6273b = parcel.readString();
        this.f6274c = parcel.readString();
        this.f6275d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.e = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f6276f = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Cost getCostDetail() {
        return this.f6278h;
    }

    public String getInstruction() {
        return this.f6272a;
    }

    public Navi getNavi() {
        return this.f6279i;
    }

    public String getOrientation() {
        return this.f6273b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f6275d;
    }

    public String getRoad() {
        return this.f6274c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.e;
    }

    public int getStepDistance() {
        return this.f6277g;
    }

    public List<TMC> getTMCs() {
        return this.f6276f;
    }

    public void setCostDetail(Cost cost) {
        this.f6278h = cost;
    }

    public void setInstruction(String str) {
        this.f6272a = str;
    }

    public void setNavi(Navi navi) {
        this.f6279i = navi;
    }

    public void setOrientation(String str) {
        this.f6273b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f6275d = list;
    }

    public void setRoad(String str) {
        this.f6274c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.e = list;
    }

    public void setStepDistance(int i3) {
        this.f6277g = i3;
    }

    public void setTMCs(List<TMC> list) {
        this.f6276f = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6272a);
        parcel.writeString(this.f6273b);
        parcel.writeString(this.f6274c);
        parcel.writeTypedList(this.f6275d);
        parcel.writeTypedList(this.e);
        parcel.writeTypedList(this.f6276f);
    }

    public DriveStepV2() {
        this.f6275d = new ArrayList();
        this.e = new ArrayList();
        this.f6276f = new ArrayList();
        this.f6277g = -1;
    }
}
