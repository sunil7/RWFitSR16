package com.google.android.gms.internal.mlkit_vision_common;

/* loaded from: classes.dex */
public abstract class e0 {
    public static float a(float f2, float f10, float f11, float f12) {
        double d5 = f2 - f11;
        double d8 = f10 - f12;
        return (float) Math.sqrt((d8 * d8) + (d5 * d5));
    }

    public static float b(int i3, int i10, int i11, int i12) {
        double d5 = i3 - i11;
        double d8 = i10 - i12;
        return (float) Math.sqrt((d8 * d8) + (d5 * d5));
    }

    public static int c(float f2) {
        return (int) (f2 + (f2 < 0.0f ? -0.5f : 0.5f));
    }

    public static int d(int[] iArr) {
        int i3 = 0;
        for (int i10 : iArr) {
            i3 += i10;
        }
        return i3;
    }
}
