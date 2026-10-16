package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class w2 extends l0 implements b1 {
    private static final w2 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";

    static {
        w2 w2Var = new w2();
        zzb = w2Var;
        l0.h(w2.class, w2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", c.f9754w, "zzg"});
        }
        if (i10 == 3) {
            return new w2();
        }
        if (i10 == 4) {
            return new v2(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
