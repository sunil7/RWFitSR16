package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class s extends l0 implements b1 {
    private static final s zzb;
    private int zzd;
    private double zze;
    private double zzf;
    private byte zzg = 2;

    static {
        s sVar = new s();
        zzb = sVar;
        l0.h(s.class, sVar);
    }

    public static s p() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔀ\u0000\u0002ᔀ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new s();
        }
        if (i10 == 4) {
            return new lb.k(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzg = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final double n() {
        return this.zze;
    }

    public final double o() {
        return this.zzf;
    }
}
