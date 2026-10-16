package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Closeable;

/* loaded from: classes.dex */
public abstract class ke {
    public static final void a(Closeable closeable, Throwable th2) {
        if (closeable != null) {
            if (th2 == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th3) {
                vb.a(th2, th3);
            }
        }
    }
}
