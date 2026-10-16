package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Crossroad extends Road implements Parcelable {
    public static final Parcelable.Creator<Crossroad> CREATOR = new a();

    /* renamed from: g, reason: collision with root package name */
    private float f6172g;

    /* renamed from: h, reason: collision with root package name */
    private String f6173h;

    /* renamed from: i, reason: collision with root package name */
    private String f6174i;

    /* renamed from: j, reason: collision with root package name */
    private String f6175j;

    /* renamed from: k, reason: collision with root package name */
    private String f6176k;

    /* renamed from: l, reason: collision with root package name */
    private String f6177l;

    public static class a implements Parcelable.Creator<Crossroad> {
        @Override // android.os.Parcelable.Creator
        public Crossroad createFromParcel(Parcel parcel) {
            return new Crossroad(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Crossroad[] newArray(int i3) {
            return null;
        }
    }

    public /* synthetic */ Crossroad(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f6173h;
    }

    public float getDistance() {
        return this.f6172g;
    }

    public String getFirstRoadId() {
        return this.f6174i;
    }

    public String getFirstRoadName() {
        return this.f6175j;
    }

    public String getSecondRoadId() {
        return this.f6176k;
    }

    public String getSecondRoadName() {
        return this.f6177l;
    }

    public void setDirection(String str) {
        this.f6173h = str;
    }

    public void setDistance(float f2) {
        this.f6172g = f2;
    }

    public void setFirstRoadId(String str) {
        this.f6174i = str;
    }

    public void setFirstRoadName(String str) {
        this.f6175j = str;
    }

    public void setSecondRoadId(String str) {
        this.f6176k = str;
    }

    public void setSecondRoadName(String str) {
        this.f6177l = str;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f6172g);
        parcel.writeString(this.f6173h);
        parcel.writeString(this.f6174i);
        parcel.writeString(this.f6175j);
        parcel.writeString(this.f6176k);
        parcel.writeString(this.f6177l);
    }

    public Crossroad() {
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.f6172g = parcel.readFloat();
        this.f6173h = parcel.readString();
        this.f6174i = parcel.readString();
        this.f6175j = parcel.readString();
        this.f6176k = parcel.readString();
        this.f6177l = parcel.readString();
    }
}
