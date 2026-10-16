package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class g2 extends l0 implements b1 {
    private static final g2 zzb;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        g2 g2Var = new g2();
        zzb = g2Var;
        l0.h(g2.class, g2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", c.f9742j, "zzf"});
        }
        if (i10 == 3) {
            return new g2();
        }
        if (i10 == 4) {
            return new x2(16, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
