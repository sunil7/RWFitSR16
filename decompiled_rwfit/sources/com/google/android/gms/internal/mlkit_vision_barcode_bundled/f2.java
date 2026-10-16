package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class f2 extends l0 implements b1 {
    private static final f2 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private r0 zzg = h1.f9791d;
    private int zzh;

    static {
        f2 f2Var = new f2();
        zzb = f2Var;
        l0.h(f2.class, f2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002င\u0001\u0003\u001a\u0004င\u0002", new Object[]{"zzd", "zze", c.f9740h, "zzf", "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new f2();
        }
        if (i10 == 4) {
            return new x2(15, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
