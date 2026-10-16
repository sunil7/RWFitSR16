package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class l extends l0 implements b1 {
    private static final l zzb;
    private int zzd = 0;
    private Object zze;

    static {
        l lVar = new l();
        zzb = lVar;
        l0.h(l.class, lVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zze", "zzd", n.class, p.class, o.class});
        }
        if (i10 == 3) {
            return new l();
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
