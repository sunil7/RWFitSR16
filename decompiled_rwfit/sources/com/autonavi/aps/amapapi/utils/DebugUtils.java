package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;

/* loaded from: classes.dex */
public class DebugUtils {
    public static Context sAppContext;

    public static void attachContext(Context context) {
        sAppContext = context;
    }

    public static String getAbsolutePath() {
        Context context = sAppContext;
        return context == null ? "" : context.getExternalFilesDir("").getAbsolutePath();
    }

    public static String getWPath() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getAbsolutePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append(Const.STR_DEBUG_TAG);
        sb2.append(str);
        return sb2.toString();
    }

    public static void printE(Throwable th2) {
    }

    public static void writeCat(String str, boolean z5) {
    }

    public static void writeCatTag(String str, String str2) {
    }

    public static void writeCat(String str, boolean z5, String str2) {
    }

    public static void writeCatTag(String str, String str2, String str3, boolean z5) {
    }

    public static void writeCat(Object... objArr) {
    }
}
