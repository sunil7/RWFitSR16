package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class i2 extends l0 implements b1 {
    private static final i2 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        i2 i2Var = new i2();
        zzb = i2Var;
        l0.h(i2.class, i2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဇ\u0000\u0006ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new i2();
        }
        if (i10 == 4) {
            return new x2(18, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
