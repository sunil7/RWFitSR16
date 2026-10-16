package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class pd {
    public static void a(String str, boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(str));
        }
    }

    public static void b(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(int i3, String str, int i10, int i11) {
        if (i3 < i10) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i10 + ", " + i11 + "] (too low)");
        }
        if (i3 <= i11) {
            return;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i10 + ", " + i11 + "] (too high)");
    }

    public static void d(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(str));
        }
    }

    public static void f(String str, boolean z5) {
        if (!z5) {
            throw new IllegalStateException(str);
        }
    }
}
