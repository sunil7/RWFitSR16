package com.google.android.gms.internal.mlkit_vision_barcode;

import io.reactivex.exceptions.ProtocolViolationException;

/* loaded from: classes.dex */
public abstract class fd {
    public static void a(Class cls) {
        String name = cls.getName();
        a1.b(new ProtocolViolationException(l0.q("It is not allowed to subscribe with a(n) ", name, " multiple times. Please create a fresh instance of ", name, " and subscribe that to the target source instead.")));
    }
}
