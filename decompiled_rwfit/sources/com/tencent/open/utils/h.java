package com.tencent.open.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;

/* loaded from: classes2.dex */
public class h {
    public static String a(Context context, String str, String str2) {
        if (context != null && str2 != null && str != null) {
            if ("com.tencent.mobileqq".equals(str2)) {
                return b(context, str, "com.tencent.mobileqq");
            }
            if (Constants.PACKAGE_TIM.equals(str2)) {
                return b(context, str, Constants.PACKAGE_TIM);
            }
        }
        return null;
    }

    private static String b(Context context, String str, String str2) {
        try {
            Cursor c9 = c(context, str, str2);
            if (c9 == null) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");
                return null;
            }
            if (c9.getCount() <= 0) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");
                return null;
            }
            c9.moveToFirst();
            String string = c9.getString(0);
            c9.close();
            SLog.i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + string);
            return a(string) ? string : Constants.APP_VERSION_UNKNOWN;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e);
            return null;
        }
    }

    private static Cursor c(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            return context.getContentResolver().query(Uri.parse("content://" + str2 + ".openapi.provider/query_app_version?appid=" + str + "&pkgName=" + context.getPackageName()), new String[0], null, null, null);
        } catch (Exception e) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e);
            return null;
        }
    }

    private static boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return false;
        }
        for (String str2 : split) {
            try {
                Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }
}
