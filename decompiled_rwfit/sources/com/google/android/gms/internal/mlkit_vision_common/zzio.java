package com.google.android.gms.internal.mlkit_vision_common;

/* loaded from: classes.dex */
public enum zzio implements d {
    SOURCE_UNKNOWN(0),
    BITMAP(1),
    BYTEARRAY(2),
    BYTEBUFFER(3),
    FILEPATH(4),
    ANDROID_MEDIA_IMAGE(5);

    private final int zzh;

    zzio(int i3) {
        this.zzh = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.d
    public final int zza() {
        return this.zzh;
    }
}
