package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Set;

/* loaded from: classes.dex */
public abstract class dg {

    /* renamed from: a, reason: collision with root package name */
    public static com.google.android.gms.internal.mlkit_common.l f9275a;

    public static synchronized ag e(String str) {
        ag agVar;
        synchronized (dg.class) {
            byte b3 = (byte) (((byte) (0 | 1)) | 2);
            if (b3 != 3) {
                StringBuilder sb2 = new StringBuilder();
                if ((b3 & 1) == 0) {
                    sb2.append(" enableFirelog");
                }
                if ((b3 & 2) == 0) {
                    sb2.append(" firelogEventType");
                }
                throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
            }
            tf tfVar = new tf(str, 1);
            synchronized (dg.class) {
                try {
                    if (f9275a == null) {
                        f9275a = new com.google.android.gms.internal.mlkit_common.l(1);
                    }
                    agVar = (ag) f9275a.e(tfVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return agVar;
        }
        return agVar;
    }

    public Object a(Class cls) {
        vb.a b3 = b(cls);
        if (b3 == null) {
            return null;
        }
        return b3.get();
    }

    public abstract vb.a b(Class cls);

    public Set c(Class cls) {
        return (Set) d(cls).get();
    }

    public abstract vb.a d(Class cls);
}
