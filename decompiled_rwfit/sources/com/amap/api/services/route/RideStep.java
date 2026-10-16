package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6306a;

    /* renamed from: b, reason: collision with root package name */
    private String f6307b;

    /* renamed from: c, reason: collision with root package name */
    private String f6308c;

    /* renamed from: d, reason: collision with root package name */
    private float f6309d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f6310f;

    /* renamed from: g, reason: collision with root package name */
    private String f6311g;

    /* renamed from: h, reason: collision with root package name */
    private String f6312h;

    /* renamed from: i, reason: collision with root package name */
    private int f6313i;

    public static class a implements Parcelable.Creator<RideStep> {
        @Override // android.os.Parcelable.Creator
        public RideStep createFromParcel(Parcel parcel) {
            return new RideStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RideStep[] newArray(int i3) {
            return new RideStep[i3];
        }
    }

    public RideStep() {
        this.f6310f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f6311g;
    }

    public String getAssistantAction() {
        return this.f6312h;
    }

    public float getDistance() {
        return this.f6309d;
    }

    public float getDuration() {
        return this.e;
    }

    public String getInstruction() {
        return this.f6306a;
    }

    public String getOrientation() {
        return this.f6307b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f6310f;
    }

    public String getRoad() {
        return this.f6308c;
    }

    public int getRoadType() {
        return this.f6313i;
    }

    public void setAction(String str) {
        this.f6311g = str;
    }

    public void setAssistantAction(String str) {
        this.f6312h = str;
    }

    public void setDistance(float f2) {
        this.f6309d = f2;
    }

    public void setDuration(float f2) {
        this.e = f2;
    }

    public void setInstruction(String str) {
        this.f6306a = str;
    }

    public void setOrientation(String str) {
        this.f6307b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f6310f = list;
    }

    public void setRoad(String str) {
        this.f6308c = str;
    }

    public void setRoadType(int i3) {
        this.f6313i = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6306a);
        parcel.writeString(this.f6307b);
        parcel.writeString(this.f6308c);
        parcel.writeFloat(this.f6309d);
        parcel.writeFloat(this.e);
        parcel.writeTypedList(this.f6310f);
        parcel.writeString(this.f6311g);
        parcel.writeString(this.f6312h);
    }

    public RideStep(Parcel parcel) {
        this.f6310f = new ArrayList();
        this.f6306a = parcel.readString();
        this.f6307b = parcel.readString();
        this.f6308c = parcel.readString();
        this.f6309d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f6310f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f6311g = parcel.readString();
        this.f6312h = parcel.readString();
    }
}
