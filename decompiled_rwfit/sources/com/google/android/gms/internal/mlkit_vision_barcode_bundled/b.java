package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class b extends l0 implements b1 {
    private static final b zzb;
    private int zzd;
    private int zze = 4369;
    private String zzf = "";

    static {
        b bVar = new b();
        zzb = bVar;
        l0.h(b.class, bVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", c.f9755x, "zzf"});
        }
        if (i10 == 3) {
            return new b();
        }
        if (i10 == 4) {
            return new x2(1, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
