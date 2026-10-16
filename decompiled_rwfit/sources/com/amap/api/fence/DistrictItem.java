package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* loaded from: classes.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5575a;

    /* renamed from: b, reason: collision with root package name */
    private String f5576b;

    /* renamed from: c, reason: collision with root package name */
    private String f5577c;

    /* renamed from: d, reason: collision with root package name */
    private List<DPoint> f5578d;

    public static class a implements Parcelable.Creator<DistrictItem> {
        @Override // android.os.Parcelable.Creator
        public DistrictItem createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistrictItem[] newArray(int i3) {
            return new DistrictItem[i3];
        }
    }

    public DistrictItem() {
        this.f5575a = "";
        this.f5576b = null;
        this.f5577c = null;
        this.f5578d = null;
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f5577c;
    }

    public String getCitycode() {
        return this.f5576b;
    }

    public String getDistrictName() {
        return this.f5575a;
    }

    public List<DPoint> getPolyline() {
        return this.f5578d;
    }

    public void setAdcode(String str) {
        this.f5577c = str;
    }

    public void setCitycode(String str) {
        this.f5576b = str;
    }

    public void setDistrictName(String str) {
        this.f5575a = str;
    }

    public void setPolyline(List<DPoint> list) {
        this.f5578d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5575a);
        parcel.writeString(this.f5576b);
        parcel.writeString(this.f5577c);
        parcel.writeTypedList(this.f5578d);
    }

    public DistrictItem(Parcel parcel) {
        this.f5575a = "";
        this.f5576b = null;
        this.f5577c = null;
        this.f5578d = null;
        this.f5575a = parcel.readString();
        this.f5576b = parcel.readString();
        this.f5577c = parcel.readString();
        this.f5578d = parcel.createTypedArrayList(DPoint.CREATOR);
    }
}
