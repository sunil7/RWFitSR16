package com.google.android.gms.internal.mlkit_vision_common;

import android.graphics.Color;
import android.view.View;

/* loaded from: classes.dex */
public abstract class x {
    public static int a(int i3, int i10) {
        return c1.a.e(i3, (Color.alpha(i3) * i10) / 255);
    }

    public static int b(int i3, View view) {
        return com.google.android.gms.internal.mlkit_vision_barcode.s0.b(view.getContext(), i3, view.getClass().getCanonicalName());
    }

    public static boolean c(int i3) {
        if (i3 == 0) {
            return false;
        }
        ThreadLocal threadLocal = c1.a.f3353a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int red = Color.red(i3);
        int green = Color.green(i3);
        int blue = Color.blue(i3);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d5 = red / 255.0d;
        double pow = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
        double d8 = green / 255.0d;
        double pow2 = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
        double d10 = blue / 255.0d;
        double pow3 = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * 100.0d;
        double d11 = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * 100.0d;
        dArr[1] = d11;
        dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
        return d11 / 100.0d > 0.5d;
    }

    public static int d(int i3, float f2, int i10) {
        return c1.a.c(c1.a.e(i10, Math.round(Color.alpha(i10) * f2)), i3);
    }
}
