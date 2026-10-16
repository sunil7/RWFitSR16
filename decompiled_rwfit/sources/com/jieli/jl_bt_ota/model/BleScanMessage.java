package com.jieli.jl_bt_ota.model;

import android.support.v4.media.session.e;
import ee.b;
import java.io.Serializable;

/* loaded from: classes.dex */
public class BleScanMessage implements Serializable {
    private int battery;
    private int deviceType;
    private int deviceVersion;
    private String identify;
    private boolean isEnableConnect = true;
    private boolean isOTA;
    private String oldBleAddress;
    private int pid;
    private byte[] rawData;
    private int rssi;
    private int uid;
    private int version;
    private int vid;

    public int getBattery() {
        return this.battery;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getDeviceVersion() {
        return this.deviceVersion;
    }

    public String getIdentify() {
        return this.identify;
    }

    public String getOldBleAddress() {
        return this.oldBleAddress;
    }

    public int getPid() {
        return this.pid;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public int getRssi() {
        return this.rssi;
    }

    public int getUid() {
        return this.uid;
    }

    public int getVersion() {
        return this.version;
    }

    public int getVid() {
        return this.vid;
    }

    public boolean isEnableConnect() {
        return this.isEnableConnect;
    }

    public boolean isOTA() {
        return this.isOTA;
    }

    public BleScanMessage setBattery(int i3) {
        this.battery = i3;
        return this;
    }

    public BleScanMessage setDeviceType(int i3) {
        this.deviceType = i3;
        return this;
    }

    public BleScanMessage setDeviceVersion(int i3) {
        this.deviceVersion = i3;
        return this;
    }

    public BleScanMessage setEnableConnect(boolean z5) {
        this.isEnableConnect = z5;
        return this;
    }

    public BleScanMessage setIdentify(String str) {
        this.identify = str;
        return this;
    }

    public BleScanMessage setOTA(boolean z5) {
        this.isOTA = z5;
        return this;
    }

    public BleScanMessage setOldBleAddress(String str) {
        this.oldBleAddress = str;
        return this;
    }

    public BleScanMessage setPid(int i3) {
        this.pid = i3;
        return this;
    }

    public BleScanMessage setRawData(byte[] bArr) {
        this.rawData = bArr;
        return this;
    }

    public BleScanMessage setRssi(int i3) {
        this.rssi = i3;
        return this;
    }

    public BleScanMessage setUid(int i3) {
        this.uid = i3;
        return this;
    }

    public BleScanMessage setVersion(int i3) {
        this.version = i3;
        return this;
    }

    public BleScanMessage setVid(int i3) {
        this.vid = i3;
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BleScanMessage{rawData=");
        sb2.append(b.c(this.rawData));
        sb2.append(", rssi=");
        sb2.append(this.rssi);
        sb2.append(", isEnableConnect=");
        sb2.append(this.isEnableConnect);
        sb2.append(", vid=");
        sb2.append(this.vid);
        sb2.append(", uid=");
        sb2.append(this.uid);
        sb2.append(", pid=");
        sb2.append(this.pid);
        sb2.append(", identify='");
        sb2.append(this.identify);
        sb2.append("', version=");
        sb2.append(this.version);
        sb2.append(", oldBleAddress='");
        sb2.append(this.oldBleAddress);
        sb2.append("', isOTA=");
        sb2.append(this.isOTA);
        sb2.append(", deviceType=");
        sb2.append(this.deviceType);
        sb2.append(", deviceVersion=");
        sb2.append(this.deviceVersion);
        sb2.append(", battery=");
        return e.m(sb2, this.battery, '}');
    }
}
