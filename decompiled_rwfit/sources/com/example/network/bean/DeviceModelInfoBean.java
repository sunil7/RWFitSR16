package com.example.network.bean;

import android.os.Parcel;
import android.os.Parcelable;
import r5.a;

/* loaded from: classes.dex */
public class DeviceModelInfoBean implements Parcelable {
    public static final Parcelable.Creator<DeviceModelInfoBean> CREATOR = new Parcelable.Creator<DeviceModelInfoBean>() { // from class: com.example.network.bean.DeviceModelInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceModelInfoBean createFromParcel(Parcel parcel) {
            return new DeviceModelInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceModelInfoBean[] newArray(int i3) {
            return new DeviceModelInfoBean[i3];
        }
    };
    private String customizeDialShowUrl;
    private String defaultCustomizeDialFlag;
    private String defaultCustomizeDialUrl;
    private String deviceClazz;
    private String height;
    private String showUrl;
    private String thumbHeight;
    private String thumbWidth;
    private String width;

    public DeviceModelInfoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCustomizeDialShowUrl() {
        return this.customizeDialShowUrl;
    }

    public String getDefaultCustomizeDialFlag() {
        return this.defaultCustomizeDialFlag;
    }

    public String getDefaultCustomizeDialUrl() {
        return this.defaultCustomizeDialUrl;
    }

    public String getDeviceClazz() {
        return this.deviceClazz;
    }

    public String getHeight() {
        return this.height;
    }

    public String getShowUrl() {
        return this.showUrl;
    }

    public String getThumbHeight() {
        return this.thumbHeight;
    }

    public String getThumbWidth() {
        return this.thumbWidth;
    }

    public String getWidth() {
        return this.width;
    }

    public void setCustomizeDialShowUrl(String str) {
        this.customizeDialShowUrl = str;
    }

    public void setDefaultCustomizeDialFlag(String str) {
        this.defaultCustomizeDialFlag = str;
    }

    public void setDefaultCustomizeDialUrl(String str) {
        this.defaultCustomizeDialUrl = str;
    }

    public void setDeviceClazz(String str) {
        this.deviceClazz = str;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setShowUrl(String str) {
        this.showUrl = str;
    }

    public void setThumbHeight(String str) {
        this.thumbHeight = str;
    }

    public void setThumbWidth(String str) {
        this.thumbWidth = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DeviceModelInfoBean{customizeDialShowUrl='");
        sb2.append(this.customizeDialShowUrl);
        sb2.append("', defaultCustomizeDialFlag='");
        sb2.append(this.defaultCustomizeDialFlag);
        sb2.append("', defaultCustomizeDialUrl='");
        sb2.append(this.defaultCustomizeDialUrl);
        sb2.append("', height='");
        sb2.append(this.height);
        sb2.append("', width='");
        sb2.append(this.width);
        sb2.append("', showUrl='");
        sb2.append(this.showUrl);
        sb2.append("', thumbHeight='");
        sb2.append(this.thumbHeight);
        sb2.append("', thumbWidth='");
        sb2.append(this.thumbWidth);
        sb2.append("', deviceClazz='");
        return a.f(sb2, this.deviceClazz, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.customizeDialShowUrl);
        parcel.writeString(this.defaultCustomizeDialFlag);
        parcel.writeString(this.defaultCustomizeDialUrl);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
        parcel.writeString(this.showUrl);
        parcel.writeString(this.thumbWidth);
        parcel.writeString(this.thumbHeight);
        parcel.writeString(this.deviceClazz);
    }

    public DeviceModelInfoBean(Parcel parcel) {
        this.customizeDialShowUrl = parcel.readString();
        this.defaultCustomizeDialFlag = parcel.readString();
        this.defaultCustomizeDialUrl = parcel.readString();
        this.height = parcel.readString();
        this.width = parcel.readString();
        this.showUrl = parcel.readString();
        this.thumbWidth = parcel.readString();
        this.thumbHeight = parcel.readString();
        this.deviceClazz = parcel.readString();
    }
}
