package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class d extends l0 implements b1 {
    private static final d zzb;
    private int zzd;
    private c3 zzj;
    private y2 zzk;
    private byte zzl = 2;
    private String zze = "";
    private String zzf = "";
    private q0 zzg = m0.f9803d;
    private String zzh = "";
    private String zzi = "";

    static {
        d dVar = new d();
        zzb = dVar;
        l0.h(d.class, dVar);
        y2 n4 = y2.n();
        zzhf zzhfVar = zzhf.zza;
        if (n4 == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0007\u0000\u0001\u0001Ǵ\u0007\u0000\u0001\u0002\u0001ᔈ\u0000\u0002ဈ\u0001\u0003ࠞ\u0005ဈ\u0002\u0006ဈ\u0003\u000fᐉ\u0005Ǵဉ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", c.f9735b, "zzh", "zzi", "zzk", "zzj"});
        }
        if (i10 == 3) {
            return new d();
        }
        if (i10 == 4) {
            return new x2(2, zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzl = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
