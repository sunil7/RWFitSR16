package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class b3 extends l0 implements b1 {
    private static final b3 zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private y2 zzg;
    private byte zzh = 2;

    static {
        b3 b3Var = new b3();
        zzb = b3Var;
        l0.h(b3.class, b3Var);
        y2 n4 = y2.n();
        zzhf zzhfVar = zzhf.zza;
        if (n4 == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔅ\u0000\u0002ᔅ\u0001\u0003ᐉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new b3();
        }
        if (i10 == 4) {
            return new v2(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzh = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
