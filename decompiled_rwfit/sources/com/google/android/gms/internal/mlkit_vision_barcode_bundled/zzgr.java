package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class zzgr extends RuntimeException {
    public zzgr(a1 a1Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzer zza() {
        return new zzer(getMessage());
    }
}
