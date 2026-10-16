package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class e2 extends l0 implements b1 {
    private static final e2 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh = 2;

    static {
        e2 e2Var = new e2();
        zzb = e2Var;
        l0.h(e2.class, e2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", c.f9738f, "zzf", "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new e2();
        }
        if (i10 == 4) {
            return new x2(14, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
