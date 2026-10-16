package com.google.android.gms.internal.mlkit_vision_common;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f9862a = 3;

    public static void a(String str, String str2) {
        if (d(3, str)) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (d(6, str)) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th2) {
        if (d(6, str)) {
            Log.e(str, str2, th2);
        }
    }

    public static boolean d(int i3, String str) {
        return f9862a <= i3 || Log.isLoggable(str, i3);
    }

    public static void e(String str, String str2) {
        if (d(5, str)) {
            Log.w(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th2) {
        if (d(5, str)) {
            Log.w(str, str2, th2);
        }
    }
}
