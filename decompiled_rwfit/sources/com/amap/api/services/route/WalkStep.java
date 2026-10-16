package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6493a;

    /* renamed from: b, reason: collision with root package name */
    private String f6494b;

    /* renamed from: c, reason: collision with root package name */
    private String f6495c;

    /* renamed from: d, reason: collision with root package name */
    private float f6496d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f6497f;

    /* renamed from: g, reason: collision with root package name */
    private String f6498g;

    /* renamed from: h, reason: collision with root package name */
    private String f6499h;

    /* renamed from: i, reason: collision with root package name */
    private int f6500i;

    public static class a implements Parcelable.Creator<WalkStep> {
        @Override // android.os.Parcelable.Creator
        public WalkStep createFromParcel(Parcel parcel) {
            return new WalkStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WalkStep[] newArray(int i3) {
            return null;
        }
    }

    public WalkStep(Parcel parcel) {
        this.f6497f = new ArrayList();
        this.f6493a = parcel.readString();
        this.f6494b = parcel.readString();
        this.f6495c = parcel.readString();
        this.f6496d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f6497f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f6498g = parcel.readString();
        this.f6499h = parcel.readString();
        this.f6500i = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f6498g;
    }

    public String getAssistantAction() {
        return this.f6499h;
    }

    public float getDistance() {
        return this.f6496d;
    }

    public float getDuration() {
        return this.e;
    }

    public String getInstruction() {
        return this.f6493a;
    }

    public String getOrientation() {
        return this.f6494b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f6497f;
    }

    public String getRoad() {
        return this.f6495c;
    }

    public int getRoadType() {
        return this.f6500i;
    }

    public void setAction(String str) {
        this.f6498g = str;
    }

    public void setAssistantAction(String str) {
        this.f6499h = str;
    }

    public void setDistance(float f2) {
        this.f6496d = f2;
    }

    public void setDuration(float f2) {
        this.e = f2;
    }

    public void setInstruction(String str) {
        this.f6493a = str;
    }

    public void setOrientation(String str) {
        this.f6494b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f6497f = list;
    }

    public void setRoad(String str) {
        this.f6495c = str;
    }

    public void setRoadType(int i3) {
        this.f6500i = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6493a);
        parcel.writeString(this.f6494b);
        parcel.writeString(this.f6495c);
        parcel.writeFloat(this.f6496d);
        parcel.writeFloat(this.e);
        parcel.writeTypedList(this.f6497f);
        parcel.writeString(this.f6498g);
        parcel.writeString(this.f6499h);
        parcel.writeInt(this.f6500i);
    }

    public WalkStep() {
        this.f6497f = new ArrayList();
    }
}
