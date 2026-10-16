package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class s2 extends l0 implements b1 {
    private static final s2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private int zzh;
    private int zzi;
    private i2 zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;

    static {
        s2 s2Var = new s2();
        zzb = s2Var;
        l0.h(s2.class, s2Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003\u0005င\u0004\u0006ဉ\u0005\u0007ဇ\u0006\b᠌\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဂ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", c.f9752u, "zzi", "zzj", "zzk", "zzl", c.f9753v, "zzm", "zzn", "zzo", "zzp"});
        }
        if (i10 == 3) {
            return new s2();
        }
        if (i10 == 4) {
            return new x2(27, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
