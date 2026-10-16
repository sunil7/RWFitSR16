package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class b2 extends l0 implements b1 {
    private static final b2 zzb;
    private int zzd;
    private int zze = -1;

    static {
        b2 b2Var = new b2();
        zzb = b2Var;
        l0.h(b2.class, b2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i10 == 3) {
            return new b2();
        }
        if (i10 == 4) {
            return new x2(11, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
