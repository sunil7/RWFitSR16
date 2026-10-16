package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class SPUtil {
    public static void endEdit(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }

    public static boolean getPrefsBoolean(Context context, String str, String str2, boolean z5) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z5);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "getPrefsBoolean");
            return z5;
        }
    }

    public static int getPrefsInt(Context context, String str, String str2, int i3) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i3);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "getPrefsInt");
            return i3;
        }
    }

    public static long getPrefsLong(Context context, String str, String str2, long j4) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j4);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "getPrefsLong");
            return j4;
        }
    }

    public static String getPrefsStr(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static String getSmac(Context context) {
        return context == null ? Const.STR_DEF_SMAC : getPrefsStr(context, Const.STR_PREF, Const.STR_PREF_KEY_SMAC, Const.STR_DEF_SMAC);
    }

    public static void removeKeyData(SharedPreferences.Editor editor, String str) {
        try {
            editor.remove(str);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "setPrefsLong");
        }
    }

    public static void setPrefsBoolean(SharedPreferences.Editor editor, String str, boolean z5) {
        try {
            editor.putBoolean(str, z5);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "updatePrefsBoolean");
        }
    }

    public static void setPrefsInt(SharedPreferences.Editor editor, String str, int i3) {
        try {
            editor.putInt(str, i3);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "setPrefsInt");
        }
    }

    public static void setPrefsLong(SharedPreferences.Editor editor, String str, long j4) {
        try {
            editor.putLong(str, j4);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "setPrefsLong");
        }
    }

    public static void setPrefsStr(SharedPreferences.Editor editor, String str, String str2) {
        try {
            editor.putString(str, str2);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "SpUtil", "setPrefsStr");
        }
    }

    public static SharedPreferences.Editor startEdit(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }
}
