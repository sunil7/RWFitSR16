package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    int f6461a;

    /* renamed from: b, reason: collision with root package name */
    float f6462b;

    /* renamed from: c, reason: collision with root package name */
    float f6463c;

    /* renamed from: d, reason: collision with root package name */
    int f6464d;
    private List<TMC> e;

    public static class a implements Parcelable.Creator<TimeInfosElement> {
        @Override // android.os.Parcelable.Creator
        public TimeInfosElement createFromParcel(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i3) {
            return null;
        }
    }

    public TimeInfosElement(Parcel parcel) {
        this.e = new ArrayList();
        this.f6461a = parcel.readInt();
        this.f6462b = parcel.readFloat();
        this.f6463c = parcel.readFloat();
        this.f6464d = parcel.readInt();
        this.e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.f6462b;
    }

    public int getPathindex() {
        return this.f6461a;
    }

    public int getRestriction() {
        return this.f6464d;
    }

    public List<TMC> getTMCs() {
        return this.e;
    }

    public float getTolls() {
        return this.f6463c;
    }

    public void setDuration(float f2) {
        this.f6462b = f2;
    }

    public void setPathindex(int i3) {
        this.f6461a = i3;
    }

    public void setRestriction(int i3) {
        this.f6464d = i3;
    }

    public void setTMCs(List<TMC> list) {
        this.e = list;
    }

    public void setTolls(float f2) {
        this.f6463c = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f6461a);
        parcel.writeFloat(this.f6462b);
        parcel.writeFloat(this.f6463c);
        parcel.writeInt(this.f6464d);
        parcel.writeTypedList(this.e);
    }

    public TimeInfosElement() {
        this.e = new ArrayList();
    }
}
