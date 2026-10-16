package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class PowerBean implements Parcelable {
    public static final Parcelable.Creator<PowerBean> CREATOR = new Parcelable.Creator<PowerBean>() { // from class: com.example.blesdk.bean.function.PowerBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PowerBean createFromParcel(Parcel parcel) {
            return new PowerBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PowerBean[] newArray(int i3) {
            return new PowerBean[i3];
        }
    };
    private boolean isLowPower;
    private int power;
    private int powerStatus;
    private int voltage;

    public PowerBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPower() {
        return this.power;
    }

    public int getPowerStatus() {
        return this.powerStatus;
    }

    public int getVoltage() {
        return this.voltage;
    }

    public boolean isLowPower() {
        return this.isLowPower;
    }

    public void setLowPower(boolean z5) {
        this.isLowPower = z5;
    }

    public void setPower(int i3) {
        this.power = i3;
    }

    public void setPowerStatus(int i3) {
        this.powerStatus = i3;
    }

    public void setVoltage(int i3) {
        this.voltage = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PowerBean{isLowPower=");
        sb2.append(this.isLowPower);
        sb2.append(", powerStatus=");
        sb2.append(this.powerStatus);
        sb2.append(", power=");
        return e.m(sb2, this.power, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.isLowPower ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.powerStatus);
        parcel.writeInt(this.power);
    }

    public PowerBean(Parcel parcel) {
        this.isLowPower = parcel.readByte() != 0;
        this.powerStatus = parcel.readInt();
        this.power = parcel.readInt();
    }
}
