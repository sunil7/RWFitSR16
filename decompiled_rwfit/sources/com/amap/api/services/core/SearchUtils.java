package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.p0003sl.d6;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes.dex */
public class SearchUtils {
    public static String getPkgName(Context context) {
        try {
            return context.getApplicationContext().getPackageName();
        } catch (Throwable th2) {
            d6.a(th2, "SearchUtils", "getPkgName");
            return null;
        }
    }

    public static String getSHA1(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b3 : digest) {
                String upperCase = Integer.toHexString(b3 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            d6.a(th2, "SearchUtils", "getSHA1");
            return null;
        }
    }

    public static String getVersion() {
        return "9.7.4";
    }
}
