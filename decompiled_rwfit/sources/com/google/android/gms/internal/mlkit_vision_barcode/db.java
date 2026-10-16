package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class db {
    public static boolean a() {
        String str = Build.MANUFACTURER;
        Locale locale = Locale.ENGLISH;
        return str.toLowerCase(locale).equals("lge") || str.toLowerCase(locale).equals("samsung");
    }
}
