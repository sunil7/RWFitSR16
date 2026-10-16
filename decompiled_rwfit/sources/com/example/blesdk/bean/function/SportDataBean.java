package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SportDataBean implements Parcelable {
    public static final Parcelable.Creator<SportDataBean> CREATOR = new Parcelable.Creator<SportDataBean>() { // from class: com.example.blesdk.bean.function.SportDataBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportDataBean createFromParcel(Parcel parcel) {
            return new SportDataBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportDataBean[] newArray(int i3) {
            return new SportDataBean[i3];
        }
    };
    private int altitude;
    private int calorie;
    private int currentPace;
    private int distance;
    private int pressure;
    private int step;
    private long totalTime;
    private int workMode;

    public SportDataBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAltitude() {
        return this.altitude;
    }

    public int getCalorie() {
        return this.calorie;
    }

    public int getCurrentPace() {
        return this.currentPace;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getPressure() {
        return this.pressure;
    }

    public int getStep() {
        return this.step;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public int getWorkMode() {
        return this.workMode;
    }

    public void setAltitude(int i3) {
        this.altitude = i3;
    }

    public void setCalorie(int i3) {
        this.calorie = i3;
    }

    public void setCurrentPace(int i3) {
        this.currentPace = i3;
    }

    public void setDistance(int i3) {
        this.distance = i3;
    }

    public void setPressure(int i3) {
        this.pressure = i3;
    }

    public void setStep(int i3) {
        this.step = i3;
    }

    public void setTotalTime(long j4) {
        this.totalTime = j4;
    }

    public void setWorkMode(int i3) {
        this.workMode = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportDataBean{totalTime=");
        sb2.append(this.totalTime);
        sb2.append(", step=");
        sb2.append(this.step);
        sb2.append(", distance=");
        sb2.append(this.distance);
        sb2.append(", calorie=");
        sb2.append(this.calorie);
        sb2.append(", altitude=");
        sb2.append(this.altitude);
        sb2.append(", pressure=");
        sb2.append(this.pressure);
        sb2.append(", workMode=");
        return e.m(sb2, this.workMode, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.totalTime);
        parcel.writeInt(this.step);
        parcel.writeInt(this.distance);
        parcel.writeInt(this.calorie);
        parcel.writeInt(this.altitude);
        parcel.writeInt(this.pressure);
        parcel.writeInt(this.workMode);
        parcel.writeInt(this.currentPace);
    }

    public SportDataBean(Parcel parcel) {
        this.totalTime = parcel.readLong();
        this.step = parcel.readInt();
        this.distance = parcel.readInt();
        this.calorie = parcel.readInt();
        this.altitude = parcel.readInt();
        this.pressure = parcel.readInt();
        this.workMode = parcel.readInt();
        this.currentPace = parcel.readInt();
    }
}
