package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class k2 extends l0 implements b1 {
    private static final k2 zzb;
    private int zzd;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private int zzm;
    private int zzn;
    private boolean zzo;
    private int zze = -1;
    private zzdf zzh = zzdf.zzb;
    private String zzi = "";
    private boolean zzk = true;
    private boolean zzl = true;

    static {
        k2 k2Var = new k2();
        zzb = k2Var;
        l0.h(k2.class, k2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            c cVar = c.r;
            c cVar2 = c.f9750s;
            return new i1(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zzd", "zze", "zzf", "zzg", cVar, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", cVar2, "zzn", cVar2, "zzo"});
        }
        if (i10 == 3) {
            return new k2();
        }
        if (i10 == 4) {
            return new x2(20, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
