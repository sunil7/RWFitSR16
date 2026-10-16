package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class xd {
    public static void a(int i3) {
        if (new th.c(2, 36, 1).a(i3)) {
            return;
        }
        StringBuilder q5 = android.support.v4.media.session.e.q(i3, "radix ", " was not in valid range ");
        q5.append(new th.c(2, 36, 1));
        throw new IllegalArgumentException(q5.toString());
    }

    public static final boolean b(char c9, char c10, boolean z5) {
        if (c9 == c10) {
            return true;
        }
        if (!z5) {
            return false;
        }
        char upperCase = Character.toUpperCase(c9);
        char upperCase2 = Character.toUpperCase(c10);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }
}
