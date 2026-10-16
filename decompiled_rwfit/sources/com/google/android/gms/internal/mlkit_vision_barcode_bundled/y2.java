package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class y2 extends i0 {
    private static final y2 zzd;
    private byte zze;

    static {
        y2 y2Var = new y2();
        zzd = y2Var;
        l0.h(y2.class, y2Var);
    }

    public y2() {
        this.zzb = e0.f9773c;
        this.zze = (byte) 2;
    }

    public static y2 n() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i10 == 2) {
            return new i1(zzd, "\u0003\u0000", null);
        }
        if (i10 == 3) {
            return new y2();
        }
        if (i10 == 4) {
            return new x2(0, zzd);
        }
        if (i10 == 5) {
            return zzd;
        }
        this.zze = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
