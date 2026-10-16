package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class kb {
    public static String a(int i3, int i10, String str) {
        if (i3 < 0) {
            return lb.a("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i10 >= 0) {
            return lb.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i10));
        }
        throw new IllegalArgumentException(l0.j(i10, "negative size: "));
    }

    public static void b(String str, int i3, boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException(lb.a(str, Integer.valueOf(i3)));
        }
    }

    public static void c(String str, boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void d(int i3, int i10) {
        String a3;
        if (i3 < 0 || i3 >= i10) {
            if (i3 < 0) {
                a3 = lb.a("%s (%s) must not be negative", "index", Integer.valueOf(i3));
            } else {
                if (i10 < 0) {
                    throw new IllegalArgumentException(l0.j(i10, "negative size: "));
                }
                a3 = lb.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(a3);
        }
    }

    public static void e(int i3, int i10) {
        if (i3 < 0 || i3 > i10) {
            throw new IndexOutOfBoundsException(a(i3, i10, "index"));
        }
    }

    public static void f(int i3, int i10, int i11) {
        if (i3 < 0 || i10 < i3 || i10 > i11) {
            throw new IndexOutOfBoundsException((i3 < 0 || i3 > i11) ? a(i3, i11, "start index") : (i10 < 0 || i10 > i11) ? a(i10, i11, "end index") : lb.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i10), Integer.valueOf(i3)));
        }
    }
}
