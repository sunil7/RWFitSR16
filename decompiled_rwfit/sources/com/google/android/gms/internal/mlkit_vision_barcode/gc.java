package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Color;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class gc {
    public static String a(int i3) {
        Object[] objArr = {Integer.valueOf(Color.red(i3)), Integer.valueOf(Color.green(i3)), Integer.valueOf(Color.blue(i3)), Double.valueOf(Color.alpha(i3) / 255.0d)};
        int i10 = i9.g.f14378a;
        return String.format(Locale.US, "rgba(%d,%d,%d,%.3f)", objArr);
    }
}
