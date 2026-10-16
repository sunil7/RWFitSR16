package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
class zzde extends zzdd {
    protected final byte[] zza;

    public zzde(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdf) || zzd() != ((zzdf) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzde)) {
            return obj.equals(this);
        }
        zzde zzdeVar = (zzde) obj;
        int zzp = zzp();
        int zzp2 = zzdeVar.zzp();
        if (zzp == 0 || zzp2 == 0 || zzp == zzp2) {
            return zzg(zzdeVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public byte zza(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public byte zzb(int i3) {
        return this.zza[i3];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public void zze(byte[] bArr, int i3, int i10, int i11) {
        System.arraycopy(this.zza, i3, bArr, i10, i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdd
    public final boolean zzg(zzdf zzdfVar, int i3, int i10) {
        if (i10 > zzdfVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i10 + zzd());
        }
        int i11 = i3 + i10;
        if (i11 > zzdfVar.zzd()) {
            int zzd = zzdfVar.zzd();
            StringBuilder s7 = com.google.android.gms.internal.mlkit_vision_barcode.l0.s(i3, "Ran off end of other: ", i10, ", ", ", ");
            s7.append(zzd);
            throw new IllegalArgumentException(s7.toString());
        }
        if (!(zzdfVar instanceof zzde)) {
            return zzdfVar.zzk(i3, i11).equals(zzk(0, i10));
        }
        zzde zzdeVar = (zzde) zzdfVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzdeVar.zza;
        int zzc = zzc() + i10;
        int zzc2 = zzc();
        int zzc3 = zzdeVar.zzc() + i3;
        while (zzc2 < zzc) {
            if (bArr[zzc2] != bArr2[zzc3]) {
                return false;
            }
            zzc2++;
            zzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzi(int i3, int i10, int i11) {
        int zzc = zzc() + i10;
        byte[] bArr = this.zza;
        Charset charset = s0.f9827a;
        for (int i12 = zzc; i12 < zzc + i11; i12++) {
            i3 = (i3 * 31) + bArr[i12];
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzj(int i3, int i10, int i11) {
        int zzc = zzc() + i10;
        byte[] bArr = this.zza;
        y1.f9849a.getClass();
        return g0.c(i3, bArr, zzc, i11 + zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final zzdf zzk(int i3, int i10) {
        int zzo = zzdf.zzo(i3, i10, zzd());
        return zzo == 0 ? zzdf.zzb : new zzda(this.zza, zzc() + i3, zzo);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final String zzl(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zzm(u uVar) throws IOException {
        ((z) uVar).d(zzc(), zzd(), this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzn() {
        int zzc = zzc();
        int zzd = zzd() + zzc;
        byte[] bArr = this.zza;
        y1.f9849a.getClass();
        return g0.c(0, bArr, zzc, zzd) == 0;
    }
}
