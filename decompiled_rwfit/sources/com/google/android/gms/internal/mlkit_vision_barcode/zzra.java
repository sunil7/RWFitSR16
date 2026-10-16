package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public enum zzra implements i0 {
    TYPE_UNKNOWN(0),
    TYPE_THIN(1),
    TYPE_THICK(2),
    TYPE_GMV(3);

    private final int zzf;

    zzra(int i3) {
        this.zzf = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.i0
    public final int zza() {
        return this.zzf;
    }
}
