package com.example.database.table;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import xb.b;

/* loaded from: classes.dex */
public class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() { // from class: com.example.database.table.User.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public User[] newArray(int i3) {
            return new User[i3];
        }
    };

    @b("account")
    private String account;
    private String avatar;
    private String birthday;
    private int caloriesTarget;
    private int customerMaxHeartRate;
    private int distanceTarget;
    private int durationTarget;
    private double height;
    private boolean isSyncWeightInfo;
    private boolean isUpdateHealthInfo;
    private boolean isUpdateSportInfo;
    private boolean isUpdateUserInfo;
    private int meterUnit;
    private String name;
    private int platform;
    private int sex;
    private int stepsTarget;
    private int tempUnit;
    private String userId;
    private double weight;
    private double weightTarget;

    public User(String str, String str2, String str3, String str4, int i3, String str5, double d5, double d8, int i10, int i11, double d10, int i12, int i13, boolean z5, boolean z6, boolean z8, boolean z10, int i14, int i15, int i16, int i17) {
        this.userId = str;
        this.account = str2;
        this.name = str3;
        this.avatar = str4;
        this.sex = i3;
        this.birthday = str5;
        this.height = d5;
        this.weight = d8;
        this.durationTarget = i10;
        this.distanceTarget = i11;
        this.weightTarget = d10;
        this.caloriesTarget = i12;
        this.stepsTarget = i13;
        this.isUpdateUserInfo = z5;
        this.isUpdateSportInfo = z6;
        this.isUpdateHealthInfo = z8;
        this.isSyncWeightInfo = z10;
        this.customerMaxHeartRate = i14;
        this.platform = i15;
        this.meterUnit = i16;
        this.tempUnit = i17;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccount() {
        return this.account;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public int getCaloriesTarget() {
        return this.caloriesTarget;
    }

    public int getCustomerMaxHeartRate() {
        return this.customerMaxHeartRate;
    }

    public int getDistanceTarget() {
        return this.distanceTarget;
    }

    public int getDurationTarget() {
        return this.durationTarget;
    }

    public double getHeight() {
        return this.height;
    }

    public boolean getIsSyncWeightInfo() {
        return this.isSyncWeightInfo;
    }

    public boolean getIsUpdateHealthInfo() {
        return this.isUpdateHealthInfo;
    }

    public boolean getIsUpdateSportInfo() {
        return this.isUpdateSportInfo;
    }

    public boolean getIsUpdateUserInfo() {
        return this.isUpdateUserInfo;
    }

    public int getMeterUnit() {
        return this.meterUnit;
    }

    public String getName() {
        return this.name;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getSex() {
        return this.sex;
    }

    public int getStepsTarget() {
        return this.stepsTarget;
    }

    public int getTempUnit() {
        return this.tempUnit;
    }

    public String getUserId() {
        return this.userId;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getWeightTarget() {
        return this.weightTarget;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setCaloriesTarget(int i3) {
        this.caloriesTarget = i3;
    }

    public void setCustomerMaxHeartRate(int i3) {
        this.customerMaxHeartRate = i3;
    }

    public void setDistanceTarget(int i3) {
        this.distanceTarget = i3;
    }

    public void setDurationTarget(int i3) {
        this.durationTarget = i3;
    }

    public void setHeight(double d5) {
        this.height = d5;
    }

    public void setIsSyncWeightInfo(boolean z5) {
        this.isSyncWeightInfo = z5;
    }

    public void setIsUpdateHealthInfo(boolean z5) {
        this.isUpdateHealthInfo = z5;
    }

    public void setIsUpdateSportInfo(boolean z5) {
        this.isUpdateSportInfo = z5;
    }

    public void setIsUpdateUserInfo(boolean z5) {
        this.isUpdateUserInfo = z5;
    }

    public void setMeterUnit(int i3) {
        this.meterUnit = i3;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPlatform(int i3) {
        this.platform = i3;
    }

    public void setSex(int i3) {
        this.sex = i3;
    }

    public void setStepsTarget(int i3) {
        this.stepsTarget = i3;
    }

    public void setTempUnit(int i3) {
        this.tempUnit = i3;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWeight(double d5) {
        this.weight = d5;
    }

    public void setWeightTarget(double d5) {
        this.weightTarget = d5;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("User{userId='");
        sb2.append(this.userId);
        sb2.append("', email='");
        sb2.append(this.account);
        sb2.append("', name='");
        sb2.append(this.name);
        sb2.append("', avatar='");
        sb2.append(this.avatar);
        sb2.append("', sex=");
        sb2.append(this.sex);
        sb2.append(", birthday='");
        sb2.append(this.birthday);
        sb2.append("', height=");
        sb2.append(this.height);
        sb2.append(", weight=");
        sb2.append(this.weight);
        sb2.append(", durationTarget=");
        sb2.append(this.durationTarget);
        sb2.append(", distanceTarget=");
        sb2.append(this.distanceTarget);
        sb2.append(", weightTarget=");
        sb2.append(this.weightTarget);
        sb2.append(", caloriesTarget=");
        sb2.append(this.caloriesTarget);
        sb2.append(", stepsTarget=");
        sb2.append(this.stepsTarget);
        sb2.append(", isUpdateUserInfo=");
        sb2.append(this.isUpdateUserInfo);
        sb2.append(", isUpdateSportInfo=");
        sb2.append(this.isUpdateSportInfo);
        sb2.append(", isUpdateHealthInfo=");
        sb2.append(this.isUpdateHealthInfo);
        sb2.append(", isSyncWeightInfo=");
        sb2.append(this.isSyncWeightInfo);
        sb2.append(", customerMaxHeartRate=");
        sb2.append(this.customerMaxHeartRate);
        sb2.append(", platform=");
        sb2.append(this.platform);
        sb2.append(", meterUnit=");
        sb2.append(this.meterUnit);
        sb2.append(", tempUnit=");
        return e.m(sb2, this.tempUnit, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.userId);
        parcel.writeString(this.account);
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.sex);
        parcel.writeString(this.birthday);
        parcel.writeDouble(this.height);
        parcel.writeDouble(this.weight);
        parcel.writeInt(this.durationTarget);
        parcel.writeInt(this.distanceTarget);
        parcel.writeDouble(this.weightTarget);
        parcel.writeInt(this.caloriesTarget);
        parcel.writeInt(this.stepsTarget);
        parcel.writeByte(this.isUpdateUserInfo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isUpdateSportInfo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isUpdateHealthInfo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSyncWeightInfo ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.customerMaxHeartRate);
        parcel.writeInt(this.platform);
        parcel.writeInt(this.meterUnit);
        parcel.writeInt(this.tempUnit);
    }

    public User() {
    }

    public User(Parcel parcel) {
        this.userId = parcel.readString();
        this.account = parcel.readString();
        this.name = parcel.readString();
        this.avatar = parcel.readString();
        this.sex = parcel.readInt();
        this.birthday = parcel.readString();
        this.height = parcel.readDouble();
        this.weight = parcel.readDouble();
        this.durationTarget = parcel.readInt();
        this.distanceTarget = parcel.readInt();
        this.weightTarget = parcel.readDouble();
        this.caloriesTarget = parcel.readInt();
        this.stepsTarget = parcel.readInt();
        this.isUpdateUserInfo = parcel.readByte() != 0;
        this.isUpdateSportInfo = parcel.readByte() != 0;
        this.isUpdateHealthInfo = parcel.readByte() != 0;
        this.isSyncWeightInfo = parcel.readByte() != 0;
        this.customerMaxHeartRate = parcel.readInt();
        this.platform = parcel.readInt();
        this.meterUnit = parcel.readInt();
        this.tempUnit = parcel.readInt();
    }
}
