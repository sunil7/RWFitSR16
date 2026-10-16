package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;

/* loaded from: classes.dex */
public class SystemApiWrapper {
    public static String getBSSID(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getBSSID();
    }

    public static int getRssi(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return -1;
        }
        return wifiInfo.getRssi();
    }

    public static String getSSID(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getSSID();
    }
}
