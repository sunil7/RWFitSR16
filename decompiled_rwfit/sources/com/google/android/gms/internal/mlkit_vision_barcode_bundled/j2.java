package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class j2 extends l0 implements b1 {
    private static final j2 zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        j2 j2Var = new j2();
        zzb = j2Var;
        l0.h(j2.class, j2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            c cVar = c.f9749q;
            c cVar2 = c.f9747o;
            c cVar3 = c.f9748p;
            return new i1(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", cVar, "zzg", "zzh", cVar2, "zzi", cVar3, "zzj", cVar3, "zzk", cVar3, "zzl", "zzm"});
        }
        if (i10 == 3) {
            return new j2();
        }
        if (i10 == 4) {
            return new x2(19, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
