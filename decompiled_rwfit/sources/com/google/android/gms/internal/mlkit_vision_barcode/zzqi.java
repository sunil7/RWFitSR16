package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public enum zzqi implements i0 {
    UNKNOWN_FORMAT(0),
    NV16(1),
    NV21(2),
    YV12(3),
    YUV_420_888(7),
    JPEG(8),
    BITMAP(4),
    CM_SAMPLE_BUFFER_REF(5),
    UI_IMAGE(6),
    CV_PIXEL_BUFFER_REF(9);

    private final int zzl;

    zzqi(int i3) {
        this.zzl = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.i0
    public final int zza() {
        return this.zzl;
    }
}
