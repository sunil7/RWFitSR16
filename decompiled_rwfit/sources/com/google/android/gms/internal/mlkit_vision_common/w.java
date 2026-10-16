package com.google.android.gms.internal.mlkit_vision_common;

import kotlin.random.Random$Default;

/* loaded from: classes.dex */
public abstract class w {
    public static final String a(Number number, Number number2) {
        return "Random range is empty: [" + number + ", " + number2 + ").";
    }

    public static final int b(Random$Default random$Default, th.c cVar) {
        kotlin.jvm.internal.e.f(random$Default, "<this>");
        if (cVar.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + cVar);
        }
        int i3 = cVar.f18633a;
        int i10 = cVar.f18634b;
        return i10 < Integer.MAX_VALUE ? random$Default.nextInt(i3, i10 + 1) : i3 > Integer.MIN_VALUE ? random$Default.nextInt(i3 - 1, i10) + 1 : random$Default.nextInt();
    }
}
