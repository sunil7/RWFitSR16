package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class h2 extends l0 implements b1 {
    private static final h2 zzb;
    private int zzd;
    private int zze;
    private f2 zzh;
    private int zzj;
    private int zzk;
    private int zzn;
    private r0 zzf = h1.f9791d;
    private int zzg = -1;
    private String zzi = "";
    private q0 zzl = m0.f9803d;
    private String zzm = "";

    static {
        h2 h2Var = new h2();
        zzb = h2Var;
        l0.h(h2.class, h2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003င\u0001\u0004ဉ\u0002\u0005ဈ\u0003\u0006᠌\u0004\u0007᠌\u0005\b'\tဈ\u0006\n᠌\u0007", new Object[]{"zzd", "zze", c.f9742j, "zzf", g2.class, "zzg", "zzh", "zzi", "zzj", c.f9743k, "zzk", c.f9744l, "zzl", "zzm", "zzn", c.f9745m});
        }
        if (i10 == 3) {
            return new h2();
        }
        if (i10 == 4) {
            return new x2(17, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
