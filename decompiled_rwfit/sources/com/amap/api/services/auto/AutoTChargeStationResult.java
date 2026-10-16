package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AutoTChargeStationResult implements Parcelable {
    public static final Parcelable.Creator<AutoTChargeStationResult> CREATOR = new a();
    public Classify classify;
    public int code;
    public ListData listData;
    public Lqii lqii;
    public String message;
    public Meta meta;
    public String originJson;

    public static class a implements Parcelable.Creator<AutoTChargeStationResult> {
        @Override // android.os.Parcelable.Creator
        public AutoTChargeStationResult createFromParcel(Parcel parcel) {
            return new AutoTChargeStationResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AutoTChargeStationResult[] newArray(int i3) {
            return new AutoTChargeStationResult[i3];
        }
    }

    public AutoTChargeStationResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.classify, i3);
        parcel.writeParcelable(this.listData, i3);
        parcel.writeParcelable(this.lqii, i3);
        parcel.writeParcelable(this.meta, i3);
        parcel.writeString(this.originJson);
    }

    public AutoTChargeStationResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.classify = (Classify) parcel.readParcelable(Classify.class.getClassLoader());
        this.listData = (ListData) parcel.readParcelable(ListData.class.getClassLoader());
        this.lqii = (Lqii) parcel.readParcelable(Lqii.class.getClassLoader());
        this.meta = (Meta) parcel.readParcelable(Meta.class.getClassLoader());
        this.originJson = parcel.readString();
    }
}
