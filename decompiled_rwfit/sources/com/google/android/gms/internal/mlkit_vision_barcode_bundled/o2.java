package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class o2 extends l0 implements b1 {
    private static final o2 zzb;
    private int zzd;
    private String zze = "";
    private r2 zzf;

    static {
        o2 o2Var = new o2();
        zzb = o2Var;
        l0.h(o2.class, o2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new o2();
        }
        if (i10 == 4) {
            return new x2(23, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
