package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class bb {
    public static void a(int i3, Object[] objArr) {
        for (int i10 = 0; i10 < i3; i10++) {
            if (objArr[i10] == null) {
                throw new NullPointerException(l0.j(i10, "at index "));
            }
        }
    }
}
