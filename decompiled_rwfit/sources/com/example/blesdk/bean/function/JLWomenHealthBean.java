package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class JLWomenHealthBean implements Parcelable {
    public static final Parcelable.Creator<JLWomenHealthBean> CREATOR = new Parcelable.Creator<JLWomenHealthBean>() { // from class: com.example.blesdk.bean.function.JLWomenHealthBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JLWomenHealthBean createFromParcel(Parcel parcel) {
            return new JLWomenHealthBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JLWomenHealthBean[] newArray(int i3) {
            return new JLWomenHealthBean[i3];
        }
    };
    private boolean isOpen;
    private long lastDays;
    private int lastPeriodD;
    private int lastPeriodM;
    private int lastPeriodY;
    private int ovulateDays;
    private int periodDays;
    private int periodDuration;
    private int rangeDuration;
    private int remindHour;
    private int remindMin;

    public JLWomenHealthBean() {
        this.isOpen = false;
        this.remindHour = 9;
        this.remindMin = 0;
        this.periodDays = 0;
        this.ovulateDays = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getLastDays() {
        return this.lastDays;
    }

    public int getLastPeriodD() {
        return this.lastPeriodD;
    }

    public int getLastPeriodM() {
        return this.lastPeriodM;
    }

    public int getLastPeriodY() {
        return this.lastPeriodY;
    }

    public int getOvulateDays() {
        return this.ovulateDays;
    }

    public int getPeriodDays() {
        return this.periodDays;
    }

    public int getPeriodDuration() {
        return this.periodDuration;
    }

    public int getRangeDuration() {
        return this.rangeDuration;
    }

    public int getRemindHour() {
        return this.remindHour;
    }

    public int getRemindMin() {
        return this.remindMin;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setLastDays(long j4) {
        this.lastDays = j4;
    }

    public void setLastPeriodD(int i3) {
        this.lastPeriodD = i3;
    }

    public void setLastPeriodM(int i3) {
        this.lastPeriodM = i3;
    }

    public void setLastPeriodY(int i3) {
        this.lastPeriodY = i3;
    }

    public void setOpen(boolean z5) {
        this.isOpen = z5;
    }

    public void setOvulateDays(int i3) {
        this.ovulateDays = i3;
    }

    public void setPeriodDays(int i3) {
        this.periodDays = i3;
    }

    public void setPeriodDuration(int i3) {
        this.periodDuration = i3;
    }

    public void setRangeDuration(int i3) {
        this.rangeDuration = i3;
    }

    public void setRemindHour(int i3) {
        this.remindHour = i3;
    }

    public void setRemindMin(int i3) {
        this.remindMin = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.isOpen ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.remindHour);
        parcel.writeInt(this.remindMin);
        parcel.writeInt(this.periodDays);
        parcel.writeInt(this.ovulateDays);
        parcel.writeInt(this.lastPeriodY);
        parcel.writeInt(this.lastPeriodM);
        parcel.writeInt(this.lastPeriodD);
        parcel.writeInt(this.periodDuration);
        parcel.writeInt(this.rangeDuration);
        parcel.writeLong(this.lastDays);
    }

    public JLWomenHealthBean(Parcel parcel) {
        this.isOpen = false;
        this.remindHour = 9;
        this.remindMin = 0;
        this.periodDays = 0;
        this.ovulateDays = 0;
        this.isOpen = parcel.readByte() != 0;
        this.remindHour = parcel.readInt();
        this.remindMin = parcel.readInt();
        this.periodDays = parcel.readInt();
        this.ovulateDays = parcel.readInt();
        this.lastPeriodY = parcel.readInt();
        this.lastPeriodM = parcel.readInt();
        this.lastPeriodD = parcel.readInt();
        this.periodDuration = parcel.readInt();
        this.rangeDuration = parcel.readInt();
        this.lastDays = parcel.readLong();
    }
}
