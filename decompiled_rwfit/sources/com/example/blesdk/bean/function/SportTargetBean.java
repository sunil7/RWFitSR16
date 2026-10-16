package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SportTargetBean implements Parcelable {
    public static final Parcelable.Creator<SportTargetBean> CREATOR = new Parcelable.Creator<SportTargetBean>() { // from class: com.example.blesdk.bean.function.SportTargetBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportTargetBean createFromParcel(Parcel parcel) {
            return new SportTargetBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportTargetBean[] newArray(int i3) {
            return new SportTargetBean[i3];
        }
    };
    private int calorie;
    private int distance;
    private int isAutoPause;
    private int isScreenLight;
    private int isVibrator;
    private int time;

    public SportTargetBean() {
        this.time = 10;
        this.calorie = 100;
        this.distance = 1;
        this.isVibrator = 1;
        this.isScreenLight = 1;
        this.isAutoPause = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCalorie() {
        return this.calorie;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getTime() {
        return this.time;
    }

    public int isAutoPause() {
        return this.isAutoPause;
    }

    public int isScreenLight() {
        return this.isScreenLight;
    }

    public int isVibrator() {
        return this.isVibrator;
    }

    public void setAutoPause(int i3) {
        this.isAutoPause = i3;
    }

    public void setCalorie(int i3) {
        this.calorie = i3;
    }

    public void setDistance(int i3) {
        this.distance = i3;
    }

    public void setScreenLight(int i3) {
        this.isScreenLight = i3;
    }

    public void setTime(int i3) {
        this.time = i3;
    }

    public void setVibrator(int i3) {
        this.isVibrator = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportTargetBean{time=");
        sb2.append(this.time);
        sb2.append(", calorie=");
        sb2.append(this.calorie);
        sb2.append(", distance=");
        sb2.append(this.distance);
        sb2.append(", isVibrator=");
        sb2.append(this.isVibrator);
        sb2.append(", isScreenLight=");
        sb2.append(this.isScreenLight);
        sb2.append(", isAutoPause=");
        return e.m(sb2, this.isAutoPause, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.time);
        parcel.writeInt(this.calorie);
        parcel.writeInt(this.distance);
        parcel.writeInt(this.isVibrator);
        parcel.writeInt(this.isScreenLight);
        parcel.writeInt(this.isAutoPause);
    }

    public SportTargetBean(Parcel parcel) {
        this.time = 10;
        this.calorie = 100;
        this.distance = 1;
        this.isVibrator = 1;
        this.isScreenLight = 1;
        this.isAutoPause = 1;
        this.time = parcel.readInt();
        this.calorie = parcel.readInt();
        this.distance = parcel.readInt();
        this.isVibrator = parcel.readInt();
        this.isScreenLight = parcel.readInt();
        this.isAutoPause = parcel.readInt();
    }
}
