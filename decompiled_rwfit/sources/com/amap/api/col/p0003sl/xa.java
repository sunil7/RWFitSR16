package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class xa {

    /* renamed from: a, reason: collision with root package name */
    static byte[] f5406a;

    /* renamed from: b, reason: collision with root package name */
    static byte[] f5407b;

    public static void a(Context context, String str, String str2, String str3) {
        byte[] bArr;
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            try {
                bArr = h9.c(a(context), n9.e(str3), b(context));
            } catch (Throwable unused) {
                bArr = new byte[0];
            }
            edit.putString(str2, n9.b(bArr));
            a(edit);
        } catch (Throwable unused2) {
        }
    }

    public static byte[] b(Context context, byte[] bArr) {
        try {
            return h9.b(a(context), bArr, b(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    private static byte[] b(Context context) {
        byte[] bArr = f5407b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] copyOfRange = Arrays.copyOfRange(a(context), 0, a(context).length / 2);
        f5407b = copyOfRange;
        return copyOfRange;
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th2) {
            ka.a(th2, "csp", "gsv");
            return str3;
        }
    }

    public static byte[] a(Context context, byte[] bArr) {
        try {
            return h9.c(a(context), bArr, b(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    private static byte[] a(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f5406a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = b9.e(context).getBytes();
        f5406a = bytes;
        return bytes;
    }

    public static String a(Context context, String str, String str2) {
        byte[] bArr;
        try {
            try {
                bArr = h9.b(a(context), n9.c(context.getSharedPreferences(str, 0).getString(str2, "")), b(context));
            } catch (Exception unused) {
                bArr = new byte[0];
            }
            return n9.c(bArr);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static SharedPreferences.Editor a(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th2) {
                ga.a(th2, "sp", "ge");
            }
        }
        return null;
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th2) {
            ga.a(th2, "sp", "cm");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z5) {
        try {
            editor.putBoolean(str, z5);
        } catch (Throwable th2) {
            ka.a(th2, "csp", "setPrefsStr");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i3) {
        try {
            editor.putInt(str, i3);
        } catch (Throwable th2) {
            ka.a(th2, "csp", "putPrefsInt");
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z5) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z5);
        } catch (Throwable th2) {
            ka.a(th2, "csp", "gbv");
            return z5;
        }
    }

    public static int a(Context context, String str, String str2, int i3) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i3);
        } catch (Throwable th2) {
            ka.a(th2, "csp", "giv");
            return i3;
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, long j4) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j4);
        } catch (Throwable th2) {
            ka.a(th2, "csp", "plv");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th2) {
                ga.a(th2, "sp", "ps");
            }
        }
    }
}
