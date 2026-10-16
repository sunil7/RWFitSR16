package com.google.android.gms.internal.mlkit_vision_common;

/* loaded from: classes.dex */
public abstract class f0 {
    public static th.a a(th.a aVar, int i3) {
        kotlin.jvm.internal.e.f(aVar, "<this>");
        boolean z5 = i3 > 0;
        Integer valueOf = Integer.valueOf(i3);
        if (z5) {
            if (aVar.f18635c <= 0) {
                i3 = -i3;
            }
            return new th.a(aVar.f18633a, aVar.f18634b, i3);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + valueOf + '.');
    }

    public static th.c b(int i3, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new th.c(i3, i10 - 1, 1);
        }
        th.c cVar = th.c.f18640d;
        return th.c.f18640d;
    }
}
