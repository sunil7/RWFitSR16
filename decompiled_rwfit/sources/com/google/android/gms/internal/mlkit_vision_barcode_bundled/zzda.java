package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
final class zzda extends zzde {
    private final int zzc;
    private final int zzd;

    public zzda(byte[] bArr, int i3, int i10) {
        super(bArr);
        zzdf.zzo(i3, i3 + i10, bArr.length);
        this.zzc = i3;
        this.zzd = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zza(int i3) {
        zzdf.zzu(i3, this.zzd);
        return ((zzde) this).zza[this.zzc + i3];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zzb(int i3) {
        return ((zzde) this).zza[this.zzc + i3];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zze(byte[] bArr, int i3, int i10, int i11) {
        System.arraycopy(((zzde) this).zza, this.zzc + i3, bArr, i10, i11);
    }
}
