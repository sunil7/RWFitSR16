package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* loaded from: classes.dex */
public final class zzdl extends IOException {
    public zzdl() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzdl(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    public zzdl(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
