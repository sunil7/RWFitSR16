package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class n2 extends l0 implements b1 {
    private static final n2 zzb;
    private int zzd;
    private r0 zzf;
    private int zzg;
    private b3 zzh;
    private a3 zzi;
    private y2 zzj;
    private int zzk;
    private r0 zzl;
    private byte zzm = 2;
    private int zze = 17;

    static {
        n2 n2Var = new n2();
        zzb = n2Var;
        l0.h(n2.class, n2Var);
    }

    public n2() {
        h1 h1Var = h1.f9791d;
        this.zzf = h1Var;
        this.zzl = h1Var;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\b\u0000\u0001\u0001\u000f\b\u0000\u0002\u0004\u0001᠌\u0000\u0003Л\u0004င\u0001\u0005ᐉ\u0002\u0006ᐉ\u0003\u0007င\u0005\b\u001b\u000fᐉ\u0004", new Object[]{"zzd", "zze", c.f9741i, "zzf", d.class, "zzg", "zzh", "zzi", "zzk", "zzl", e.class, "zzj"});
        }
        if (i10 == 3) {
            return new n2();
        }
        if (i10 == 4) {
            return new x2(8, zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzm = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
