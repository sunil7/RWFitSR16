package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class ic {
    public static boolean a() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            return true;
        }
        if (i3 < 30) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        if ("REL".equals(str)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str.toUpperCase(locale).compareTo("S".toUpperCase(locale)) >= 0;
    }

    public static boolean b() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            return true;
        }
        if (i3 < 32) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        if ("REL".equals(str)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str.toUpperCase(locale).compareTo("Tiramisu".toUpperCase(locale)) >= 0;
    }
}
