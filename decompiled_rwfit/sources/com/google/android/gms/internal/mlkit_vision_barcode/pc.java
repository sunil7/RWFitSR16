package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class pc {
    public static void a(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    public static void c(Object obj) {
        if (obj == null) {
            throw new IllegalStateException();
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throw new IllegalStateException(str);
        }
    }
}
