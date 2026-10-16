package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class CloudItemDetail extends CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItemDetail> CREATOR = new a();

    public static class a implements Parcelable.Creator<CloudItemDetail> {
        @Override // android.os.Parcelable.Creator
        public CloudItemDetail createFromParcel(Parcel parcel) {
            return new CloudItemDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CloudItemDetail[] newArray(int i3) {
            return new CloudItemDetail[i3];
        }
    }

    public CloudItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
    }

    public CloudItemDetail(Parcel parcel) {
        super(parcel);
    }
}
