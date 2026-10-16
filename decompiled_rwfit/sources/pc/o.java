package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0;

/* loaded from: classes.dex */
public final class o extends l0 implements b1 {
    private static final o zzb;
    private int zzd;
    private com.google.android.gms.internal.mlkit_vision_barcode_bundled.n zze;
    private r0 zzh;
    private r0 zzi;
    private r0 zzj;
    private r0 zzk;
    private String zzl;
    private byte zzm = 2;
    private String zzf = "";
    private String zzg = "";

    static {
        o oVar = new o();
        zzb = oVar;
        l0.h(o.class, oVar);
    }

    public o() {
        h1 h1Var = h1.f9791d;
        this.zzh = h1Var;
        this.zzi = h1Var;
        this.zzj = h1Var;
        this.zzk = h1Var;
        this.zzl = "";
    }

    public static o o() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0004\u0001\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004\u001b\u0005\u001b\u0006\u001a\u0007Л\bဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", com.google.android.gms.internal.mlkit_vision_barcode_bundled.o.class, "zzi", q.class, "zzj", "zzk", com.google.android.gms.internal.mlkit_vision_barcode_bundled.m.class, "zzl"});
        }
        if (i10 == 3) {
            return new o();
        }
        if (i10 == 4) {
            return new lb.k(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzm = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final com.google.android.gms.internal.mlkit_vision_barcode_bundled.n n() {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.n nVar = this.zze;
        return nVar == null ? com.google.android.gms.internal.mlkit_vision_barcode_bundled.n.n() : nVar;
    }

    public final String p() {
        return this.zzf;
    }

    public final String q() {
        return this.zzg;
    }

    public final r0 r() {
        return this.zzk;
    }

    public final r0 s() {
        return this.zzi;
    }

    public final r0 t() {
        return this.zzh;
    }

    public final r0 u() {
        return this.zzj;
    }
}
