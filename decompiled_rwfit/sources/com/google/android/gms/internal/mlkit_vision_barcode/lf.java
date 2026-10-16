package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class lf {
    public static int a(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 90) {
            return 1;
        }
        if (i3 == 180) {
            return 2;
        }
        if (i3 == 270) {
            return 3;
        }
        throw new IllegalArgumentException(l0.j(i3, "Invalid rotation: "));
    }
}
