package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class ub {

    /* renamed from: a, reason: collision with root package name */
    public static WeakReference f9549a;

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return context != null && a1.g.a(context, "android.permission.BLUETOOTH_CONNECT") == 0;
        }
        return true;
    }
}
