package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class w1 {

    /* renamed from: a, reason: collision with root package name */
    public static long f9571a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z5 = currentTimeMillis - f9571a < 1000;
        f9571a = currentTimeMillis;
        return z5;
    }
}
