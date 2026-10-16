package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class m extends l0 implements b1 {
    private static final m zzb;
    private int zzd;
    private int zze;
    private u0 zzg;
    private byte zzh = 2;
    private r0 zzf = h1.f9791d;

    static {
        m mVar = new m();
        zzb = mVar;
        l0.h(m.class, mVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001᠌\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zzd", "zze", c.f9736c, "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new m();
        }
        if (i10 == 4) {
            return new x2(4, zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzh = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final r0 n() {
        return this.zzf;
    }

    public final int o() {
        int i3;
        int i10 = this.zze;
        if (i10 != 0) {
            i3 = 2;
            if (i10 != 1) {
                i3 = i10 != 2 ? 0 : 3;
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
