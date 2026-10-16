package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class n {
    public static String a(int i3) {
        if (i3 == 0) {
            return "CONNECTION_DISCONNECT(0)";
        }
        if (i3 == 1) {
            return "CONNECTION_OK(1)";
        }
        if (i3 == 2) {
            return "CONNECTION_FAILED(2)";
        }
        if (i3 == 3) {
            return "CONNECTION_CONNECTING(3)";
        }
        if (i3 == 4) {
            return "CONNECTION_CONNECTED(4)";
        }
        Locale locale = Locale.ENGLISH;
        return com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "UNKNOWN STATE(", ")");
    }
}
