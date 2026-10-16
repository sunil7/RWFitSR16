package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class a extends l0 implements b1 {
    private static final a zzb;
    private int zzd;
    private b zze;
    private boolean zzf;

    static {
        a aVar = new a();
        zzb = aVar;
        l0.h(a.class, aVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new a();
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
