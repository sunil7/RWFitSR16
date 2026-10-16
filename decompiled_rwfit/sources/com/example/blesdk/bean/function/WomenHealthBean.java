package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class WomenHealthBean implements Parcelable {
    public static final Parcelable.Creator<WomenHealthBean> CREATOR = new Parcelable.Creator<WomenHealthBean>() { // from class: com.example.blesdk.bean.function.WomenHealthBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WomenHealthBean createFromParcel(Parcel parcel) {
            return new WomenHealthBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WomenHealthBean[] newArray(int i3) {
            return new WomenHealthBean[i3];
        }
    };
    private boolean isOpen;
    private long lastDays;
    private int mensDays;
    private boolean mensOpen;
    private boolean ovulHighOpen;
    private boolean ovulOpen;
    private boolean ovulOverOpen;
    private int rangeDays;
    private int remindHour;
    private int remindMin;
    private int type;

    public WomenHealthBean() {
        this.type = 0;
        this.isOpen = false;
        this.rangeDays = 25;
        this.mensDays = 5;
        this.mensOpen = true;
        this.ovulOpen = true;
        this.ovulHighOpen = true;
        this.ovulOverOpen = true;
        this.remindHour = 9;
        this.remindMin = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getLastDays() {
        return this.lastDays;
    }

    public int getMensDays() {
        return this.mensDays;
    }

    public int getRangeDays() {
        return this.rangeDays;
    }

    public int getRemindHour() {
        return this.remindHour;
    }

    public int getRemindMin() {
        return this.remindMin;
    }

    public int getType() {
        return this.type;
    }

    public boolean isMensOpen() {
        return this.mensOpen;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public boolean isOvulHighOpen() {
        return this.ovulHighOpen;
    }

    public boolean isOvulOpen() {
        return this.ovulOpen;
    }

    public boolean isOvulOverOpen() {
        return this.ovulOverOpen;
    }

    public void setLastDays(long j4) {
        this.lastDays = j4;
    }

    public void setMensDays(int i3) {
        if (i3 < 3 || i3 > 15) {
            return;
        }
        this.mensDays = i3;
    }

    public void setMensOpen(boolean z5) {
        this.mensOpen = z5;
    }

    public void setOpen(boolean z5) {
        this.isOpen = z5;
    }

    public void setOvulHighOpen(boolean z5) {
        this.ovulHighOpen = z5;
    }

    public void setOvulOpen(boolean z5) {
        this.ovulOpen = z5;
    }

    public void setOvulOverOpen(boolean z5) {
        this.ovulOverOpen = z5;
    }

    public void setRangeDays(int i3) {
        if (i3 > 60 || i3 < 15) {
            return;
        }
        this.rangeDays = i3;
    }

    public void setRemindHour(int i3) {
        if (i3 > 23) {
            return;
        }
        this.remindHour = i3;
    }

    public void setRemindMin(int i3) {
        if (i3 > 59) {
            return;
        }
        this.remindMin = i3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("WomenHealthBean{type=");
        sb2.append(this.type);
        sb2.append(", isOpen=");
        sb2.append(this.isOpen);
        sb2.append(", rangeDays=");
        sb2.append(this.rangeDays);
        sb2.append(", mensDays=");
        sb2.append(this.mensDays);
        sb2.append(", lastDays=");
        sb2.append(this.lastDays);
        sb2.append(", mensOpen=");
        sb2.append(this.mensOpen);
        sb2.append(", ovulOpen=");
        sb2.append(this.ovulOpen);
        sb2.append(", ovulHighOpen=");
        sb2.append(this.ovulHighOpen);
        sb2.append(", ovulOverOpen=");
        sb2.append(this.ovulOverOpen);
        sb2.append(", remindHour=");
        sb2.append(this.remindHour);
        sb2.append(", remindMin=");
        return e.m(sb2, this.remindMin, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.type);
        parcel.writeByte(this.isOpen ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.rangeDays);
        parcel.writeInt(this.mensDays);
        parcel.writeLong(this.lastDays);
        parcel.writeByte(this.mensOpen ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ovulOpen ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ovulHighOpen ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ovulOverOpen ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.remindHour);
        parcel.writeInt(this.remindMin);
    }

    public WomenHealthBean(Parcel parcel) {
        this.type = 0;
        this.isOpen = false;
        this.rangeDays = 25;
        this.mensDays = 5;
        this.mensOpen = true;
        this.ovulOpen = true;
        this.ovulHighOpen = true;
        this.ovulOverOpen = true;
        this.remindHour = 9;
        this.remindMin = 0;
        this.type = parcel.readInt();
        this.isOpen = parcel.readByte() != 0;
        this.rangeDays = parcel.readInt();
        this.mensDays = parcel.readInt();
        this.lastDays = parcel.readLong();
        this.mensOpen = parcel.readByte() != 0;
        this.ovulOpen = parcel.readByte() != 0;
        this.ovulHighOpen = parcel.readByte() != 0;
        this.ovulOverOpen = parcel.readByte() != 0;
        this.remindHour = parcel.readInt();
        this.remindMin = parcel.readInt();
    }
}
