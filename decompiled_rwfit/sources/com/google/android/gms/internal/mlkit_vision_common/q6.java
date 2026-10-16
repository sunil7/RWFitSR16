package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class q6 {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f10086a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f10087b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f10088c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f10089d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f10086a == null) {
            f10086a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f10086a.booleanValue();
    }

    public static boolean b(Context context) {
        a(context);
        if (f10087b == null) {
            f10087b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f10087b.booleanValue() && Build.VERSION.SDK_INT >= 30;
    }
}
