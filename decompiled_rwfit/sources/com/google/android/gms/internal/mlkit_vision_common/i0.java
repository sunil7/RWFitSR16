package com.google.android.gms.internal.mlkit_vision_common;

import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class i0 {
    public static androidx.recyclerview.widget.x a(int i3) {
        return new androidx.recyclerview.widget.x(i3, d(i3));
    }

    public static androidx.recyclerview.widget.x b(int i3, int i10, String str) {
        String d5 = d(i3);
        StringBuilder sb2 = new StringBuilder("{\"code\":");
        sb2.append(i3);
        if (!TextUtils.isEmpty(d5)) {
            sb2.append(", \"desc\":\"");
            sb2.append(d5);
            sb2.append("\"");
        }
        sb2.append(", \"sub_code\":");
        sb2.append(i10);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(", \"message\":\"");
            sb2.append(str);
            sb2.append("\"");
        }
        sb2.append("}");
        return new androidx.recyclerview.widget.x(i3, sb2.toString());
    }

    public static androidx.recyclerview.widget.x c(int i3, String str) {
        return TextUtils.isEmpty(str) ? a(i3) : b(i3, 0, str);
    }

    public static String d(int i3) {
        if (i3 == 12295) {
            return "Command waiting for the device to reply timed out.";
        }
        if (i3 == 12296) {
            return "Device returned the failed result.";
        }
        if (i3 == 12298) {
            return "Device returned an error result.";
        }
        if (i3 == 12299) {
            return "Waiting command timeout.";
        }
        if (i3 == 0) {
            return "Success.";
        }
        if (i3 == 4097) {
            return "Parameter error.";
        }
        if (i3 == 4099) {
            return "Bluetooth is close.";
        }
        if (i3 == 4114) {
            return "Bluetooth device is disconnected.";
        }
        if (i3 == 8194) {
            return "Searching for a Device Exception.";
        }
        if (i3 == 20481) {
            return "Device authentication fails.";
        }
        switch (i3) {
            case 12290:
                return "Failed to send data.";
            case 12291:
                return "System is busy.";
            case 12292:
                return "Abnormal data format.";
            case 12293:
                return "Failed to parse data.";
            default:
                switch (i3) {
                    case 16385:
                        return "Update failed.";
                    case 16386:
                        return "Device is in low charge.";
                    case 16387:
                        return "Corrupted upgrade file.";
                    case 16388:
                        return "Data offset error.";
                    case 16389:
                        return "Data verification failure.";
                    case 16390:
                        return "Key of the upgrade file does not match.";
                    case 16391:
                        return "The type of the upgrade file is incorrect.";
                    case 16392:
                        return "OTA is in progress.";
                    case 16393:
                        return "Data length error.";
                    case 16394:
                        return "Flash IO exception.";
                    case 16395:
                        return "Command processing timeout.";
                    case 16396:
                        return "File version is the same as the device version.";
                    case 16397:
                        return "The TWS is not connected.";
                    case 16398:
                        return "The headphones are not in the charging bin.";
                    case 16399:
                        return "Same upgrade file.";
                    case 16400:
                        return "Unknown error code.";
                    case 16401:
                        return "Reconnecting to the device timed out.";
                    case 16402:
                        return "Failed to reconnect the device.";
                    case 16403:
                        return "Device is being upgraded.";
                    case 16404:
                        return "Device is in device dual mode.";
                    default:
                        switch (i3) {
                            case 20484:
                                return "Not found file.";
                            case 20485:
                                return "No upgrade data found.";
                            case 20486:
                                return "I/O exception.";
                            default:
                                return "Unknown Error";
                        }
                }
        }
    }
}
