package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
final class zzgd extends zzdf {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, SubsamplingScaleImageView.TILE_SIZE_AUTO};
    private final int zzc;
    private final zzdf zzd;
    private final zzdf zze;
    private final int zzf;
    private final int zzg;

    public static int zzc(int i3) {
        int[] iArr = zza;
        int length = iArr.length;
        return i3 >= 47 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : iArr[i3];
    }

    public static zzdf zzy(zzdf zzdfVar, zzdf zzdfVar2) {
        if (zzdfVar2.zzd() == 0) {
            return zzdfVar;
        }
        if (zzdfVar.zzd() == 0) {
            return zzdfVar2;
        }
        int zzd = zzdfVar2.zzd() + zzdfVar.zzd();
        if (zzd < 128) {
            int zzd2 = zzdfVar.zzd();
            int zzd3 = zzdfVar2.zzd();
            byte[] bArr = new byte[zzd2 + zzd3];
            zzdfVar.zzv(bArr, 0, 0, zzd2);
            zzdfVar2.zzv(bArr, 0, zzd2, zzd3);
            return new zzde(bArr);
        }
        if (zzdfVar instanceof zzgd) {
            zzgd zzgdVar = (zzgd) zzdfVar;
            if (zzdfVar2.zzd() + zzgdVar.zze.zzd() < 128) {
                zzdf zzdfVar3 = zzgdVar.zze;
                int zzd4 = zzdfVar3.zzd();
                int zzd5 = zzdfVar2.zzd();
                byte[] bArr2 = new byte[zzd4 + zzd5];
                zzdfVar3.zzv(bArr2, 0, 0, zzd4);
                zzdfVar2.zzv(bArr2, 0, zzd4, zzd5);
                return new zzgd(zzgdVar.zzd, new zzde(bArr2));
            }
            if (zzgdVar.zzd.zzf() > zzgdVar.zze.zzf() && zzgdVar.zzg > zzdfVar2.zzf()) {
                return new zzgd(zzgdVar.zzd, new zzgd(zzgdVar.zze, zzdfVar2));
            }
        }
        if (zzd >= zzc(Math.max(zzdfVar.zzf(), zzdfVar2.zzf()) + 1)) {
            return new zzgd(zzdfVar, zzdfVar2);
        }
        x0 x0Var = new x0(1);
        x0Var.c(zzdfVar);
        x0Var.c(zzdfVar2);
        ArrayDeque arrayDeque = (ArrayDeque) x0Var.f9840a;
        zzdf zzdfVar4 = (zzdf) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            zzdfVar4 = new zzgd((zzdf) arrayDeque.pop(), zzdfVar4);
        }
        return zzdfVar4;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdf) {
            zzdf zzdfVar = (zzdf) obj;
            if (this.zzc == zzdfVar.zzd()) {
                if (this.zzc == 0) {
                    return true;
                }
                int zzp = zzp();
                int zzp2 = zzdfVar.zzp();
                if (zzp == 0 || zzp2 == 0 || zzp == zzp2) {
                    k1 k1Var = new k1(this);
                    zzdd a3 = k1Var.a();
                    k1 k1Var2 = new k1(zzdfVar);
                    zzdd a10 = k1Var2.a();
                    int i3 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        int zzd = a3.zzd() - i3;
                        int zzd2 = a10.zzd() - i10;
                        int min = Math.min(zzd, zzd2);
                        if (!(i3 == 0 ? a3.zzg(a10, i10, min) : a10.zzg(a3, i3, min))) {
                            break;
                        }
                        i11 += min;
                        int i12 = this.zzc;
                        if (i11 >= i12) {
                            if (i11 == i12) {
                                return true;
                            }
                            throw new IllegalStateException();
                        }
                        if (min == zzd) {
                            i3 = 0;
                            a3 = k1Var.a();
                        } else {
                            i3 += min;
                            a3 = a3;
                        }
                        if (min == zzd2) {
                            a10 = k1Var2.a();
                            i10 = 0;
                        } else {
                            i10 += min;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new j1(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zza(int i3) {
        zzdf.zzu(i3, this.zzc);
        return zzb(i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zzb(int i3) {
        int i10 = this.zzf;
        return i3 < i10 ? this.zzd.zzb(i3) : this.zze.zzb(i3 - i10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zze(byte[] bArr, int i3, int i10, int i11) {
        int i12 = i3 + i11;
        int i13 = this.zzf;
        if (i12 <= i13) {
            this.zzd.zze(bArr, i3, i10, i11);
        } else {
            if (i3 >= i13) {
                this.zze.zze(bArr, i3 - i13, i10, i11);
                return;
            }
            int i14 = i13 - i3;
            this.zzd.zze(bArr, i3, i10, i14);
            this.zze.zze(bArr, 0, i10 + i14, i11 - i14);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzi(int i3, int i10, int i11) {
        int i12 = i10 + i11;
        int i13 = this.zzf;
        if (i12 <= i13) {
            return this.zzd.zzi(i3, i10, i11);
        }
        if (i10 >= i13) {
            return this.zze.zzi(i3, i10 - i13, i11);
        }
        int i14 = i13 - i10;
        return this.zze.zzi(this.zzd.zzi(i3, i10, i14), 0, i11 - i14);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzj(int i3, int i10, int i11) {
        int i12 = i10 + i11;
        int i13 = this.zzf;
        if (i12 <= i13) {
            return this.zzd.zzj(i3, i10, i11);
        }
        if (i10 >= i13) {
            return this.zze.zzj(i3, i10 - i13, i11);
        }
        int i14 = i13 - i10;
        return this.zze.zzj(this.zzd.zzj(i3, i10, i14), 0, i11 - i14);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final zzdf zzk(int i3, int i10) {
        int zzo = zzdf.zzo(i3, i10, this.zzc);
        if (zzo == 0) {
            return zzdf.zzb;
        }
        if (zzo == this.zzc) {
            return this;
        }
        int i11 = this.zzf;
        if (i10 <= i11) {
            return this.zzd.zzk(i3, i10);
        }
        if (i3 >= i11) {
            return this.zze.zzk(i3 - i11, i10 - i11);
        }
        zzdf zzdfVar = this.zzd;
        return new zzgd(zzdfVar.zzk(i3, zzdfVar.zzd()), this.zze.zzk(0, i10 - this.zzf));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final String zzl(Charset charset) {
        return new String(zzw(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zzm(u uVar) throws IOException {
        this.zzd.zzm(uVar);
        this.zze.zzm(uVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzn() {
        zzdf zzdfVar = this.zzd;
        zzdf zzdfVar2 = this.zze;
        return zzdfVar2.zzj(zzdfVar.zzj(0, 0, this.zzf), 0, zzdfVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    /* renamed from: zzq */
    public final x iterator() {
        return new j1(this);
    }

    public zzgd(zzdf zzdfVar, zzdf zzdfVar2) {
        this.zzd = zzdfVar;
        this.zze = zzdfVar2;
        int zzd = zzdfVar.zzd();
        this.zzf = zzd;
        this.zzc = zzdfVar2.zzd() + zzd;
        this.zzg = Math.max(zzdfVar.zzf(), zzdfVar2.zzf()) + 1;
    }
}
