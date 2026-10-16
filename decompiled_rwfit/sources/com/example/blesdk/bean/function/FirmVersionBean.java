package com.example.blesdk.bean.function;

import com.example.blesdk.bean.BleSendBean;
import r5.a;

/* loaded from: classes.dex */
public class FirmVersionBean extends BleSendBean {
    private String deviceClazz = "";
    private String deviceNo = "1.0.0";
    private int screenHeight;
    private int screenType;
    private int screenWidth;
    private String uiVersion;

    public String getDeviceClazz() {
        return this.deviceClazz;
    }

    public String getDeviceNo() {
        return this.deviceNo;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getScreenType() {
        return this.screenType;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public String getUiVersion() {
        return this.uiVersion;
    }

    public void setDeviceClazz(String str) {
        this.deviceClazz = str;
    }

    public void setDeviceNo(String str) {
        this.deviceNo = str;
    }

    public void setScreenHeight(int i3) {
        this.screenHeight = i3;
    }

    public void setScreenType(int i3) {
        this.screenType = i3;
    }

    public void setScreenWidth(int i3) {
        this.screenWidth = i3;
    }

    public void setUiVersion(String str) {
        this.uiVersion = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FirmVersionBean{deviceClazz='");
        sb2.append(this.deviceClazz);
        sb2.append("', deviceNo='");
        return a.f(sb2, this.deviceNo, "'}");
    }
}
