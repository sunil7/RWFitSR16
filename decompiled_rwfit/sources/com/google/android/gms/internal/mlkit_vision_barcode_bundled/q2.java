package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class q2 extends l0 implements b1 {
    private static final q2 zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        q2 q2Var = new q2();
        zzb = q2Var;
        l0.h(q2.class, q2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new q2();
        }
        if (i10 == 4) {
            return new x2(25, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
