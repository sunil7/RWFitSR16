package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Build;
import android.view.Window;

/* loaded from: classes.dex */
public abstract class ce {
    public static void a(Window window) {
        if (Build.VERSION.SDK_INT >= 30) {
            l1.j1.a(window, false);
        } else {
            l1.i1.a(window, false);
        }
    }
}
