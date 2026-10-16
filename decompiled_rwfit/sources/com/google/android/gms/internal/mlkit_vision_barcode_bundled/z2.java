package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class z2 extends l0 implements b1 {
    private static final z2 zzb;
    private int zzd;
    private r0 zze = h1.f9791d;
    private String zzf = "";

    static {
        z2 z2Var = new z2();
        zzb = z2Var;
        l0.h(z2.class, z2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new z2();
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
