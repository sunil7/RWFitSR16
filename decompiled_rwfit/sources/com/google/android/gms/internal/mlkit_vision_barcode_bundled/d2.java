package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class d2 extends l0 implements b1 {
    private static final d2 zzb;
    private int zzd;
    private String zze = "";
    private int zzf = 1;
    private boolean zzg;
    private int zzh;

    static {
        d2 d2Var = new d2();
        zzb = d2Var;
        l0.h(d2.class, d2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", c.e, "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new d2();
        }
        if (i10 == 4) {
            return new x2(13, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
