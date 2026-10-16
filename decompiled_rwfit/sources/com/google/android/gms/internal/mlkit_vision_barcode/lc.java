package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class lc {

    /* renamed from: a, reason: collision with root package name */
    public static long f9407a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f9408b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f9409c;

    public static void a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 29) {
            return i2.a.a();
        }
        try {
            if (f9408b == null) {
                f9407a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f9408b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f9408b.invoke(null, Long.valueOf(f9407a))).booleanValue();
        } catch (Exception e) {
            a("isTagEnabled", e);
            return false;
        }
    }

    public static void c(int i3, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            i2.a.b(i3, d(str));
            return;
        }
        String d5 = d(str);
        try {
            if (f9409c == null) {
                f9409c = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            f9409c.invoke(null, Long.valueOf(f9407a), d5, Integer.valueOf(i3));
        } catch (Exception e) {
            a("traceCounter", e);
        }
    }

    public static String d(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
