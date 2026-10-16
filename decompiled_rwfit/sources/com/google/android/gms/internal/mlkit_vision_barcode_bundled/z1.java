package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class z1 extends l0 implements b1 {
    private static final z1 zzb;
    private int zzd;
    private int zze;
    private u2 zzf;
    private o2 zzg;
    private p2 zzh;

    static {
        z1 z1Var = new z1();
        zzb = z1Var;
        l0.h(z1.class, z1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zzd", "zze", c.f9746n, "zzf", "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new z1();
        }
        if (i10 == 4) {
            return new x2(9, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
