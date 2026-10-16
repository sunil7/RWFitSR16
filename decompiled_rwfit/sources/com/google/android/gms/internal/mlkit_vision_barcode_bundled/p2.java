package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class p2 extends l0 implements b1 {
    private static final p2 zzb;
    private int zzd;
    private r0 zze = h1.f9791d;
    private q2 zzf;
    private a2 zzg;

    static {
        p2 p2Var = new p2();
        zzb = p2Var;
        l0.h(p2.class, p2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", u2.class, "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new p2();
        }
        if (i10 == 4) {
            return new x2(24, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
