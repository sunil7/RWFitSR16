package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class n extends l0 implements b1 {
    private static final n zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        n nVar = new n();
        zzb = nVar;
        l0.h(n.class, nVar);
    }

    public static n n() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i10 == 3) {
            return new n();
        }
        if (i10 == 4) {
            return new x2(5, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }

    public final String o() {
        return this.zzh;
    }

    public final String p() {
        return this.zze;
    }

    public final String q() {
        return this.zzj;
    }

    public final String r() {
        return this.zzi;
    }

    public final String s() {
        return this.zzg;
    }

    public final String t() {
        return this.zzf;
    }

    public final String u() {
        return this.zzk;
    }
}
