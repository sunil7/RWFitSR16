package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Meta implements Parcelable {
    public static final Parcelable.Creator<Meta> CREATOR = new a();
    public String listBizType;

    public static class a implements Parcelable.Creator<Meta> {
        @Override // android.os.Parcelable.Creator
        public Meta createFromParcel(Parcel parcel) {
            return new Meta(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Meta[] newArray(int i3) {
            return new Meta[i3];
        }
    }

    public Meta() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.listBizType);
    }

    public Meta(Parcel parcel) {
        this.listBizType = parcel.readString();
    }
}
