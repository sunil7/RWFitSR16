package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* loaded from: classes.dex */
public class TruckStep implements Parcelable {
    public static final Parcelable.Creator<TruckStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6476a;

    /* renamed from: b, reason: collision with root package name */
    private String f6477b;

    /* renamed from: c, reason: collision with root package name */
    private String f6478c;

    /* renamed from: d, reason: collision with root package name */
    private float f6479d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private float f6480f;

    /* renamed from: g, reason: collision with root package name */
    private String f6481g;

    /* renamed from: h, reason: collision with root package name */
    private float f6482h;

    /* renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f6483i;

    /* renamed from: j, reason: collision with root package name */
    private String f6484j;

    /* renamed from: k, reason: collision with root package name */
    private String f6485k;

    /* renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f6486l;

    /* renamed from: m, reason: collision with root package name */
    private List<TMC> f6487m;

    public static class a implements Parcelable.Creator<TruckStep> {
        @Override // android.os.Parcelable.Creator
        public TruckStep createFromParcel(Parcel parcel) {
            return new TruckStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TruckStep[] newArray(int i3) {
            return new TruckStep[i3];
        }
    }

    public TruckStep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f6484j;
    }

    public String getAssistantAction() {
        return this.f6485k;
    }

    public float getDistance() {
        return this.e;
    }

    public float getDuration() {
        return this.f6482h;
    }

    public String getInstruction() {
        return this.f6476a;
    }

    public String getOrientation() {
        return this.f6477b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f6483i;
    }

    public String getRoad() {
        return this.f6478c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f6486l;
    }

    public List<TMC> getTMCs() {
        return this.f6487m;
    }

    public float getTollDistance() {
        return this.f6480f;
    }

    public String getTollRoad() {
        return this.f6481g;
    }

    public float getTolls() {
        return this.f6479d;
    }

    public void setAction(String str) {
        this.f6484j = str;
    }

    public void setAssistantAction(String str) {
        this.f6485k = str;
    }

    public void setDistance(float f2) {
        this.e = f2;
    }

    public void setDuration(float f2) {
        this.f6482h = f2;
    }

    public void setInstruction(String str) {
        this.f6476a = str;
    }

    public void setOrientation(String str) {
        this.f6477b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f6483i = list;
    }

    public void setRoad(String str) {
        this.f6478c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f6486l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f6487m = list;
    }

    public void setTollDistance(float f2) {
        this.f6480f = f2;
    }

    public void setTollRoad(String str) {
        this.f6481g = str;
    }

    public void setTolls(float f2) {
        this.f6479d = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6476a);
        parcel.writeString(this.f6477b);
        parcel.writeString(this.f6478c);
        parcel.writeFloat(this.f6479d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f6480f);
        parcel.writeString(this.f6481g);
        parcel.writeFloat(this.f6482h);
        parcel.writeTypedList(this.f6483i);
        parcel.writeString(this.f6484j);
        parcel.writeString(this.f6485k);
        parcel.writeTypedList(this.f6486l);
        parcel.writeTypedList(this.f6487m);
    }

    public TruckStep(Parcel parcel) {
        this.f6476a = parcel.readString();
        this.f6477b = parcel.readString();
        this.f6478c = parcel.readString();
        this.f6479d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f6480f = parcel.readFloat();
        this.f6481g = parcel.readString();
        this.f6482h = parcel.readFloat();
        this.f6483i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f6484j = parcel.readString();
        this.f6485k = parcel.readString();
        this.f6486l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f6487m = parcel.createTypedArrayList(TMC.CREATOR);
    }
}
