package com.example.network.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.example.network.bean.UserInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfoBean[] newArray(int i3) {
            return new UserInfoBean[i3];
        }
    };
    private String account;
    private String birthday;
    private double height;

    /* renamed from: id, reason: collision with root package name */
    private int f7398id;
    private String name;
    private String portraitUrl;
    private int sex;
    private int sportTarget;
    private double weight;

    public UserInfoBean(Parcel parcel) {
        this.f7398id = parcel.readInt();
        this.account = parcel.readString();
        this.name = parcel.readString();
        this.birthday = parcel.readString();
        this.sex = parcel.readInt();
        this.height = parcel.readDouble();
        this.weight = parcel.readDouble();
        this.portraitUrl = parcel.readString();
        this.sportTarget = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccount() {
        return this.account;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public double getHeight() {
        return this.height;
    }

    public int getId() {
        return this.f7398id;
    }

    public String getName() {
        return this.name;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public int getSex() {
        return this.sex;
    }

    public int getSportTarget() {
        return this.sportTarget;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setHeight(float f2) {
        this.height = f2;
    }

    public void setId(int i3) {
        this.f7398id = i3;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortraitUrl(String str) {
        this.portraitUrl = str;
    }

    public void setSex(int i3) {
        this.sex = i3;
    }

    public void setSportTarget(int i3) {
        this.sportTarget = i3;
    }

    public void setWeight(double d5) {
        this.weight = d5;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("UserInfoBean{id=");
        sb2.append(this.f7398id);
        sb2.append(", account='");
        sb2.append(this.account);
        sb2.append("', name='");
        sb2.append(this.name);
        sb2.append("', birthday='");
        sb2.append(this.birthday);
        sb2.append("', sex=");
        sb2.append(this.sex);
        sb2.append(", height=");
        sb2.append(this.height);
        sb2.append(", weight=");
        sb2.append(this.weight);
        sb2.append(", portraitUrl='");
        sb2.append(this.portraitUrl);
        sb2.append("', sportTarget=");
        return e.m(sb2, this.sportTarget, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f7398id);
        parcel.writeString(this.account);
        parcel.writeString(this.name);
        parcel.writeString(this.birthday);
        parcel.writeInt(this.sex);
        parcel.writeDouble(this.height);
        parcel.writeDouble(this.weight);
        parcel.writeString(this.portraitUrl);
        parcel.writeInt(this.sportTarget);
    }

    public void setHeight(double d5) {
        this.height = d5;
    }
}
