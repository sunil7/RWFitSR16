package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class a2 extends l0 implements b1 {
    private static final a2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        a2 a2Var = new a2();
        zzb = a2Var;
        l0.h(a2.class, a2Var);
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
            return new a2();
        }
        if (i10 == 4) {
            return new x2(10, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
