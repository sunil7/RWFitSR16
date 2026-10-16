package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class t2 extends l0 implements b1 {
    private static final t2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        t2 t2Var = new t2();
        zzb = t2Var;
        l0.h(t2.class, t2Var);
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
            return new t2();
        }
        if (i10 == 4) {
            return new x2(28, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
