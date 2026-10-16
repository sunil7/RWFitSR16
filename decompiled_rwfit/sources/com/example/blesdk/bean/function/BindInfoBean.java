package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BindInfoBean implements Parcelable {
    public static final Parcelable.Creator<BindInfoBean> CREATOR = new Parcelable.Creator<BindInfoBean>() { // from class: com.example.blesdk.bean.function.BindInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BindInfoBean createFromParcel(Parcel parcel) {
            return new BindInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BindInfoBean[] newArray(int i3) {
            return new BindInfoBean[i3];
        }
    };
    private byte antiLostEnable;
    private byte batteryNumDisable;
    private int bindStatus;
    private int bindType;
    private String btAddress;
    private byte dateFormatEnable;
    private String deviceClazz;
    private byte drinkWaterEnable;
    private byte isActivityDataStaticTran2;
    private byte isBLESupport_Function_V2;
    private byte isBloodSugar;
    private byte isBo;
    private byte isBp;
    private byte isFindDevice;
    private byte isHealthRing;
    private byte isHeartRate;
    private byte isHrv;
    private byte isLEDLight;
    private byte isMenstrualCycle;
    private byte isMuslimRing;
    private byte isPressure;
    private byte isSetBTName;
    private byte isSleep;
    private byte isStep;
    private byte isVaperBatteryData;
    private byte isVaperPowerData;
    private byte isVideoHid;
    private byte newSleepAlgoEnable;
    private byte spo2DetectSetEnable;
    private byte temperatureUnitEnable;
    private String userId;
    private byte washHandsEnable;
    private byte weather2Enable;

    public BindInfoBean() {
        this.deviceClazz = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte getAntiLostEnable() {
        return this.antiLostEnable;
    }

    public byte getBatteryNumDisable() {
        return this.batteryNumDisable;
    }

    public int getBindStatus() {
        return this.bindStatus;
    }

    public int getBindType() {
        return this.bindType;
    }

    public String getBtAddress() {
        return this.btAddress;
    }

    public byte getDateFormatEnable() {
        return this.dateFormatEnable;
    }

    public String getDeviceClazz() {
        return this.deviceClazz;
    }

    public byte getDrinkWaterEnable() {
        return this.drinkWaterEnable;
    }

    public byte getIsActivityDataStaticTran2() {
        return this.isActivityDataStaticTran2;
    }

    public byte getIsBLESupport_Function_V2() {
        return this.isBLESupport_Function_V2;
    }

    public byte getIsBloodSugar() {
        return this.isBloodSugar;
    }

    public byte getIsBo() {
        return this.isBo;
    }

    public byte getIsBp() {
        return this.isBp;
    }

    public byte getIsFindDevice() {
        return this.isFindDevice;
    }

    public byte getIsHealthRing() {
        return this.isHealthRing;
    }

    public byte getIsHeartRate() {
        return this.isHeartRate;
    }

    public byte getIsHrv() {
        return this.isHrv;
    }

    public byte getIsLEDLight() {
        return this.isLEDLight;
    }

    public byte getIsMenstrualCycle() {
        return this.isMenstrualCycle;
    }

    public byte getIsMuslimRing() {
        return this.isMuslimRing;
    }

    public byte getIsPressure() {
        return this.isPressure;
    }

    public byte getIsSetBTName() {
        return this.isSetBTName;
    }

    public byte getIsSleep() {
        return this.isSleep;
    }

    public byte getIsStep() {
        return this.isStep;
    }

    public byte getIsVaperBatteryData() {
        return this.isVaperBatteryData;
    }

    public byte getIsVaperPowerData() {
        return this.isVaperPowerData;
    }

    public byte getIsVideoHid() {
        return this.isVideoHid;
    }

    public byte getNewSleepAlgoEnable() {
        return this.newSleepAlgoEnable;
    }

    public byte getSpo2DetectSetEnable() {
        return this.spo2DetectSetEnable;
    }

    public byte getTemperatureUnitEnable() {
        return this.temperatureUnitEnable;
    }

    public String getUserId() {
        return this.userId;
    }

    public byte getWashHandsEnable() {
        return this.washHandsEnable;
    }

    public byte getWeather2Enable() {
        return this.weather2Enable;
    }

    public void setAntiLostEnable(byte b3) {
        this.antiLostEnable = b3;
    }

    public void setBatteryNumDisable(byte b3) {
        this.batteryNumDisable = b3;
    }

    public void setBindStatus(int i3) {
        this.bindStatus = i3;
    }

    public void setBindType(int i3) {
        this.bindType = i3;
    }

    public void setBtAddress(String str) {
        this.btAddress = str;
    }

    public void setDateFormatEnable(byte b3) {
        this.dateFormatEnable = b3;
    }

    public void setDeviceClazz(String str) {
        this.deviceClazz = str;
    }

    public void setDrinkWaterEnable(byte b3) {
        this.drinkWaterEnable = b3;
    }

    public void setIsActivityDataStaticTran2(byte b3) {
        this.isActivityDataStaticTran2 = b3;
    }

    public void setIsBLESupport_Function_V2(byte b3) {
        this.isBLESupport_Function_V2 = b3;
    }

    public void setIsBloodSugar(byte b3) {
        this.isBloodSugar = b3;
    }

    public void setIsBo(byte b3) {
        this.isBo = b3;
    }

    public void setIsBp(byte b3) {
        this.isBp = b3;
    }

    public void setIsFindDevice(byte b3) {
        this.isFindDevice = b3;
    }

    public void setIsHealthRing(byte b3) {
        this.isHealthRing = b3;
    }

    public void setIsHeartRate(byte b3) {
        this.isHeartRate = b3;
    }

    public void setIsHrv(byte b3) {
        this.isHrv = b3;
    }

    public void setIsLEDLight(byte b3) {
        this.isLEDLight = b3;
    }

    public void setIsMenstrualCycle(byte b3) {
        this.isMenstrualCycle = b3;
    }

    public void setIsMuslimRing(byte b3) {
        this.isMuslimRing = b3;
    }

    public void setIsPressure(byte b3) {
        this.isPressure = b3;
    }

    public void setIsSetBTName(byte b3) {
        this.isSetBTName = b3;
    }

    public void setIsSleep(byte b3) {
        this.isSleep = b3;
    }

    public void setIsStep(byte b3) {
        this.isStep = b3;
    }

    public void setIsVaperBatteryData(byte b3) {
        this.isVaperBatteryData = b3;
    }

    public void setIsVaperPowerData(byte b3) {
        this.isVaperPowerData = b3;
    }

    public void setIsVideoHid(byte b3) {
        this.isVideoHid = b3;
    }

    public void setNewSleepAlgoEnable(byte b3) {
        this.newSleepAlgoEnable = b3;
    }

    public void setSpo2DetectSetEnable(byte b3) {
        this.spo2DetectSetEnable = b3;
    }

    public void setTemperatureUnitEnable(byte b3) {
        this.temperatureUnitEnable = b3;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWashHandsEnable(byte b3) {
        this.washHandsEnable = b3;
    }

    public void setWeather2Enable(byte b3) {
        this.weather2Enable = b3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.bindStatus);
        parcel.writeInt(this.bindType);
        parcel.writeString(this.userId);
        parcel.writeString(this.btAddress);
        parcel.writeString(this.deviceClazz);
        parcel.writeByte(this.batteryNumDisable);
        parcel.writeByte(this.antiLostEnable);
        parcel.writeByte(this.newSleepAlgoEnable);
        parcel.writeByte(this.dateFormatEnable);
        parcel.writeByte(this.temperatureUnitEnable);
        parcel.writeByte(this.drinkWaterEnable);
        parcel.writeByte(this.spo2DetectSetEnable);
        parcel.writeByte(this.washHandsEnable);
        parcel.writeByte(this.weather2Enable);
        parcel.writeByte(this.isStep);
        parcel.writeByte(this.isHeartRate);
        parcel.writeByte(this.isBo);
        parcel.writeByte(this.isBp);
        parcel.writeByte(this.isBloodSugar);
        parcel.writeByte(this.isPressure);
        parcel.writeByte(this.isMenstrualCycle);
        parcel.writeByte(this.isMuslimRing);
        parcel.writeByte(this.isVaperPowerData);
        parcel.writeByte(this.isVaperBatteryData);
        parcel.writeByte(this.isActivityDataStaticTran2);
        parcel.writeByte(this.isBLESupport_Function_V2);
        parcel.writeByte(this.isHealthRing);
        parcel.writeByte(this.isFindDevice);
        parcel.writeByte(this.isVideoHid);
        parcel.writeByte(this.isSetBTName);
        parcel.writeByte(this.isLEDLight);
        parcel.writeByte(this.isHrv);
        parcel.writeByte(this.isSleep);
    }

    public BindInfoBean(Parcel parcel) {
        this.deviceClazz = "";
        this.bindStatus = parcel.readInt();
        this.bindType = parcel.readInt();
        this.userId = parcel.readString();
        this.btAddress = parcel.readString();
        this.deviceClazz = parcel.readString();
        this.batteryNumDisable = parcel.readByte();
        this.antiLostEnable = parcel.readByte();
        this.newSleepAlgoEnable = parcel.readByte();
        this.dateFormatEnable = parcel.readByte();
        this.temperatureUnitEnable = parcel.readByte();
        this.drinkWaterEnable = parcel.readByte();
        this.spo2DetectSetEnable = parcel.readByte();
        this.washHandsEnable = parcel.readByte();
        this.weather2Enable = parcel.readByte();
        this.isStep = parcel.readByte();
        this.isHeartRate = parcel.readByte();
        this.isBo = parcel.readByte();
        this.isBp = parcel.readByte();
        this.isBloodSugar = parcel.readByte();
        this.isPressure = parcel.readByte();
        this.isMenstrualCycle = parcel.readByte();
        this.isMuslimRing = parcel.readByte();
        this.isVaperPowerData = parcel.readByte();
        this.isVaperBatteryData = parcel.readByte();
        this.isActivityDataStaticTran2 = parcel.readByte();
        this.isBLESupport_Function_V2 = parcel.readByte();
        this.isHealthRing = parcel.readByte();
        this.isFindDevice = parcel.readByte();
        this.isVideoHid = parcel.readByte();
        this.isSetBTName = parcel.readByte();
        this.isLEDLight = parcel.readByte();
        this.isHrv = parcel.readByte();
        this.isSleep = parcel.readByte();
    }
}
