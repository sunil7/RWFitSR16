package com.bumptech.glide;

import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public abstract class e {
    public static float a(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return androidx.core.widget.f.b(edgeEffect);
        }
        return 0.0f;
    }

    public static float b(EdgeEffect edgeEffect, float f2, float f10) {
        if (Build.VERSION.SDK_INT >= 31) {
            return androidx.core.widget.f.c(edgeEffect, f2, f10);
        }
        androidx.core.widget.e.a(edgeEffect, f2, f10);
        return f2;
    }
}
