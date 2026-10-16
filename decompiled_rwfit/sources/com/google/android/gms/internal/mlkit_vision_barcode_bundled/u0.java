package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class u0 extends l0 implements b1 {
    private static final u0 zzb;
    private int zzd;
    private r0 zzf;
    private r0 zzg;
    private r0 zzh;
    private y2 zzi;
    private u0 zzj;
    private c3 zzk;
    private byte zzl = 2;
    private String zze = "";

    static {
        u0 u0Var = new u0();
        zzb = u0Var;
        l0.h(u0.class, u0Var);
        y2 n4 = y2.n();
        zzhf zzhfVar = zzhf.zza;
        if (n4 == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    public u0() {
        h1 h1Var = h1.f9791d;
        this.zzf = h1Var;
        this.zzg = h1Var;
        this.zzh = h1Var;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0007\u0000\u0001\u0002Ǵ\u0007\u0000\u0003\u0004\u0002Л\u0005Л\u0006\u001b\bᐉ\u0001\nဈ\u0000\u000bᐉ\u0002Ǵဉ\u0003", new Object[]{"zzd", "zzf", n2.class, "zzh", n2.class, "zzg", z2.class, "zzi", "zze", "zzj", "zzk"});
        }
        if (i10 == 3) {
            return new u0();
        }
        if (i10 == 4) {
            return new x2(7, zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzl = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
