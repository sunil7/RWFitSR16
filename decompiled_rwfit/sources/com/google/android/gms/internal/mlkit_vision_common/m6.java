package com.google.android.gms.internal.mlkit_vision_common;

/* loaded from: classes.dex */
public abstract class m6 {
    public static float a(float f2, float f10, float f11, float f12) {
        double d5 = 0.0f - f2;
        double d8 = 0.0f - f10;
        float hypot = (float) Math.hypot(d5, d8);
        double d10 = f11 - f2;
        float hypot2 = (float) Math.hypot(d10, d8);
        double d11 = f12 - f10;
        float hypot3 = (float) Math.hypot(d10, d11);
        float hypot4 = (float) Math.hypot(d5, d11);
        return (hypot <= hypot2 || hypot <= hypot3 || hypot <= hypot4) ? (hypot2 <= hypot3 || hypot2 <= hypot4) ? hypot3 > hypot4 ? hypot3 : hypot4 : hypot2 : hypot;
    }
}
