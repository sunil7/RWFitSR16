package com.example.database.table;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Devices implements Parcelable {
    public static final Parcelable.Creator<Devices> CREATOR = new Parcelable.Creator<Devices>() { // from class: com.example.database.table.Devices.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Devices createFromParcel(Parcel parcel) {
            return new Devices(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Devices[] newArray(int i3) {
            return new Devices[i3];
        }
    };
    private String createTime;
    private int deviceClass;
    private String deviceFlag;
    private String deviceModel;
    private String deviceUuid;
    private String deviceVer;

    /* renamed from: id, reason: collision with root package name */
    private Long f7377id;
    private String macAddress;
    private String name;
    private int status;
    private String userId;

    public Devices() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public int getDeviceClass() {
        return this.deviceClass;
    }

    public String getDeviceFlag() {
        return this.deviceFlag;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceUuid() {
        return this.deviceUuid;
    }

    public String getDeviceVer() {
        return this.deviceVer;
    }

    public Long getId() {
        return this.f7377id;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDeviceClass(int i3) {
        this.deviceClass = i3;
    }

    public void setDeviceFlag(String str) {
        this.deviceFlag = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setDeviceUuid(String str) {
        this.deviceUuid = str;
    }

    public void setDeviceVer(String str) {
        this.deviceVer = str;
    }

    public void setId(Long l3) {
        this.f7377id = l3;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (this.f7377id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.f7377id.longValue());
        }
        parcel.writeString(this.userId);
        parcel.writeString(this.macAddress);
        parcel.writeString(this.name);
        parcel.writeInt(this.deviceClass);
        parcel.writeString(this.deviceUuid);
        parcel.writeString(this.deviceVer);
        parcel.writeInt(this.status);
        parcel.writeString(this.createTime);
        parcel.writeString(this.deviceModel);
        parcel.writeString(this.deviceFlag);
    }

    public Devices(Parcel parcel) {
        if (parcel.readByte() == 0) {
            this.f7377id = null;
        } else {
            this.f7377id = Long.valueOf(parcel.readLong());
        }
        this.userId = parcel.readString();
        this.macAddress = parcel.readString();
        this.name = parcel.readString();
        this.deviceClass = parcel.readInt();
        this.deviceUuid = parcel.readString();
        this.deviceVer = parcel.readString();
        this.status = parcel.readInt();
        this.createTime = parcel.readString();
        this.deviceModel = parcel.readString();
        this.deviceFlag = parcel.readString();
    }

    public Devices(Long l3, String str, String str2, String str3, int i3, String str4, String str5, int i10, String str6, String str7, String str8) {
        this.f7377id = l3;
        this.userId = str;
        this.macAddress = str2;
        this.name = str3;
        this.deviceClass = i3;
        this.deviceUuid = str4;
        this.deviceVer = str5;
        this.status = i10;
        this.createTime = str6;
        this.deviceModel = str7;
        this.deviceFlag = str8;
    }
}
