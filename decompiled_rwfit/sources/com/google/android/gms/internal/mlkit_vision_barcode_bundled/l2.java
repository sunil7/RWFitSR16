package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class l2 extends l0 implements b1 {
    private static final l2 zzb;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        l2 l2Var = new l2();
        zzb = l2Var;
        l0.h(l2.class, l2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", c.f9751t, "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new l2();
        }
        if (i10 == 4) {
            return new x2(21, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
