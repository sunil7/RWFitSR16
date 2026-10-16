package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class HeartRateTransferBean implements Parcelable {
    public static final Parcelable.Creator<HeartRateTransferBean> CREATOR = new Parcelable.Creator<HeartRateTransferBean>() { // from class: com.example.blesdk.bean.function.HeartRateTransferBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateTransferBean createFromParcel(Parcel parcel) {
            return new HeartRateTransferBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateTransferBean[] newArray(int i3) {
            return new HeartRateTransferBean[i3];
        }
    };
    private int hr;
    private long time;

    public HeartRateTransferBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHr() {
        return this.hr;
    }

    public long getTime() {
        return this.time;
    }

    public void setHr(int i3) {
        this.hr = i3;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.time);
        parcel.writeInt(this.hr);
    }

    public HeartRateTransferBean(Parcel parcel) {
        this.time = parcel.readLong();
        this.hr = parcel.readInt();
    }
}
