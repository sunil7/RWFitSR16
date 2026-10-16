package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class SleepSummaryBean implements Parcelable {
    public static final Parcelable.Creator<SleepSummaryBean> CREATOR = new Parcelable.Creator<SleepSummaryBean>() { // from class: com.example.blesdk.bean.function.SleepSummaryBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepSummaryBean createFromParcel(Parcel parcel) {
            return new SleepSummaryBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepSummaryBean[] newArray(int i3) {
            return new SleepSummaryBean[i3];
        }
    };
    private int deepSleepDuration;
    private int shallowSleepDuration;
    private int totalDuration;

    public SleepSummaryBean(Parcel parcel) {
        this.totalDuration = parcel.readInt();
        this.deepSleepDuration = parcel.readInt();
        this.shallowSleepDuration = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDeepSleepDuration() {
        return this.deepSleepDuration;
    }

    public int getShallowSleepDuration() {
        return this.shallowSleepDuration;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public void setDeepSleepDuration(int i3) {
        this.deepSleepDuration = i3;
    }

    public void setShallowSleepDuration(int i3) {
        this.shallowSleepDuration = i3;
    }

    public void setTotalDuration(int i3) {
        this.totalDuration = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.totalDuration);
        parcel.writeInt(this.deepSleepDuration);
        parcel.writeInt(this.shallowSleepDuration);
    }
}
