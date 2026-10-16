package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.wa;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zzdf implements Iterable, Serializable {
    public static final zzdf zzb = new zzde(s0.f9828b);
    private int zza = 0;

    static {
        int i3 = r.f9821a;
    }

    public static zzdf a(Iterator it, int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "length (", ") must be >= 1"));
        }
        if (i3 == 1) {
            return (zzdf) it.next();
        }
        int i10 = i3 >>> 1;
        zzdf a3 = a(it, i10);
        zzdf a10 = a(it, i3 - i10);
        if (SubsamplingScaleImageView.TILE_SIZE_AUTO - a3.zzd() >= a10.zzd()) {
            return zzgd.zzy(a3, a10);
        }
        throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(a3.zzd(), a10.zzd(), "ByteString would be too long: ", "+"));
    }

    public static int zzo(int i3, int i10, int i11) {
        int i12 = i10 - i3;
        if ((i3 | i10 | i12 | (i11 - i10)) >= 0) {
            return i12;
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "Beginning index: ", " < 0"));
        }
        if (i10 < i3) {
            throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i3, i10, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i10, i11, "End index: ", " >= "));
    }

    public static zzdf zzr(byte[] bArr, int i3, int i10) {
        zzo(i3, i3 + i10, bArr.length);
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i3, bArr2, 0, i10);
        return new zzde(bArr2);
    }

    public static zzdf zzs(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i3 = 256;
        while (true) {
            byte[] bArr = new byte[i3];
            int i10 = 0;
            while (i10 < i3) {
                int read = inputStream.read(bArr, i10, i3 - i10);
                if (read == -1) {
                    break;
                }
                i10 += read;
            }
            zzdf zzr = i10 == 0 ? null : zzr(bArr, 0, i10);
            if (zzr == null) {
                break;
            }
            arrayList.add(zzr);
            i3 = Math.min(i3 + i3, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : a(arrayList.iterator(), size);
    }

    public static void zzu(int i3, int i10) {
        if (((i10 - (i3 + 1)) | i3) < 0) {
            if (i3 >= 0) {
                throw new ArrayIndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i3, i10, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "Index < 0: "));
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i3 = this.zza;
        if (i3 == 0) {
            int zzd = zzd();
            i3 = zzi(zzd, 0, zzd);
            if (i3 == 0) {
                i3 = 1;
            }
            this.zza = i3;
        }
        return i3;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int zzd = zzd();
        String a3 = zzd() <= 50 ? wa.a(this) : wa.a(zzk(0, 47)).concat("...");
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(zzd);
        sb2.append(" contents=\"");
        return r5.a.f(sb2, a3, "\">");
    }

    public abstract byte zza(int i3);

    public abstract byte zzb(int i3);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i3, int i10, int i11);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i3, int i10, int i11);

    public abstract int zzj(int i3, int i10, int i11);

    public abstract zzdf zzk(int i3, int i10);

    public abstract String zzl(Charset charset);

    public abstract void zzm(u uVar) throws IOException;

    public abstract boolean zzn();

    public final int zzp() {
        return this.zza;
    }

    @Override // java.lang.Iterable
    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public x iterator() {
        return new v(this);
    }

    public final String zzt() {
        return zzd() == 0 ? "" : zzl(s0.f9827a);
    }

    @Deprecated
    public final void zzv(byte[] bArr, int i3, int i10, int i11) {
        zzo(0, i11, zzd());
        zzo(i10, i10 + i11, bArr.length);
        if (i11 > 0) {
            zze(bArr, 0, i10, i11);
        }
    }

    public final byte[] zzw() {
        int zzd = zzd();
        if (zzd == 0) {
            return s0.f9828b;
        }
        byte[] bArr = new byte[zzd];
        zze(bArr, 0, 0, zzd);
        return bArr;
    }
}
