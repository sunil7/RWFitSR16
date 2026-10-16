package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class a3 extends l0 implements b1 {
    private static final a3 zzb;
    private int zzd;
    private y2 zzj;
    private byte zzk = 2;
    private q0 zze = m0.f9803d;
    private p0 zzf = f0.f9780d;
    private boolean zzg = true;
    private String zzh = "";
    private String zzi = "";

    static {
        a3 a3Var = new a3();
        zzb = a3Var;
        l0.h(a3.class, a3Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0002\u0001\u0001\u0016\u0002\u0013\u0003ဇ\u0000\u0004ဈ\u0001\u0005ဈ\u0002\u000fᐉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i10 == 3) {
            return new a3();
        }
        if (i10 == 4) {
            return new v2(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzk = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
