package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class m extends l0 implements b1 {
    private static final m zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    static {
        m mVar = new m();
        zzb = mVar;
        l0.h(m.class, mVar);
    }

    public static m t() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i10 == 3) {
            return new m();
        }
        if (i10 == 4) {
            return new lb.k(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }

    public final int n() {
        return this.zzg;
    }

    public final int o() {
        return this.zzh;
    }

    public final int p() {
        return this.zzi;
    }

    public final int q() {
        return this.zzf;
    }

    public final int r() {
        return this.zzj;
    }

    public final int s() {
        return this.zze;
    }

    public final boolean u() {
        return this.zzk;
    }
}
