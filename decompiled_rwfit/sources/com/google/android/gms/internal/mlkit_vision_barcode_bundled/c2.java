package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class c2 extends l0 implements b1 {
    private static final c2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        c2 c2Var = new c2();
        zzb = c2Var;
        l0.h(c2.class, c2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new c2();
        }
        if (i10 == 4) {
            return new x2(12, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
