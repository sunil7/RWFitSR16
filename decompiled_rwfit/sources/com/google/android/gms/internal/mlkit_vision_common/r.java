package com.google.android.gms.internal.mlkit_vision_common;

/* loaded from: classes.dex */
public abstract class r {
    public static int a(float f2) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f2);
    }
}
