package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class n extends l0 implements b1 {
    private static final n zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private m zzj;
    private m zzk;

    static {
        n nVar = new n();
        zzb = nVar;
        l0.h(n.class, nVar);
    }

    public static n p() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i10 == 3) {
            return new n();
        }
        if (i10 == 4) {
            return new lb.k(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }

    public final m n() {
        m mVar = this.zzk;
        return mVar == null ? m.t() : mVar;
    }

    public final m o() {
        m mVar = this.zzj;
        return mVar == null ? m.t() : mVar;
    }

    public final String q() {
        return this.zzf;
    }

    public final String r() {
        return this.zzg;
    }

    public final String s() {
        return this.zzh;
    }

    public final String t() {
        return this.zzi;
    }

    public final String u() {
        return this.zze;
    }
}
