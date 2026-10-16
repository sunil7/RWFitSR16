package com.google.android.gms.internal.mlkit_vision_barcode;

import kotlin.Result;

/* loaded from: classes.dex */
public abstract class wb {
    public static final void a(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
