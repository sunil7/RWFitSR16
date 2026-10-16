package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.tencent.open.log.SLog;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected static final Uri f11964a = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int d5 = d(context);
        if (d5 == 2) {
            return "wifi";
        }
        if (d5 == 1) {
            return "cmwap";
        }
        if (d5 == 4) {
            return "cmnet";
        }
        if (d5 == 16) {
            return "uniwap";
        }
        if (d5 == 8) {
            return "uninet";
        }
        if (d5 == 64) {
            return "wap";
        }
        if (d5 == 32) {
            return ReportUtil.STATISTICS_LOCTYPE_NET;
        }
        if (d5 == 512) {
            return "ctwap";
        }
        if (d5 == 256) {
            return "ctnet";
        }
        if (d5 == 2048) {
            return "3gnet";
        }
        if (d5 == 1024) {
            return "3gwap";
        }
        String b3 = b(context);
        return (b3 == null || b3.length() == 0) ? "none" : b3;
    }

    public static String b(Context context) {
        return "";
    }

    public static String c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f11964a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            query.close();
            return string;
        } catch (SecurityException e) {
            SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
            return "";
        }
    }

    public static int d(Context context) {
        NetworkInfo e;
        try {
            e = e(context);
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e10.getMessage());
        }
        if (e == null) {
            return 128;
        }
        if (e.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        String lowerCase = e.getExtraInfo().toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith(ReportUtil.STATISTICS_LOCTYPE_NET)) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String c9 = c(context);
                if (c9 != null) {
                    if (c9.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }

    public static NetworkInfo e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }
}
