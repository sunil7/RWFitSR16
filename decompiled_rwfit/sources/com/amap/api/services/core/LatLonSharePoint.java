package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private String f5933c;

    public static class a implements Parcelable.Creator<LatLonSharePoint> {
        @Override // android.os.Parcelable.Creator
        public LatLonSharePoint createFromParcel(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LatLonSharePoint[] newArray(int i3) {
            return new LatLonSharePoint[i3];
        }
    }

    public LatLonSharePoint(double d5, double d8, String str) {
        super(d5, d8);
        this.f5933c = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.f5933c;
        if (str == null) {
            if (latLonSharePoint.f5933c != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.f5933c)) {
            return false;
        }
        return true;
    }

    public String getSharePointName() {
        return this.f5933c;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f5933c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public void setSharePointName(String str) {
        this.f5933c = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + Const.STR_MART_COMMA + this.f5933c;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f5933c);
    }

    public LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f5933c = parcel.readString();
    }
}
