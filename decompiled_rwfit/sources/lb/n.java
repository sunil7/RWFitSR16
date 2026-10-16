package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class n extends l0 implements b1 {
    private static final n zzb;

    static {
        n nVar = new n();
        zzb = nVar;
        l0.h(n.class, nVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0000", null);
        }
        if (i10 == 3) {
            return new n();
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
