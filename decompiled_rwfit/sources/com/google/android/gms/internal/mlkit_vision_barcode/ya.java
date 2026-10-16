package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class ya {
    public static void a(int i3, int i10) {
        String a3;
        if (i3 < 0 || i3 >= i10) {
            if (i3 < 0) {
                a3 = za.a("%s (%s) must not be negative", "index", Integer.valueOf(i3));
            } else {
                if (i10 < 0) {
                    throw new IllegalArgumentException(l0.j(i10, "negative size: "));
                }
                a3 = za.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(a3);
        }
    }

    public static void b(int i3, int i10, int i11) {
        if (i3 < 0 || i10 < i3 || i10 > i11) {
            throw new IndexOutOfBoundsException((i3 < 0 || i3 > i11) ? c(i3, i11, "start index") : (i10 < 0 || i10 > i11) ? c(i10, i11, "end index") : za.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i10), Integer.valueOf(i3)));
        }
    }

    public static String c(int i3, int i10, String str) {
        if (i3 < 0) {
            return za.a("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i10 >= 0) {
            return za.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i10));
        }
        throw new IllegalArgumentException(l0.j(i10, "negative size: "));
    }
}
