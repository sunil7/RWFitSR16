package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6260a;

    /* renamed from: b, reason: collision with root package name */
    private String f6261b;

    /* renamed from: c, reason: collision with root package name */
    private String f6262c;

    /* renamed from: d, reason: collision with root package name */
    private float f6263d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private float f6264f;

    /* renamed from: g, reason: collision with root package name */
    private String f6265g;

    /* renamed from: h, reason: collision with root package name */
    private float f6266h;

    /* renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f6267i;

    /* renamed from: j, reason: collision with root package name */
    private String f6268j;

    /* renamed from: k, reason: collision with root package name */
    private String f6269k;

    /* renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f6270l;

    /* renamed from: m, reason: collision with root package name */
    private List<TMC> f6271m;

    public static class a implements Parcelable.Creator<DriveStep> {
        @Override // android.os.Parcelable.Creator
        public DriveStep createFromParcel(Parcel parcel) {
            return new DriveStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DriveStep[] newArray(int i3) {
            return null;
        }
    }

    public DriveStep(Parcel parcel) {
        this.f6267i = new ArrayList();
        this.f6270l = new ArrayList();
        this.f6271m = new ArrayList();
        this.f6260a = parcel.readString();
        this.f6261b = parcel.readString();
        this.f6262c = parcel.readString();
        this.f6263d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f6264f = parcel.readFloat();
        this.f6265g = parcel.readString();
        this.f6266h = parcel.readFloat();
        this.f6267i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f6268j = parcel.readString();
        this.f6269k = parcel.readString();
        this.f6270l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f6271m = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f6268j;
    }

    public String getAssistantAction() {
        return this.f6269k;
    }

    public float getDistance() {
        return this.f6263d;
    }

    public float getDuration() {
        return this.f6266h;
    }

    public String getInstruction() {
        return this.f6260a;
    }

    public String getOrientation() {
        return this.f6261b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f6267i;
    }

    public String getRoad() {
        return this.f6262c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f6270l;
    }

    public List<TMC> getTMCs() {
        return this.f6271m;
    }

    public float getTollDistance() {
        return this.f6264f;
    }

    public String getTollRoad() {
        return this.f6265g;
    }

    public float getTolls() {
        return this.e;
    }

    public void setAction(String str) {
        this.f6268j = str;
    }

    public void setAssistantAction(String str) {
        this.f6269k = str;
    }

    public void setDistance(float f2) {
        this.f6263d = f2;
    }

    public void setDuration(float f2) {
        this.f6266h = f2;
    }

    public void setInstruction(String str) {
        this.f6260a = str;
    }

    public void setOrientation(String str) {
        this.f6261b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f6267i = list;
    }

    public void setRoad(String str) {
        this.f6262c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f6270l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f6271m = list;
    }

    public void setTollDistance(float f2) {
        this.f6264f = f2;
    }

    public void setTollRoad(String str) {
        this.f6265g = str;
    }

    public void setTolls(float f2) {
        this.e = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6260a);
        parcel.writeString(this.f6261b);
        parcel.writeString(this.f6262c);
        parcel.writeFloat(this.f6263d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f6264f);
        parcel.writeString(this.f6265g);
        parcel.writeFloat(this.f6266h);
        parcel.writeTypedList(this.f6267i);
        parcel.writeString(this.f6268j);
        parcel.writeString(this.f6269k);
        parcel.writeTypedList(this.f6270l);
        parcel.writeTypedList(this.f6271m);
    }

    public DriveStep() {
        this.f6267i = new ArrayList();
        this.f6270l = new ArrayList();
        this.f6271m = new ArrayList();
    }
}
