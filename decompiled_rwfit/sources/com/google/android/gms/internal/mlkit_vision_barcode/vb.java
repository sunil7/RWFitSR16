package com.google.android.gms.internal.mlkit_vision_barcode;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class vb {
    public static void a(Throwable th2, Throwable exception) {
        kotlin.jvm.internal.e.f(th2, "<this>");
        kotlin.jvm.internal.e.f(exception, "exception");
        if (th2 != exception) {
            Integer num = kh.a.f15623a;
            if (num == null || num.intValue() >= 19) {
                th2.addSuppressed(exception);
                return;
            }
            Method method = jh.a.f15449a;
            if (method != null) {
                method.invoke(th2, exception);
            }
        }
    }
}
