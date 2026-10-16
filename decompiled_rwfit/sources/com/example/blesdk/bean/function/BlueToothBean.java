package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BlueToothBean implements Parcelable {
    public static final Parcelable.Creator<BlueToothBean> CREATOR = new Parcelable.Creator<BlueToothBean>() { // from class: com.example.blesdk.bean.function.BlueToothBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BlueToothBean createFromParcel(Parcel parcel) {
            return new BlueToothBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BlueToothBean[] newArray(int i3) {
            return new BlueToothBean[i3];
        }
    };
    private boolean isBle;
    private boolean isNeedBound;
    private String mac;
    private String name;

    public BlueToothBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMac() {
        return this.mac;
    }

    public String getName() {
        return this.name;
    }

    public boolean isBle() {
        return this.isBle;
    }

    public boolean isNeedBound() {
        return this.isNeedBound;
    }

    public void setBle(boolean z5) {
        this.isBle = z5;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedBound(boolean z5) {
        this.isNeedBound = z5;
    }

    public String toString() {
        return "BlueToothBean{isBle=" + this.isBle + ", mac='" + this.mac + "', name='" + this.name + "', isNeedBound='" + this.isNeedBound + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.isBle ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mac);
        parcel.writeString(this.name);
        parcel.writeByte(this.isNeedBound ? (byte) 1 : (byte) 0);
    }

    public BlueToothBean(Parcel parcel) {
        this.isBle = parcel.readByte() != 0;
        this.mac = parcel.readString();
        this.name = parcel.readString();
        this.isNeedBound = parcel.readByte() != 0;
    }
}
