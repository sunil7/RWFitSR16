package com.example.test.ui.device.model;

/* loaded from: classes.dex */
public class DeviceInfoModel extends DeviceOptionModel {
    private int bindStatus;
    private int connectStatus;
    private String deviceName;
    private String deviceUrl;
    private boolean isHasNew;
    private boolean isLowPower;
    private boolean isPowering;
    private String mac;
    private int power;
    private String showUrl;
    private String version;

    public DeviceInfoModel(int i3, int i10) {
        super(i3, i10);
        this.version = "--";
    }

    public int getBindStatus() {
        return this.bindStatus;
    }

    public int getConnectStatus() {
        return this.connectStatus;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceUrl() {
        return this.deviceUrl;
    }

    public String getMac() {
        return this.mac;
    }

    public int getPower() {
        return this.power;
    }

    public String getShowUrl() {
        return this.showUrl;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isHasNew() {
        return this.isHasNew;
    }

    public boolean isLowPower() {
        return this.isLowPower;
    }

    public boolean isPowering() {
        return this.isPowering;
    }

    public void setBindStatus(int i3) {
        this.bindStatus = i3;
    }

    public void setConnectStatus(int i3) {
        this.connectStatus = i3;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceUrl(String str) {
        this.deviceUrl = str;
    }

    public void setHasNew(boolean z5) {
        this.isHasNew = z5;
    }

    public void setLowPower(boolean z5) {
        this.isLowPower = z5;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setPower(int i3) {
        this.power = i3;
    }

    public void setPowering(boolean z5) {
        this.isPowering = z5;
    }

    public void setShowUrl(String str) {
        this.showUrl = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
