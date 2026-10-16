package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.utils.Utils;

/* loaded from: classes.dex */
public class WifiInfoWrapper {

    /* renamed from: a, reason: collision with root package name */
    private WifiInfo f6704a;

    /* renamed from: b, reason: collision with root package name */
    private String f6705b;

    /* renamed from: c, reason: collision with root package name */
    private String f6706c;

    /* renamed from: d, reason: collision with root package name */
    private int f6707d = -1;

    public WifiInfoWrapper(WifiInfo wifiInfo) {
        this.f6704a = wifiInfo;
    }

    public String getBSSID() {
        if (this.f6706c == null) {
            this.f6706c = SystemApiWrapper.getBSSID(this.f6704a);
        }
        return this.f6706c;
    }

    public WifiInfo getOrigin() {
        return this.f6704a;
    }

    public int getRssi() {
        if (this.f6707d == -1) {
            this.f6707d = SystemApiWrapper.getRssi(this.f6704a);
        }
        return this.f6707d;
    }

    public String getSSID() {
        if (this.f6705b == null) {
            this.f6705b = SystemApiWrapper.getSSID(this.f6704a);
        }
        return this.f6705b;
    }

    public boolean isUseFul() {
        return (this.f6704a == null || TextUtils.isEmpty(getSSID()) || !Utils.wifiUseful(getBSSID())) ? false : true;
    }

    public WifiInfoWrapper(WifiInfo wifiInfo, String str, String str2) {
        this.f6704a = wifiInfo;
        this.f6705b = str;
        this.f6706c = str2;
    }
}
