package com.example.test.ui.device.model;

/* loaded from: classes.dex */
public class BleDeviceModel {
    private String mac;
    private String name;
    private int pidType;
    private String rawDataFlag;
    private int rssi;

    public int getLevel() {
        int i3 = this.rssi;
        if (i3 <= -80) {
            return 1;
        }
        if (i3 <= -70) {
            return 2;
        }
        return i3 <= -60 ? 3 : 4;
    }

    public String getMac() {
        return this.mac;
    }

    public String getName() {
        return this.name;
    }

    public int getPidType() {
        return this.pidType;
    }

    public String getRawDataFlag() {
        return this.rawDataFlag;
    }

    public int getRssi() {
        return this.rssi;
    }

    public boolean isJLHeadset() {
        String str = this.name;
        if (str != null) {
            return str.contains("SmartBox") || this.name.contains("AC701N_watch");
        }
        return false;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPidType(int i3) {
        this.pidType = i3;
    }

    public void setRawDataFlag(String str) {
        this.rawDataFlag = str;
    }

    public void setRssi(int i3) {
        this.rssi = i3;
    }
}
