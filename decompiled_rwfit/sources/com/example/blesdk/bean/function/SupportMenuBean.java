package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SupportMenuBean implements Parcelable {
    public static final Parcelable.Creator<SupportMenuBean> CREATOR = new Parcelable.Creator<SupportMenuBean>() { // from class: com.example.blesdk.bean.function.SupportMenuBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SupportMenuBean createFromParcel(Parcel parcel) {
            return new SupportMenuBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SupportMenuBean[] newArray(int i3) {
            return new SupportMenuBean[i3];
        }
    };
    private boolean isActivityDataStaticTran2;
    private boolean isAddressBook;
    private boolean isAlarm;
    private boolean isAppFrontAndBack;
    private boolean isBLESupport_Function_V2;
    private boolean isBLESupport_Function_V2_Get_OK;
    private boolean isBloodOxy;
    private boolean isBloodPress;
    private boolean isBloodSugar;
    private boolean isBlueTooth;
    private boolean isBodyTemp;
    private boolean isBreathe;
    private boolean isBrightScreen;
    private boolean isBrightScreenTime;
    private boolean isChildAppSwitch;
    private boolean isDND;
    private boolean isDefaultENSYSTEM;
    private boolean isDefaultNoViewWorkout;
    private boolean isDial;
    private boolean isDrink;
    private boolean isEcg;
    private boolean isFindDevice;
    private boolean isFirmwareUpdate;
    private boolean isFunc2GirlCareGernal;
    private boolean isFunc2HealthAllSwitch;
    private boolean isHealthMontior;
    private boolean isHealthRing;
    private boolean isHr;
    private boolean isHrMonitor;
    private boolean isHrv;
    private boolean isLEDLight;
    private boolean isMsgNotification;
    private boolean isMuslimCountData;
    private boolean isMuslimRing;
    private boolean isNFC;
    private boolean isNewSport;
    private boolean isPowerOff;
    private boolean isPressure;
    private boolean isPushMsgEnableSwitch;
    private boolean isQrCode;
    private boolean isRecovery;
    private boolean isRememberSwitch;
    private boolean isRemindModel;
    private boolean isRestart;
    private boolean isSedentary;
    private boolean isSetBTName;
    private boolean isSleep;
    private boolean isStep;
    private boolean isSupportBoReminder;
    private boolean isSupportHrReminder;
    private boolean isSupportMotoVibrationLevel;
    private boolean isTakePhoto;
    private boolean isVaperBatteryData;
    private boolean isVaperPowerData;
    private boolean isVideoHid;
    private boolean isVideoHidAndroidBook;
    private boolean isVideoHidBook;
    private boolean isVideoHidMusic;
    private boolean isWallpaperDial;
    private boolean isWearDir;
    private boolean isWeather;
    private boolean isWomenHealth;
    private long pushMsgSwitchValue;

    public SupportMenuBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getPushMsgSwitchValue() {
        return this.pushMsgSwitchValue;
    }

    public boolean isActivityDataStaticTran2() {
        return this.isActivityDataStaticTran2;
    }

    public boolean isAddressBook() {
        return this.isAddressBook;
    }

    public boolean isAlarm() {
        return this.isAlarm;
    }

    public boolean isAppFrontAndBack() {
        return this.isAppFrontAndBack;
    }

    public boolean isBLESupport_Function_V2() {
        return this.isBLESupport_Function_V2;
    }

    public boolean isBLESupport_Function_V2_Get_OK() {
        return this.isBLESupport_Function_V2_Get_OK;
    }

    public boolean isBloodOxy() {
        return this.isBloodOxy;
    }

    public boolean isBloodPress() {
        return this.isBloodPress;
    }

    public boolean isBloodSugar() {
        return this.isBloodSugar;
    }

    public boolean isBlueTooth() {
        return this.isBlueTooth;
    }

    public boolean isBodyTemp() {
        return this.isBodyTemp;
    }

    public boolean isBreathe() {
        return this.isBreathe;
    }

    public boolean isBrightScreen() {
        return this.isBrightScreen;
    }

    public boolean isBrightScreenTime() {
        return this.isBrightScreenTime;
    }

    public boolean isChildAppSwitch() {
        return this.isChildAppSwitch;
    }

    public boolean isDND() {
        return this.isDND;
    }

    public boolean isDefaultENSYSTEM() {
        return this.isDefaultENSYSTEM;
    }

    public boolean isDefaultNoViewWorkout() {
        return this.isDefaultNoViewWorkout;
    }

    public boolean isDial() {
        return this.isDial;
    }

    public boolean isDrink() {
        return this.isDrink;
    }

    public boolean isEcg() {
        return this.isEcg;
    }

    public boolean isFindDevice() {
        return this.isFindDevice;
    }

    public boolean isFirmwareUpdate() {
        return this.isFirmwareUpdate;
    }

    public boolean isFunc2GirlCareGernal() {
        return this.isFunc2GirlCareGernal;
    }

    public boolean isFunc2HealthAllSwitch() {
        return this.isFunc2HealthAllSwitch;
    }

    public boolean isHealthMontior() {
        return this.isHealthMontior;
    }

    public boolean isHealthRing() {
        return this.isHealthRing;
    }

    public boolean isHr() {
        return this.isHr;
    }

    public boolean isHrMonitor() {
        return this.isHrMonitor;
    }

    public boolean isHrv() {
        return this.isHrv;
    }

    public boolean isLEDLight() {
        return this.isLEDLight;
    }

    public boolean isMsgNotification() {
        return this.isMsgNotification;
    }

    public boolean isMuslimCountData() {
        return this.isMuslimCountData;
    }

    public boolean isMuslimRing() {
        return this.isMuslimRing;
    }

    public boolean isNFC() {
        return this.isNFC;
    }

    public boolean isNewSport() {
        return this.isNewSport;
    }

    public boolean isPowerOff() {
        return this.isPowerOff;
    }

    public boolean isPressure() {
        return this.isPressure;
    }

    public boolean isPushMsgEnableSwitch() {
        return this.isPushMsgEnableSwitch;
    }

    public boolean isQrCode() {
        return this.isQrCode;
    }

    public boolean isRecovery() {
        return this.isRecovery;
    }

    public boolean isRememberSwitch() {
        return this.isRememberSwitch;
    }

    public boolean isRemindModel() {
        return this.isRemindModel;
    }

    public boolean isRestart() {
        return this.isRestart;
    }

    public boolean isSedentary() {
        return this.isSedentary;
    }

    public boolean isSetBTName() {
        return this.isSetBTName;
    }

    public boolean isSleep() {
        return this.isSleep;
    }

    public boolean isStep() {
        return this.isStep;
    }

    public boolean isSupportBoReminder() {
        return this.isSupportBoReminder;
    }

    public boolean isSupportHrReminder() {
        return this.isSupportHrReminder;
    }

    public boolean isSupportMotoVibrationLevel() {
        return this.isSupportMotoVibrationLevel;
    }

    public boolean isTakePhoto() {
        return this.isTakePhoto;
    }

    public boolean isVaperBatteryData() {
        return this.isVaperBatteryData;
    }

    public boolean isVaperPowerData() {
        return this.isVaperPowerData;
    }

    public boolean isVideoHid() {
        return this.isVideoHid;
    }

    public boolean isVideoHidAndroidBook() {
        return this.isVideoHidAndroidBook;
    }

    public boolean isVideoHidBook() {
        return this.isVideoHidBook;
    }

    public boolean isVideoHidMusic() {
        return this.isVideoHidMusic;
    }

    public boolean isWallpaperDial() {
        return this.isWallpaperDial;
    }

    public boolean isWearDir() {
        return this.isWearDir;
    }

    public boolean isWeather() {
        return this.isWeather;
    }

    public boolean isWomenHealth() {
        return this.isWomenHealth;
    }

    public void setActivityDataStaticTran2(boolean z5) {
        this.isActivityDataStaticTran2 = z5;
    }

    public void setAddressBook(boolean z5) {
        this.isAddressBook = z5;
    }

    public void setAlarm(boolean z5) {
        this.isAlarm = z5;
    }

    public void setAppFrontAndBack(boolean z5) {
        this.isAppFrontAndBack = z5;
    }

    public void setBLESupport_Function_V2(boolean z5) {
        this.isBLESupport_Function_V2 = z5;
    }

    public void setBLESupport_Function_V2_Get_OK(boolean z5) {
        this.isBLESupport_Function_V2_Get_OK = z5;
    }

    public void setBloodOxy(boolean z5) {
        this.isBloodOxy = z5;
    }

    public void setBloodPress(boolean z5) {
        this.isBloodPress = z5;
    }

    public void setBloodSugar(boolean z5) {
        this.isBloodSugar = z5;
    }

    public void setBlueTooth(boolean z5) {
        this.isBlueTooth = z5;
    }

    public void setBodyTemp(boolean z5) {
        this.isBodyTemp = z5;
    }

    public void setBreathe(boolean z5) {
        this.isBreathe = z5;
    }

    public void setBrightScreen(boolean z5) {
        this.isBrightScreen = z5;
    }

    public void setBrightScreenTime(boolean z5) {
        this.isBrightScreenTime = z5;
    }

    public void setChildAppSwitch(boolean z5) {
        this.isChildAppSwitch = z5;
    }

    public void setDND(boolean z5) {
        this.isDND = z5;
    }

    public void setDefaultENSYSTEM(boolean z5) {
        this.isDefaultENSYSTEM = z5;
    }

    public void setDefaultNoViewWorkout(boolean z5) {
        this.isDefaultNoViewWorkout = z5;
    }

    public void setDial(boolean z5) {
        this.isDial = z5;
    }

    public void setDrink(boolean z5) {
        this.isDrink = z5;
    }

    public void setEcg(boolean z5) {
        this.isEcg = z5;
    }

    public void setFindDevice(boolean z5) {
        this.isFindDevice = z5;
    }

    public void setFirmwareUpdate(boolean z5) {
        this.isFirmwareUpdate = z5;
    }

    public void setFunc2GirlCareGernal(boolean z5) {
        this.isFunc2GirlCareGernal = z5;
    }

    public void setFunc2HealthAllSwitch(boolean z5) {
        this.isFunc2HealthAllSwitch = z5;
    }

    public void setHealthMontior(boolean z5) {
        this.isHealthMontior = z5;
    }

    public void setHealthRing(boolean z5) {
        this.isHealthRing = z5;
    }

    public void setHr(boolean z5) {
        this.isHr = z5;
    }

    public void setHrMonitor(boolean z5) {
        this.isHrMonitor = z5;
    }

    public void setHrv(boolean z5) {
        this.isHrv = z5;
    }

    public void setLEDLight(boolean z5) {
        this.isLEDLight = z5;
    }

    public void setMsgNotification(boolean z5) {
        this.isMsgNotification = z5;
    }

    public void setMuslimCountData(boolean z5) {
        this.isMuslimCountData = z5;
    }

    public void setMuslimRing(boolean z5) {
        this.isMuslimRing = z5;
    }

    public void setNFC(boolean z5) {
        this.isNFC = z5;
    }

    public void setNewSport(boolean z5) {
        this.isNewSport = z5;
    }

    public void setPowerOff(boolean z5) {
        this.isPowerOff = z5;
    }

    public void setPressure(boolean z5) {
        this.isPressure = z5;
    }

    public void setPushMsgEnableSwitch(boolean z5) {
        this.isPushMsgEnableSwitch = z5;
    }

    public void setPushMsgSwitchValue(long j4) {
        this.pushMsgSwitchValue = j4;
    }

    public void setQrCode(boolean z5) {
        this.isQrCode = z5;
    }

    public void setRecovery(boolean z5) {
        this.isRecovery = z5;
    }

    public void setRememberSwitch(boolean z5) {
        this.isRememberSwitch = z5;
    }

    public void setRemindModel(boolean z5) {
        this.isRemindModel = z5;
    }

    public void setRestart(boolean z5) {
        this.isRestart = z5;
    }

    public void setSedentary(boolean z5) {
        this.isSedentary = z5;
    }

    public void setSetBTName(boolean z5) {
        this.isSetBTName = z5;
    }

    public void setSleep(boolean z5) {
        this.isSleep = z5;
    }

    public void setStep(boolean z5) {
        this.isStep = z5;
    }

    public void setSupportBoReminder(boolean z5) {
        this.isSupportBoReminder = z5;
    }

    public void setSupportHrReminder(boolean z5) {
        this.isSupportHrReminder = z5;
    }

    public void setSupportMotoVibrationLevel(boolean z5) {
        this.isSupportMotoVibrationLevel = z5;
    }

    public void setTakePhoto(boolean z5) {
        this.isTakePhoto = z5;
    }

    public void setVaperBatteryData(boolean z5) {
        this.isVaperBatteryData = z5;
    }

    public void setVaperPowerData(boolean z5) {
        this.isVaperPowerData = z5;
    }

    public void setVideoHid(boolean z5) {
        this.isVideoHid = z5;
    }

    public void setVideoHidAndroidBook(boolean z5) {
        this.isVideoHidAndroidBook = z5;
    }

    public void setVideoHidBook(boolean z5) {
        this.isVideoHidBook = z5;
    }

    public void setVideoHidMusic(boolean z5) {
        this.isVideoHidMusic = z5;
    }

    public void setWallpaperDial(boolean z5) {
        this.isWallpaperDial = z5;
    }

    public void setWearDir(boolean z5) {
        this.isWearDir = z5;
    }

    public void setWeather(boolean z5) {
        this.isWeather = z5;
    }

    public void setWomenHealth(boolean z5) {
        this.isWomenHealth = z5;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SupportMenuBean{isStep=");
        sb2.append(this.isStep);
        sb2.append(", isSleep=");
        sb2.append(this.isSleep);
        sb2.append(", isHr=");
        sb2.append(this.isHr);
        sb2.append(", isBloodPress=");
        sb2.append(this.isBloodPress);
        sb2.append(", isBloodOxy=");
        sb2.append(this.isBloodOxy);
        sb2.append(", isBodyTemp=");
        sb2.append(this.isBodyTemp);
        sb2.append(", isEcg=");
        sb2.append(this.isEcg);
        sb2.append(", isBreathe=");
        sb2.append(this.isBreathe);
        sb2.append(", isDial=");
        sb2.append(this.isDial);
        sb2.append(", isWallpaperDial=");
        sb2.append(this.isWallpaperDial);
        sb2.append(", isMsgNotification=");
        sb2.append(this.isMsgNotification);
        sb2.append(", isSedentary=");
        sb2.append(this.isSedentary);
        sb2.append(", isDrink=");
        sb2.append(this.isDrink);
        sb2.append(", isRemindModel=");
        sb2.append(this.isRemindModel);
        sb2.append(", isAlarm=");
        sb2.append(this.isAlarm);
        sb2.append(", isBrightScreen=");
        sb2.append(this.isBrightScreen);
        sb2.append(", isBrightScreenTime=");
        sb2.append(this.isBrightScreenTime);
        sb2.append(", isHrMonitor=");
        sb2.append(this.isHrMonitor);
        sb2.append(", isDND=");
        sb2.append(this.isDND);
        sb2.append(", isWeather=");
        sb2.append(this.isWeather);
        sb2.append(", isAddressBook=");
        sb2.append(this.isAddressBook);
        sb2.append(", isRecovery=");
        sb2.append(this.isRecovery);
        sb2.append(", isFirmwareUpdate=");
        sb2.append(this.isFirmwareUpdate);
        sb2.append(", isNFC=");
        sb2.append(this.isNFC);
        sb2.append(", isQrCode=");
        sb2.append(this.isQrCode);
        sb2.append(", isRestart=");
        sb2.append(this.isRestart);
        sb2.append(", isPowerOff=");
        sb2.append(this.isPowerOff);
        sb2.append(", isBlueTooth=");
        sb2.append(this.isBlueTooth);
        sb2.append(", isWomenHealth=");
        sb2.append(this.isWomenHealth);
        sb2.append(", isActivityDataStaticTran2=");
        sb2.append(this.isActivityDataStaticTran2);
        sb2.append(", isFunc2HealthAllSwitch=");
        sb2.append(this.isFunc2HealthAllSwitch);
        sb2.append(", isChildAppSwitch=");
        sb2.append(this.isChildAppSwitch);
        sb2.append(", isMuslimCountData=");
        sb2.append(this.isMuslimCountData);
        sb2.append(", isPushMsgEnableSwitch=");
        return e.o(sb2, this.isPushMsgEnableSwitch, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.isStep ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSleep ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isHr ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBloodPress ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBloodOxy ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBodyTemp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isEcg ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBreathe ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDial ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isWallpaperDial ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isMsgNotification ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSedentary ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDrink ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRemindModel ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAlarm ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBrightScreen ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBrightScreenTime ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isHrMonitor ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDND ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isWeather ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAddressBook ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRecovery ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFirmwareUpdate ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isNFC ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isQrCode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRestart ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isPowerOff ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBlueTooth ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isWomenHealth ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isPressure ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBloodSugar ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isMuslimRing ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVaperPowerData ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVaperBatteryData ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isActivityDataStaticTran2 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBLESupport_Function_V2 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isHealthRing ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFindDevice ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVideoHid ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSetBTName ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isLEDLight ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isHrv ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isTakePhoto ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isWearDir ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isHealthMontior ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBLESupport_Function_V2_Get_OK ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVideoHidBook ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVideoHidMusic ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFunc2HealthAllSwitch ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVideoHidAndroidBook ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isChildAppSwitch ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isMuslimCountData ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isPushMsgEnableSwitch ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.pushMsgSwitchValue);
        parcel.writeByte(this.isFunc2GirlCareGernal ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDefaultENSYSTEM ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDefaultNoViewWorkout ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isNewSport ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAppFrontAndBack ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRememberSwitch ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSupportHrReminder ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSupportBoReminder ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSupportMotoVibrationLevel ? (byte) 1 : (byte) 0);
    }

    public SupportMenuBean(Parcel parcel) {
        this.isStep = parcel.readByte() != 0;
        this.isSleep = parcel.readByte() != 0;
        this.isHr = parcel.readByte() != 0;
        this.isBloodPress = parcel.readByte() != 0;
        this.isBloodOxy = parcel.readByte() != 0;
        this.isBodyTemp = parcel.readByte() != 0;
        this.isEcg = parcel.readByte() != 0;
        this.isBreathe = parcel.readByte() != 0;
        this.isDial = parcel.readByte() != 0;
        this.isWallpaperDial = parcel.readByte() != 0;
        this.isMsgNotification = parcel.readByte() != 0;
        this.isSedentary = parcel.readByte() != 0;
        this.isDrink = parcel.readByte() != 0;
        this.isRemindModel = parcel.readByte() != 0;
        this.isAlarm = parcel.readByte() != 0;
        this.isBrightScreen = parcel.readByte() != 0;
        this.isBrightScreenTime = parcel.readByte() != 0;
        this.isHrMonitor = parcel.readByte() != 0;
        this.isDND = parcel.readByte() != 0;
        this.isWeather = parcel.readByte() != 0;
        this.isAddressBook = parcel.readByte() != 0;
        this.isRecovery = parcel.readByte() != 0;
        this.isFirmwareUpdate = parcel.readByte() != 0;
        this.isNFC = parcel.readByte() != 0;
        this.isQrCode = parcel.readByte() != 0;
        this.isRestart = parcel.readByte() != 0;
        this.isPowerOff = parcel.readByte() != 0;
        this.isBlueTooth = parcel.readByte() != 0;
        this.isWomenHealth = parcel.readByte() != 0;
        this.isPressure = parcel.readByte() != 0;
        this.isBloodSugar = parcel.readByte() != 0;
        this.isMuslimRing = parcel.readByte() != 0;
        this.isVaperPowerData = parcel.readByte() != 0;
        this.isVaperBatteryData = parcel.readByte() != 0;
        this.isActivityDataStaticTran2 = parcel.readByte() != 0;
        this.isBLESupport_Function_V2 = parcel.readByte() != 0;
        this.isHealthRing = parcel.readByte() != 0;
        this.isFindDevice = parcel.readByte() != 0;
        this.isVideoHid = parcel.readByte() != 0;
        this.isSetBTName = parcel.readByte() != 0;
        this.isLEDLight = parcel.readByte() != 0;
        this.isHrv = parcel.readByte() != 0;
        this.isTakePhoto = parcel.readByte() != 0;
        this.isWearDir = parcel.readByte() != 0;
        this.isHealthMontior = parcel.readByte() != 0;
        this.isBLESupport_Function_V2_Get_OK = parcel.readByte() != 0;
        this.isVideoHidBook = parcel.readByte() != 0;
        this.isVideoHidMusic = parcel.readByte() != 0;
        this.isFunc2HealthAllSwitch = parcel.readByte() != 0;
        this.isVideoHidAndroidBook = parcel.readByte() != 0;
        this.isChildAppSwitch = parcel.readByte() != 0;
        this.isMuslimCountData = parcel.readByte() != 0;
        this.isPushMsgEnableSwitch = parcel.readByte() != 0;
        this.pushMsgSwitchValue = parcel.readLong();
        this.isFunc2GirlCareGernal = parcel.readByte() != 0;
        this.isDefaultENSYSTEM = parcel.readByte() != 0;
        this.isDefaultNoViewWorkout = parcel.readByte() != 0;
        this.isNewSport = parcel.readByte() != 0;
        this.isAppFrontAndBack = parcel.readByte() != 0;
        this.isRememberSwitch = parcel.readByte() != 0;
        this.isSupportHrReminder = parcel.readByte() != 0;
        this.isSupportBoReminder = parcel.readByte() != 0;
        this.isSupportMotoVibrationLevel = parcel.readByte() != 0;
    }
}
