package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class kd {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9382a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Method f9383b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9384c;

    public static void a(ViewGroup viewGroup, boolean z5) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z5);
        } else if (f9382a) {
            try {
                viewGroup.suppressLayout(z5);
            } catch (NoSuchMethodError unused) {
                f9382a = false;
            }
        }
    }
}
