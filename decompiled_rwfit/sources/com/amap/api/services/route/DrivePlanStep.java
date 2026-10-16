package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6250a;

    /* renamed from: b, reason: collision with root package name */
    private String f6251b;

    /* renamed from: c, reason: collision with root package name */
    private float f6252c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6253d;
    private List<LatLonPoint> e;

    public static class a implements Parcelable.Creator<DrivePlanStep> {
        @Override // android.os.Parcelable.Creator
        public DrivePlanStep createFromParcel(Parcel parcel) {
            return new DrivePlanStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DrivePlanStep[] newArray(int i3) {
            return null;
        }
    }

    public DrivePlanStep(Parcel parcel) {
        this.e = new ArrayList();
        this.f6250a = parcel.readString();
        this.f6251b = parcel.readString();
        this.f6252c = parcel.readFloat();
        this.f6253d = parcel.readInt() == 1;
        this.f6252c = parcel.readFloat();
        this.e = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f6251b;
    }

    public float getDistance() {
        return this.f6252c;
    }

    public List<LatLonPoint> getPolyline() {
        return this.e;
    }

    public String getRoad() {
        return this.f6250a;
    }

    public boolean getToll() {
        return this.f6253d;
    }

    public void setAdCode(String str) {
        this.f6251b = str;
    }

    public void setDistance(float f2) {
        this.f6252c = f2;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.e = list;
    }

    public void setRoad(String str) {
        this.f6250a = str;
    }

    public void setToll(boolean z5) {
        this.f6253d = z5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6250a);
        parcel.writeString(this.f6251b);
        parcel.writeFloat(this.f6252c);
        parcel.writeInt(this.f6253d ? 1 : 0);
        parcel.writeFloat(this.f6252c);
        parcel.writeTypedList(this.e);
    }

    public DrivePlanStep() {
        this.e = new ArrayList();
    }
}
