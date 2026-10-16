package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class o extends l0 implements b1 {
    private static final o zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        o oVar = new o();
        zzb = oVar;
        l0.h(o.class, oVar);
    }

    public static o n() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", c.f9737d, "zzf"});
        }
        if (i10 == 3) {
            return new o();
        }
        if (i10 == 4) {
            return new x2(6, zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }

    public final String o() {
        return this.zzf;
    }

    public final int p() {
        int i3;
        int i10 = this.zze;
        if (i10 != 0) {
            i3 = 2;
            if (i10 != 1) {
                if (i10 != 2) {
                    i3 = 4;
                    if (i10 != 3) {
                        i3 = i10 != 4 ? 0 : 5;
                    }
                } else {
                    i3 = 3;
                }
            }
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
