package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AerobicExerciseBean implements Parcelable {
    public static final Parcelable.Creator<AerobicExerciseBean> CREATOR = new Parcelable.Creator<AerobicExerciseBean>() { // from class: com.example.blesdk.bean.function.AerobicExerciseBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AerobicExerciseBean createFromParcel(Parcel parcel) {
            return new AerobicExerciseBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AerobicExerciseBean[] newArray(int i3) {
            return new AerobicExerciseBean[i3];
        }
    };
    private int duration;
    private int exerciseHour;
    private int exerciseMinute;
    private int lowerHeartRate;
    private int lowerHeartRateDuration;
    private int lowerHeartRateVibrationCount;
    private int upperHeartRate;
    private int upperHeartRateDuration;
    private int upperHeartRateVibrationCount;

    public AerobicExerciseBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getExerciseHour() {
        return this.exerciseHour;
    }

    public int getExerciseMinute() {
        return this.exerciseMinute;
    }

    public int getLowerHeartRate() {
        return this.lowerHeartRate;
    }

    public int getLowerHeartRateDuration() {
        return this.lowerHeartRateDuration;
    }

    public int getLowerHeartRateVibrationCount() {
        return this.lowerHeartRateVibrationCount;
    }

    public int getUpperHeartRate() {
        return this.upperHeartRate;
    }

    public int getUpperHeartRateDuration() {
        return this.upperHeartRateDuration;
    }

    public int getUpperHeartRateVibrationCount() {
        return this.upperHeartRateVibrationCount;
    }

    public void setDuration(int i3) {
        this.duration = i3;
    }

    public void setExerciseHour(int i3) {
        this.exerciseHour = i3;
    }

    public void setExerciseMinute(int i3) {
        this.exerciseMinute = i3;
    }

    public void setLowerHeartRate(int i3) {
        this.lowerHeartRate = i3;
    }

    public void setLowerHeartRateDuration(int i3) {
        this.lowerHeartRateDuration = i3;
    }

    public void setLowerHeartRateVibrationCount(int i3) {
        this.lowerHeartRateVibrationCount = i3;
    }

    public void setUpperHeartRate(int i3) {
        this.upperHeartRate = i3;
    }

    public void setUpperHeartRateDuration(int i3) {
        this.upperHeartRateDuration = i3;
    }

    public void setUpperHeartRateVibrationCount(int i3) {
        this.upperHeartRateVibrationCount = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.exerciseHour);
        parcel.writeInt(this.exerciseMinute);
        parcel.writeInt(this.lowerHeartRate);
        parcel.writeInt(this.upperHeartRate);
        parcel.writeInt(this.lowerHeartRateDuration);
        parcel.writeInt(this.lowerHeartRateVibrationCount);
        parcel.writeInt(this.upperHeartRateDuration);
        parcel.writeInt(this.upperHeartRateVibrationCount);
        parcel.writeInt(this.duration);
    }

    public AerobicExerciseBean(Parcel parcel) {
        this.exerciseHour = parcel.readInt();
        this.exerciseMinute = parcel.readInt();
        this.lowerHeartRate = parcel.readInt();
        this.upperHeartRate = parcel.readInt();
        this.lowerHeartRateDuration = parcel.readInt();
        this.lowerHeartRateVibrationCount = parcel.readInt();
        this.upperHeartRateDuration = parcel.readInt();
        this.upperHeartRateVibrationCount = parcel.readInt();
        this.duration = parcel.readInt();
    }
}
