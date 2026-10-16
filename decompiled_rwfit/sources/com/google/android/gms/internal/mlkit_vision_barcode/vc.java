package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class vc {
    public static int a(int i3, int i10) {
        for (int i11 = 1; i11 <= 2; i11++) {
            int i12 = (i3 + i11) % 3;
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 == 2 && (i10 & 2) != 0) {
                    }
                } else if ((i10 & 1) == 0) {
                }
            }
            return i12;
        }
        return i3;
    }
}
