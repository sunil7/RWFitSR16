package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.z1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;

/* loaded from: classes.dex */
public final class o extends l0 implements b1 {
    private static final o zzb;
    private int zzd;
    private z1 zzf;
    private zzdf zze = zzdf.zzb;
    private int zzg = 1;
    private float zzh = 0.75f;
    private boolean zzi = true;

    static {
        o oVar = new o();
        zzb = oVar;
        l0.h(o.class, oVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ည\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ခ\u0003\u0005ဇ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i10 == 3) {
            return new o();
        }
        if (i10 == 4) {
            return new k(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
