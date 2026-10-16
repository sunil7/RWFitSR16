package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class c3 extends l0 implements b1 {
    private static final c3 zzb;
    private int zzd;
    private a zze;

    static {
        c3 c3Var = new c3();
        zzb = c3Var;
        l0.h(c3.class, c3Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0001\u0000\u0001\u000f\u000f\u0001\u0000\u0000\u0000\u000fဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i10 == 3) {
            return new c3();
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
